--2020.05.19

--특정 데이터를 축출하기:wherew절을 이용한다.
-- SELECT 컬럼명 FROM 테이블 이름 where 조건(true/false)

--전체 사원중의 월 급여가 3000 이상인 사원 리스트
select ename, sal
from emp
where sal >=3000
;

--전체 사원 중 10번 부서의 소속 사원의이름(ename)과 직급(job)을 출력
select ename, job
from emp
where deptno=10
;

--문자열은 ' 작은 따옴표로 표현
SELECT*  
FROM EMP
WHERE ENAME='SCOTT';

SELECT*  
FROM EMP
WHERE hiredate='80-12-17';

--논리 연산자 and >>둘다 참일때
--10번 부서 소속인 사원들 중에서 직급이 MANAGER인 사람을 검색하여
--사원명, 부서번호, 직급을 출력
SELECT *
FROM EMP
WHERE DEPTNO=10 AND JOB='MANAGER';

--논리 연산자 or >>하나라도 참일때
--10번 부서에 소속된 사원이거나 직급이 MANAGER인 사람을 검색하여
--사원명, 부서번호, 직급을 출력합시다. 
SELECT ename, deptno,job
FROM EMP
WHERE DEPTNO=10 OR JOB='MANAGER';

--논리 연산자 : NOT
--not deptno=10 //  deptno<>10 //deptno !=10
--부서번호가 10번이 아닌 사원의
--사원이름, 부서번호, 직급을 출력
SELECT
   ename, deptno,job
FROM emp
where not deptno=10;

--특정 범위내에 속하는 데이터축출 >> BETWEEN AND 이상 이하 >>범위 연산
--2000에서 3000 사이의 급여를 받는 사원 출력
--where sal >=2000 and sal <=3000//where sal BETWEEN 2000 AND 3000
--범위 연산자 : 컬럼명 BETWEEN a AND b a이상b이하
SELECT
    *
FROM emp
where sal BETWEEN 2000 AND 3000
;

--2000초과하고 3000미만의 급여를 받는 사원
--sal >2000 and sal <3000
SELECT
    *
FROM emp
where sal BETWEEN 2001 AND 2999
;

--1987입사자 리스트 출력
SELECT *
FROM emp
where hiredate>'1987-01-01'
;

--1987입사자 리스트 출력
--where hiredate>='1987-01-01' and hiredate<='87-12-31'
SELECT *
FROM emp
where hiredate between '1987-01-01' and '1987-12-31'
;

--1987이후
SELECT *
FROM emp
where hiredate>='1982-01-01'
;

--IN연산자 : 이거나 이거나 이거나 일때 사용// OR연산자를 간소화시킴
--컬럼명 in (데이터, 데이터, 데이터......)
--컬럼 = 데이터1 or 컬럼=데이터2 or 컬럼 = 데이터3 or........

--커미션이 300이거나 500이거나 1400인 사원을
--검색하기 위해 in연산자를 사용
SELECT
    *
FROM emp
where comm=300 or comm=500 or comm=1400
;

SELECT
    *
FROM emp
where comm in(300,500,1400)
;

--패턴검색 : like 연산자
--컬럼명 like 패턴
--패턴: % , _ 이용해 처리가능
--% >> 0개 이상의 문자열이 가능
--'s%' : s로 시작하는 문자열 검색
--'%s': s로 끝나는 문자열 검색
--'%s%' : s를 포함하는 문자열

--이름이 s로 시작하는 사원의 리스트

SELECT *
FROM emp
where ename like 'S%'
;

--이름이 n으로 끝나는 사원의 리스트
SELECT *
FROM emp
where ename like '%N'
;

--a를 포함하는 경우
SELECT *
FROM emp
where ename like '%A%'
;

--not like , not in
SELECT *
FROM emp
where ename not like '%A%'
;

--_ >> 1개의 자릿수 어떠한 문자가 와도 가능하다.


--null값 확인을 위한 연산잔 : is null // is not null
--컬럼명 is null : 해당 컬럼의 값이 null인 경우 트루
--컬럼명 is not null : 해당 컬럼의 값이 null이 아닌경우가 트루

select ename, comm
from emp
where comm is null
;

select ename, comm
from emp
where comm is not null
;

--low의 정렬
--오름차순 : 작은쪽에서 큰순. asc (생략가능, 기본값)
--내림차순 : 큰쪽에서 작은순. desc(명시적사용)
SELECT ename, sal, hiredate, comm
FROM emp
where empno>0
order by ename asc -- 문자의 오름차순. asc생략가능
;

SELECT ename, sal, hiredate, comm
FROM emp
where empno>0
order by sal asc -- 숫자의 오름차순. asc생략가능
;

SELECT ename, sal, hiredate, comm
FROM emp
where empno>0
order by hiredate asc -- 날짜기반의 오름차순. asc생략가능
;

SELECT ename, sal, hiredate, comm
FROM emp
where empno>0
order by comm asc -- null의 오름차순. asc생략가능
;

--급여 내림차순 이름 오름차순
SELECT ename, sal, hiredate, comm
FROM emp
where empno>0
order by sal desc, ename asc 
;


--이름도 오름차순, 부서번호도 오름차순
SELECT ename, sal,deptno, comm
FROM emp
where empno>0
order by deptno, ename 
;
