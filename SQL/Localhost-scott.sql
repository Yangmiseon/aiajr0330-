

--로그인한 계정이 소유한 테이블 확인
SELECT * FROM tab;

--emp : 사원정보
--dept :부서정보
--bonus: 임시테이블
--salgrade : 급여 테이블

--테이블의 구조 확인 : desc 테이블이름

desc emp;

desc dept;
desc salgrade;

select * from emp;
select * from dept;

--데이터 검색 질의
SELECT ename, sal,deptno,empno --컬럼 이름
    
FROM emp -- 테이블 이름
;
select * from dept;

select 
deptno,dname
from dept;

--SELECT의 결과는 새로운 테이블이다.
--컬럼의 산술연산이 가능하다. : +, *, /, -, mod라는 함수 이용
SELECT *FROM emp;

SELECT ename, sal, comm, sal + comm FROM emp;

SELECT ename, sal, sal + 100 FROM emp;

SELECT ename, sal, sal - 100 FROM emp;

SELECT ename, sal, sal * 12 FROM emp;

SELECT ename, sal, sal/2 FROM emp;

SELECT ename, sal, job, comm, sal*12, sal*12+comm
FROM emp;

--null값 치환 함수 :nvl(컬럼명, 기본값)
--기본값은 컬럼의 도메인의 자료형과 같아야 한다.
--as사용하면 별칭을 줄수있다.
select ename, job, sal, 
nvl(comm, 100), sal*12+nvl(comm, 100) as total --별칭붙여 사용가능
from emp;

--데이터베이스의 문자열 표현 >> 작은 따옴표를 이용
--'문자열'
--문자열을 붙여서 출력하는 연산>> ||

select ename || ' 는 ' || job as msg
from emp;

--문자열 표현을 안쓰면
select ename, job as msg
from emp;

--distinct키워드를 사용하면 출력컬럼의 중복값은 제거하고 하나씩만출력
select deptno
from emp;
select distinct deptno
from emp;

select deptno, job from emp;
select deptno, job from emp order by deptno; --order by>> 오름차순 정렬
select distinct deptno, job from emp order by deptno; -->> 중복값 제거