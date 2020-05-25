--20.05.25

--마당서점
select * from book;
select * from orders;
select * from customer;

--(5) 박지성이구매한 //orders테이블
--도서의출판사수 //book테이블
select count(publisher)
from customer c, orders o, book b
where c.custid=o.custid and o.bookid=b.bookid
and c.name='박지성'
;

-- 박지성이 구매한 도서 ID
SELECT DISTINCT O.BOOKID
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID=C.CUSTID AND C.NAME='박지성'
;

SELECT COUNT(DISTINCT PUBLISHER)
FROM BOOK
WHERE BOOKID IN (
    SELECT DISTINCT O.BOOKID
    FROM ORDERS O, CUSTOMER C
    WHERE O.CUSTID=C.CUSTID AND C.NAME='박지성')
;

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select b.bookname, b.price, b.price-o.saleprice
from orders o, customer c, book b 
where c.custid=o.custid and o.bookid = b.bookid
and c.name='박지성';

--서브쿼리 사용
select custid from customer where name='박지성';
select b.bookname, b.price, b.price-o.saleprice as a
from orders o, book b
where o.bookid=b.bookid
and custid=(select custid from customer where name='박지성')
;

--(7) 박지성이구매하지않은
--도서의이름
select *
from orders o, customer c
where o.custid=c.custid and c.name !='박지성' --박지성과 동일한 사용자가 구매한 사용자가 있으면안되기때문에 !=은 하지 않음.
;

select bookname from book
where bookid not in (select bookid
from orders o, customer c
where o.custid=c.custid and c.name ='박지성')
;

--(8) 주문하지않은
--고객의이름(부속질의사용)
select c.name from orders o, customer c
where o.custid(+)=c.custid
and o.orderid is NULL;

select name
from customer
where custid not in (select distinct custid from orders)
;

select distinct custid from orders; --구매한 회원

--(9) 주문금액의총액과주문의평균금액
select sum(saleprice), avg(saleprice)
from orders
;

--(10) 고객의이름과고객별구매액
--기간으로 찾을때는 날짜로 그룹핑해주면됨.
select c.name,sum(saleprice)
from customer c, orders o
where o.custid=c.custid
group by c.name
;

--(11) 고객의이름과고객이구매한도서목록
select c.name, b.bookname
from customer c, orders o, book b
where b.bookid=o.bookid and o.custid = c.custid
;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의
--차이가가장많은주문
select max(b.price-o.saleprice)
from book b, orders o
where o.bookid=b.bookid
;

select b.bookname, b.price-o.saleprice
from book b, orders o
where o.bookid=b.bookid
and price-saleprice=(select max(b.price-o.saleprice)
from book b, orders o
where o.bookid=b.bookid)
;

--(13) 도서의판매액평균보다
--자신의구매액평균이더높은고객의이름

--고객별 구매액평균
select c.name, avg(saleprice)
from customer c, orders o
where o.custid=c.custid
group by c.name
;

--도서 구매 평균
select avg(saleprice) from orders;
select c.name, avg(saleprice)
from customer c, orders o
where o.custid=c.custid
group by c.name
having avg(saleprice)>(select avg(saleprice) from orders)
;

--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
--박지성이 구매한 출판사
select distinct b.publisher
from customer c, orders o, book b
where o.custid = c.custid and o.bookid=b.bookid
and c.name='박지성'
;
select *
from customer c, orders o, book b
where o.custid = c.custid and o.bookid=b.bookid
and b.publisher in (select distinct b.publisher
from customer c, orders o, book b
where o.custid = c.custid and o.bookid=b.bookid
and c.name='박지성')
;

select *
from customer c, orders o, book b
where o.custid = c.custid and o.bookid=b.bookid
and b.publisher in (select distinct b.publisher
from customer c, orders o, book b
where o.custid = c.custid and o.bookid=b.bookid
and c.name='박지성')
and c.name !='박지성'
;

--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
--고객별 구매한책의 출판사
select c.name, count(distinct publisher)
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
group by c.name
;

select c.name, count(distinct publisher)
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
group by c.name
having count(distinct publisher)>=2
;