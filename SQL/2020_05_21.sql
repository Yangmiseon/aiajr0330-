--2020.05.21.

------------------------------------------------------------
--join
-------------------------------------------------------------
SELECT * from emp;
select * from dept;

select * from emp,dept;

--의미 있는 데이터들의 조인.
select ename, dname
from emp, dept 
where emp.deptno = dept.deptno;

--별칭을 붙여줄경우
select ename, dname
from emp e, dept d
where e.deptno = d.deptno;

--컬럼명 앞에 어느 테이블인지 식별해주어야 함.
select e.ename, d.dname,d.deptno --<<deptno앞에 별칭이 붙지 않으면 어느쪽 deptno인지 몰라 오류가 생김.
from emp e, dept d
where e.deptno = d.deptno;


--book, customer, orders
--cross JOIN
select *
from orders o, book b, customer c
;

--조건주기
select *
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
;

--(3) 박지성의총구매액(박지성의고객번호는1번으로놓고작성)
select *
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
and name = '박지성'
;

select *from emp;
select * from salgrade;

select s.losal, e.sal, s.hisal
from emp e, salgrade s
where e.sal>=s.losal and e.sal<=s.hisal;

select ename, sal, s.grade
from emp e, salgrade s
--where e.sal>=s.losal and e.sal<=s.hisal;
where sal BETWEEN losal and hisal;

SELECT ENAME, SAL, GRADE
FROM EMP, SALGRADE 
WHERE SAL BETWEEN LOSAL AND HISAL;

--self JOIN
--관리자의 이름을 알아보자
select * from emp;

select* from emp e, emp m
where e.mgr = m.empno;

--상사의 이름을 출력
--별칭을 써주지 않으면 에러남.
select e.ename ||'의 상사는'|| m.ename||'입니다'
from emp e, emp m
where e.mgr = m.empno;

--Outer Join
select e.ename ||'의 상사는'|| m.ename||'입니다'
FROM emp e, emp m
WHERE e.mgr = m.empno(+);

select e.ename, e.empno, e.sal, e.comm, nvl(m.ename,'관리자 없음') --||'의 상사는'|| m.ename||'입니다'
FROM emp e, emp m
WHERE e.mgr = m.empno(+);

--ANSI JOIN
--표준이라고 하는 sql언어.
--CROSS JOIN
SELECT * 
FROM EMP CROSS JOIN DEPT;

--INNER JOIN
--별칭은 대소문자 가림.
select ename, dname
from emp e inner join dept d
on e.deptno = d.deptno;

SELECT * FROM table1 INNER JOIN table2 
ON table1.column1 = table2.column2;

SELECT ENAME, DNAME 
FROM EMP INNER JOIN DEPT
USING (DEPTNO);

--natural join
select ename, dname
from emp natural join dept;

--outer join
select *
from emp e left outer join emp m
on e.mgr=m.empno;