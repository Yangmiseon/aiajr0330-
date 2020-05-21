
--32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
SELECT d.deptno, d.dname
FROM EMP e, DEPT d
WHERE e.deptno=d.deptno 
and e.ename='SCOTT';

--33. INNER JOIN과 ON 연산자를 사용하여 
--사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
select e.ename, d.dname, d.loc
from emp e inner join dept d
on e.deptno=d.deptno;

--36. 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.
select e.ename, d.dname
from emp e inner join dept d
on e.deptno=d.deptno
where e.ename like '%A%';

select e.ename, d.dname
from emp e, dept d
where e.deptno=d.deptno 
and e.ename like '%A%';

--37. JOIN을 이용하여 NEW YORK에 근무하는 
--모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.
select e.ename, e.job, d.deptno, d.dname
from emp e inner join dept d
on e.deptno=d.deptno
where d.loc='NEW YORK';

select e.ename, e.job, e.deptno, d.dname
from emp e, dept d
where e.deptno=d.deptno
and d.loc='NEW YORK';

--38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
select e1.ename, e1.empno, e2.ename
from emp e1, emp e2
where e1.mgr=e2.empno(+);

--39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 
--사원번호를 기준으로 내림차순 정렬하여 출력하시오.
select e1.ename, e1.empno, e1.mgr, e2.ename
from emp e1 left outer join emp e2
on e1.mgr=e2.empno
order by e1.empno DESC;

select e1.ename, e1.empno, e2.ename
from emp e1, emp e2
where e1.mgr=e2.empno(+)
order by e1.empno DESC;

--40. SELF JOIN을 사용하여 
--지정한 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
SELECT e.ename, e.deptno, d.ename
FROM EMP e, emp d
WHERE e.deptno=d.deptno and e.ename='SCOTT';

SELECT e.ename, e.deptno, d.ename
FROM EMP e, emp d
WHERE e.ename='SCOTT'
and e.deptno=d.deptno 
and d.ename != 'SCOTT';

--41. SELF JOIN을 사용하여
--WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
SELECT d.ename, d.hiredate
FROM EMP e, emp d
where e.ename='WARD'
and e.hiredate < d.hiredate;

SELECT e.ename, e.hiredate, w.hiredate, w.ename
FROM EMP e, emp d
where d.ename='WARD'
and e.hiredate >= d.hiredate;

--42. SELF JOIN 을 사용하여 
--관리자보다 먼저 입사한 >>관리자보다 날짜가작아야함.
--모든 사원의 이름 및 입사일을 
--관리자의 이름 및 입사일과 함께 출력하시오. 
SELECT e.ename, e.hiredate, d.ename, d.hiredate
FROM EMP e, emp d
where e.mgr=d.empno 
and e.hiredate<d.hiredate;
