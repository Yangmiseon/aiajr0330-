--2020-05-20//주요 함수
desc book;
desc customer;
desc orders;

--------------------------------------------------------------
--함수
--------------------------------------------------------------

--숫자함수

--mod함수 나머지값 반환
select mod(10,2)
from dual
;

--abs >>절대값 반환. 하나의 행 안에 있는 데이터들을 함수로 처리 후 결과반환
--만약 -값이 sal에 있으면 절대값으로 처리하여 보여주게됨
select abs(sal)
from emp
;

--소수점아래 잘라버리는 경우. 1이면 첫째짜리까지 2면 둘째짜리까지 0이면 정수만 표현
-- -2가 들어가면 1200이 됨.
select trunc(1282.231545,1)
from dual
;

select trunc(sal,-2)
from emp
;

--round 반올림해주는 함수 
--3이들어가면 4째자리에서 반올림해서 소수점 3째자리까지 보여줌
-- -값이 들어가면 밑에자리에서 반올림하여 뒤에 숫자는 0이됨.
select round(354546465.141592,-2)
from dual
;

--현재 시간반환 >> 필요한 이유는 현재날짜를 기준으로 처리해야 할때가 잇음
select SYSDATE
from dual
;

--TO_CHAR
--date - > VARCHAR2 형태로 변환
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY.MM.DD')
FROM DUAL;

SELECT ename, hiredate, TO_CHAR(hiredate, 'YYYY.MM.DD.dy')
FROM emp;

SELECT SYSDATE, TO_CHAR(SYSDATE, 'HH24:MI:SS') as hiredate
FROM DUAL;

--2020.05.20. 11:26
SELECT TO_CHAR(SYSDATE, 'YYYY.MM.DD. HH24:MI') as hiredate
FROM DUAL;

--TO_CHAR
--number >> VARCHAR2
--0으로 채울경우 자릿수가 맞지 않으면 0이채워짐 012,500
--9로 채울경우 자릿수가 맞지 않아도 채워지지 않음 12,500
SELECT TO_CHAR (12500, '000,000') 
FROM dual;

--자릿수가 맞지 않으면 #####이렇게 오류남. 9로채워도 마찬가지.
SELECT TO_CHAR (12500, '0,000') 
FROM dual;

--L이 붙으면 통화표현이됨.
SELECT TO_CHAR (12500, 'L999,999') 
FROM dual;

--소숫점 자릿수 절사형식으로 잘라버림(반올림됨)
SELECT TO_CHAR (125.4657468645, '999,999.99') 
FROM dual;

select sal, to_char(sal*1000, 'L999,999,999')
from emp
;

select sal, to_char(sal*1000, 'L999,999,999'),
to_char(sal*1000*12+nvl(comm,0), 'L999,999,999') as incom
from emp
order by incom desc
;

--to date
-- to date(원본, 패턴)
--문자열 str - date타입으로 바뀌게 처리
select TO_DATE('19810220', 'YYYYMMDD')
from dual;
select TO_DATE('1981/02/20', 'YYYY/MM/DD')
from dual;

SELECT ename, hiredate
from emp
where hiredate = TO_DATE('1981/02/20', 'YYYY/MM/DD')
;

--날짜를 빼서 처리 할 수 있음. 날짜를 빼면 미래가 됨
SELECT sysdate, TO_DATE('20201225', 'YYYYMMDD'),
trunc(TO_DATE ('20201225', 'YYYYMMDD')- sysdate)
from dual
;

SELECT sysdate,
trunc (sysdate-TO_DATE ('19870925', 'YYYYMMDD'))
from dual
;

----to number
-- to number(원본,패턴)
--str>>number :산출 관계 연산을 목적으로 변환
select to_number('20,000','999,999')-to_number('9,000','999,999')
from dual;


--DECODE 함수 : if switch 구문과 유사
SELECT ENAME, DEPTNO, 
DECODE(DEPTNO, 10, 'ACCOUNTING', 
               20, 'RESEARCH', 
               30, 'SALES', 
               40, 'OPERATIONS' ) 
AS DNAME
from emp
order by deptno;

--8. 직급에 따라 급여를 인상하도록 하자. 
--직급이 'ANALYST'인 사원은 5%, 
--'SALESMAN'인 사원은 10%, 
--'MANAGER'인 사원은 15%, 
--'CLERK'인사원은 20%인 인상한다. 
SELECT ENAME,  sal, job, 
DECODE(job, 'ANALYST', sal+sal*0.05, --sal*1.05
            'SALESMAN', sal+sal*0.1, --sal*1.1
            'MANAGER', sal+sal*0.15, --sal*1.15
            'CLERK', sal+sal*0.2 ) --sal*1.2
AS upsal
from emp
order by upsal;

--CASE WHEN조건 THEN결과 END >> if else if else와 유사함
--포인트 인상시킬대상자나 승급대상자나 이벤트 대상자를 확인할때 이렇게 확인해볼수있음
-- 연산 기호를 사용할 수 있어 세분화된 정보를 찾을 수도 있고, 
--숫자, 날짜형식등 다양한 데이터 모두 처리할 수 있음
--WHEN>> if와 유사함
SELECT ENAME, DEPTNO,
 
CASE WHEN DEPTNO=10 THEN 'ACCOUNTING' 
     WHEN DEPTNO=20 THEN 'RESEARCH' 
     WHEN DEPTNO=30 THEN 'SALES' 
     WHEN DEPTNO=40 THEN 'OPERATIONS'
     else 'no name'
END AS DNAME
from emp
order by deptno
;