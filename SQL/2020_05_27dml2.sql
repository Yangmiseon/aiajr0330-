--20.05.27

                    ---------------------------
                     --트랜잭션
                    ---------------------------
--어떤 데이터베이스 이건 트랜잭션 처리를 해준다.
--트랜잭션 처리가 되지 않으면 어떤 처리가 실패한건지, 성공한건지 정상인지 아닌지 알수없기때문에
--프로그램상에서 처리를 해주어야 하는데 쉽지 않음.
--   -----------ㅣ--------ㅣ---------ㅣ---------ㅣ----------ㅣ
--          틀리면 롤백                                끝까지 잘 왔으면 커밋!
--인인인업인인 실패 되면 다시 인으로가거나 프로그램상에서 흐름을 만들어주거나. 
--전체가다 성공이거나 실패해서 아예처음으로 돌리던가
--마지막커밋부터 dml을 실행하면 트랜잭션 구간이됨
-- ==ㅣ====ㅣ=ㅣ커밋1 ㅣ==ㅣ=======ㅣ=====ㅣ=ㅣ커밋2 커밋1과 커밋2가 트랜잭션구간이됨.
--dml과ddl분리해서 작업하기. ddl 이나 dcl이 실행되면서 자동 커밋되기떄문에 자료들이 복구가 안될 수 있음
--
                
                    ---------------------------
                     --가상 뷰
                    ---------------------------
--뷰를 쓰는 가장큰 목적은 셀렉트. 인서트 업데이트 가능하긴하지만 제한이 있음.
--pk를 포함한 컬럼을 사용하지 않는다면 오류가 발생할 가능성이 있음.
--뷰의 목적 >> 특정데이터를 추출하기위함.
--[WITH READ ONLY];읽기전용의 셀렉트만 가능한 뷰
--CREATE OR RELPACE VIEW--
    --
--FORCE 
    --noFORCE이게 디폴트.
    
    
    ----------------------------------
    ----뷰 생성 하기--------------------
    ----------------------------------
    --논리적인 가상 테이블 : 테이블과 같이 사용 가능, 제약은 존재
    --물리적인 테이블을 기반으로 만든다. : select 서브쿼리를 이용해서 만든다.
    
    --기본적인 문법사항--
    --create [or replace] view view이름 as 서브쿼리

--자주사용되는 30번 부서에 소속된 사원들의 사번과ㅣㅇ름의 부서번호를 
--출력하기 위한 select문을 하나의 뷰로 정의해 봅니다.
create view emp_view_deptno30
as
select empno, ename, deptno from emp where deptno=30
;

select * from emp_view_deptno30;    

desc User_views;
    
SELECT VIEW_NAME, TEXT 
FROM USER_VIEWS;     
    
--1. view 객체 생성
create or REPLACE view emp_hir_view
as
select empno, ename, hiredate
from emp
order by hiredate asc
;
select * from emp_hir_view;
select ROWNUM, empno, ename, hiredate from emp_hir_view;
select ROWNUM, empno, ename, hiredate from emp_hir_view where ROWNUM<=5;
--상위 5명 추출
select ROWNUM, empno, ename, hiredate from emp ORDER by hiredate;
--가상테이블을 만들면 정렬하는 순서대로 재정렬 된다.



---------------------------------------
--sequence :번호 자동 생성기
---------------------------------------
--객체로 생각함.
--[INCREMENT BY n] n=1이 디폴트 1씩증가됨.
--테이블이름 컬럼이름 시퀀스    
--CREATE SEQUENCE 시퀀스 이름
--INCREMENT BY 증가값 << 디폴트는 1
--START WITH 시작값; << 시작은 0부터 시작.
--maxvalue 최대값
--minvalue 최소값 스타트 위드와 비슷함.
--cycle | nocycle 반복여부
--노사이클이 기본값. 사이클이 100이면 101만들면 오류. 100까지 만드러지고 다시 0부터 시작됨.
--cache | no cache 

--부서번호 deptno의 sequence 생성
create SEQUENCE dept_deptno_seq01;

select dept_deptno_seq01.nextval
from dual;
--현재 생성되어있는거 1. 계속 실행하면 숫자가 올라감.
--호출할때마다 새로운 값을 만들어냄.
select dept_deptno_seq01.currval
from dual;
--지금까지 생성되어있는 값을 알려줌.

--증가하고 외래키설정할때 커런트 밸류사용해야함.

------------------------------------------------------------
--sequence 생성
------------------------------------------------------------
--1. basic 테이블 seq
create SEQUENCE pb_basic_idx_seq
start with 0
MINVALUE 0 --<<시작값이 0이면 해줘야함. 디폴트가 1이기때문에
;
--2. com 테이블seq
create SEQUENCE pb_com_idx_seq
start with 0
MINVALUE 0
;
--3. univ테이블 seq
create SEQUENCE pb_univ_idx_seq
start with 0
MINVALUE 0
;