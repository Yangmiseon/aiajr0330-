--2020.05.20//그룹함수

----------------------------------------------
--그룹함수( 집합함수)
----------------------------------------------
select*from emp;
--sum, avg, count, max, min

--sum(컬럼이름) : 해당 컬럼의 데이터들의 합 반환
--매월 지급되는 급여의 총 합
select sum(sal) as totalsal
from emp;
select to_char(sum(sal)*1000,'L999,999,999') as totalsal
from emp;

--avg(컬럼명) : 해당 컬럼의 데이터들의 평균값을 반환
select trunc(avg(sal))
from emp;

select 29025/14 from dual;

select sum(comm) from emp;

--null은 포함하지 않는다.
select avg(comm)
from emp;

select * from emp ORDER by comm;

--max, min:해당 컬럼의 데이터중에서 최대값, 최소값을 반환
SELECT max(sal), min(sal), max(comm), min(comm)
from emp;

--그룹함수와 일반 컬럼을 함께 사용하지 않음.
--ename이 들어가면 오류생김.
--SELECT ename, max(sal), min(sal), max(comm), min(comm)
--from emp;

--count(컬럼명 or *) : 행 (row)의 개수를 반환
--*>> 별이 들어가면 특정 컬럼이 아닌 모두 구할때 null은 포함되지 않음.
SELECT count(*) from emp; --emp테이블에 저장된 전체갯수가 출력됨

SELECT count(comm)--null을 포함하는 행은 개수로 세지 않는다.
from emp; 

--저장된 직급의 갯수반환
SELECT count(job)
from emp;

--직급의 이름을 모두 출력
SELECT job
from emp
order by job;

--중복을 제외하고 갯수만 반환
SELECT count(DISTINCT job)
from emp;

--------------------------------------------------
--group by 절
--------------------------------------------------
--그룹을 job으로 묶었으니 컬럼도 job만 사용.
--각 직급과 직급의 갯수가 출력
SELECT job, count(job)
from emp
group by job;

--group by 절: 특정 컬럼으로 그룹핑해준다.
--제품 혹은 부서별등 그룹으로 현황을 확인할 수 있음. 
SELECT deptno
from emp
group by deptno;

SELECT job
from emp
group by job;

--부서별 <<group으로 표현해야한다.
--평균 급여
SELECT deptno, trunc(AVG(SAL))
FROM EMP
GROUP BY DEPTNO;

SELECT deptno, round(AVG(SAL),0)--급여는 절사해서주지않고 반올림해서주니까!!
FROM EMP
GROUP BY DEPTNO;

desc emp;
desc ename;
select * from emp;
select * from salgrade;
select * from dept;

