--20.05.22


----------------------------------------------------------
--sub query
----------------------------------------------------------

--평균 급여를 구하는 쿼리문을 서브 쿼리로 사용하여
--평균 급여보다 더 많은 급여를 받는 사원을 검색하는 문장은 다음과 같습니다.
select avg(sal) from emp;

select *
from emp
where sal >2073.214285714285714285714285714285714286
;

--서브쿼리를 사용하면 2073부분에 쿼리문이 들어가게 할수 있다.
--서브쿼리의 결과는 단일행, 단일열이 나와야 한다.
select *
from emp
where sal >(select avg(sal) from emp)
;

SELECT DNAME
FROM DEPT
WHERE DEPTNO = ( SELECT DEPTNO
 
 
FROM EMP
 
 
WHERE ENAME='SCOTT' );

select deptno
from emp
where ename ='SCOTT';

select *
from emp
where deptno=20
;


select *
from emp
where deptno=(select deptno
from emp
where ename ='SCOTT')
;

--다중 행 서브 쿼리
--in >>값을 비교. 일치. 값을 다 비교처리. or연산이 필요할때
--exist>>존재여부. 하나만족하는 순간 빠져나옴. 성능이 더 좋음.

--3000 이상 받는 사원이 소속된 부서(10번, 20번)와 
--동일한 부서에서 근무하는 사원이기에 
--서브 쿼리의 결과 중에서 하나라도 일치하면 참인 결과를 구하는 IN 연산자와 함께 사용
SELECT *
from emp
where deptno in(20,30)
;

select DISTINCT deptno from emp where sal>=3000;

SELECT *
from emp
where deptno in(select DISTINCT deptno from emp where sal>=3000)
;

SELECT ENAME, SAL, DEPTNO 
FROM EMP 
WHERE DEPTNO IN ( SELECT DISTINCT DEPTNO 
FROM EMP 
WHERE SAL>=3000); 

--all연산자 : and연산과 같다.
--30번 소속 사원들 중에서 
--급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사람의 
--이름, 급여를 출력하는 쿼리문을 작성

--30번 부서의 급여
select sal from emp where deptno=30;

SELECT ENAME, SAL 
FROM EMP 
WHERE SAL > ALL(SELECT SAL 
 FROM EMP 
 WHERE DEPTNO =30); 
 
SELECT ENAME, SAL 
FROM EMP 
WHERE SAL > (SELECT max(SAL) 
 FROM EMP 
 WHERE DEPTNO =30); 
 
 --any연산자 >> 비교값보다 작냐!
 --30번인 사원들의 급여 중 
 --가장 작은 값(950)보다 많은 급여를 받는 사원의 
 --이름, 급여를 출력
 
 select min(sal) from emp where deptno=30;
 
 select ename, sal from emp where sal > 950;

select ename, sal from emp 
where sal > (select min(sal) from emp where deptno=30); 

SELECT ENAME, SAL 
FROM EMP 
WHERE SAL > ANY ( SELECT SAL 
 FROM EMP 
 WHERE DEPTNO = 30 ); 
 
 --------------------------------------------------------------------------
 --부속질의
 --------------------------------------------------------------------------
 
 --ROWNUM
 --입력순서의 번호
 select rownum, ename
 from emp;
 
 --스칼라 부속질의>>컬럼을 표현
 
 --마당서점의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액을 출력).
select *
from orders o, customer c
where o.custid=c.custid --외래키 custid사용
;

select o.custid, name, sum(saleprice)
from orders o, customer c --대상으로 하는 로우
where o.custid=c.custid  --대상으로 하는 로우
group by o.custid,name --결과를 기준으로 그룹핑
;

select custid,
(select name from customer c where o.custid=c.custid)as custom_name ,
sum(saleprice)
from orders o
GROUP by custid
;
 
SELECT ( SELECT name
FROM Customer cs
WHERE cs.custid=od.custid ) "name", 
SUM(saleprice) "total"
FROM Orders od
GROUP BY od.custid;

--인라인뷰
--from 절에서 사용
--원하는 테이블만 쪼개서 가상테이블로 만들어 사용 >> 뷰

--고객번호가 2 이하인 고객의 판매액을 보이시오
--(결과는 고객이름과 고객별 판매액 출력)
select *
from customer where custid <=2;

select cs.name
from customer cs, orders od --전체고객
where cs.custid=od.custid
GROUP by cs.name
;

select cs.name, sum(od.saleprice)
from (select *
from customer where custid <=2) cs, orders od 
where cs.custid=od.custid
GROUP by cs.name
;

select ROWNUM, ename from emp;

select ROWNUM, ename, empno, sal
from (select ename, empno, job, deptno, sal from emp ORDER by sal DESC)
where ROWNUM <=3 --top3를 뽑아야 하는데 어떤기준으로 어디서잘라야할지모를때 로우넘사용
;


SELECT cs.name, SUM(od.saleprice) "total"
FROM (SELECT custid, name
FROM Customer
WHERE custid <= 2) cs,
Orders od
WHERE cs.custid=od.custid
GROUP BY cs.name;


--평균 주문금액 이하의 주문에 대해서
--주분번호와 금액을 보이시오.
select avg(saleprice) from orders;

select orderid, saleprice 
from orders
where saleprice <=11800
;

select orderid, saleprice 
from orders
where saleprice <=(select avg(saleprice) from orders)
;

--평균 주문금액 이하의 주문에 대해서 주문번호와 금액
select avg(saleprice) from orders where custid=1;

select orderid, custid, o.saleprice
from orders o
where saleprice > (select avg(saleprice) 
from orders a where a.custid=o.custid)
;

--중첩질의 – WHERE 부속질의 : IN, NOT IN

--대한민국에 거주하는 고객에게 판매한 도서의 총판매액
select custid from customer where address like '%대한민국%';

select sum(saleprice)
from orders 
where custid in(2,3,5)
;

select sum(saleprice)
from orders 
where custid in(select custid 
from customer where address like '%대한민국%')
;

--중첩질의 – WHERE 부속질의 : ALL, SOME(ANY)
--3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 
--주문번호와 금액

select *from orders where custid=3 order by saleprice desc;

select max(saleprice) from orders where custid=3;

select  orderid, saleprice
from orders
where saleprice > 13000
;

select  orderid, saleprice
from orders
where saleprice > (select max(saleprice) 
from orders where custid=3)
;

select  orderid, saleprice
from orders
where saleprice > all(select saleprice 
from orders where custid=3)
;

--중첩질의 – WHERE 부속질의 :EXISTS, NOT EXISTS
--EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액
select * from customer where address like '%대한민국%';

SELECT sum(o.saleprice)
from orders o
where exists(
select * from customer c 
where address like '%대한민국%' and o.custid=c.custid
)
;
SELECT sum(o.saleprice)
from orders o
where o.custid in(
select custid from customer c 
where address like '%대한민국%' and o.custid=c.custid
)
;

select * from emp;