--20.05.26

--테이블 레벨에서의 제약 조건 정의

drop table emp02;
create table emp02(
    empno number(4),
    ename VARCHAR2(10) CONSTRAINT emp02_ename_nn not null,
    job VARCHAR2(10) not null,
    deptno number(2),
    CONSTRAINT emp02_empno_pk PRIMARY KEY(empno),
    CONSTRAINT emp02_ename_uk UNIQUE(ename),
    CONSTRAINT emp02_deptno_fk FOREIGN key(deptno) REFERENCES dept(deptno)
    );
    
    
--***전화번호 관리 프로그램***
--기본 : 이름--전화번호--생일--email
--학교친구 : 전공--학년
--회사친구 : 부서이름--직급
--동호회친구 : 모임이름, 닉네임

--대리키 : 보통의 대리키는 일련번호. --컬럼이름:pIdx,p_idx  ((_idx의 방식으로 많이 사용))
-->> 마땅한 기본키가 없을때 기본키로 만들기위한 목적

--전화번호 부(contact)

CREATE TABLE P_Info(
    pIdx NUMBER(4) CONSTRAINT P_Info_pIdx_PK PRIMARY KEY,
    PNAME VARCHAR2(10)NOT NULL,
    ADD VARCHAR2(50) DEFAULT 'SEOUL',
    PNUMBER NUMBER(13) NOT NULL, 
    --하이픈없이 입력은 숫자타입으로 11자리 입력하면됨.
    EMAIL VARCHAR2(50) DEFAULT '이메일없음',
    MAJOR VARCHAR2(50),
    GRAD NUMBER(2),
    COMNAME  VARCHAR2(50),
    DNAME  VARCHAR2(50),
    JOB  VARCHAR2(50),
    CAFENAME  VARCHAR2(50),
    NICKNAME  VARCHAR2(30)
);

--컬럼 레벨 제약 정의
create table phonebook(
    pbidx number(4)  ,
    pbname varchar2(10) not null,
    pbnumber VARCHAR2(13) not null,
    pbaddr VARCHAR2(50) DEFAULT '입력 없음' not null,
    --디폴트가 먼저. 낫널은 뒤로 
    pbmail VARCHAR2(50) DEFAULT '입력 없음' not null,
    pbtype VARCHAR2(10) not null
    CONSTRAINT phonebook_pbtype_CK check(pbtype in('univ', 'com', 'cafe')),
    pbmajor VARCHAR2(20),
    pbgrade number(1) CONSTRAINT phonebook_pbgrade_CK check(pbgrade between 1 and 4),
    --체크가 들어가면 not연산자가 따로 들어가지 않아도됨
    pbcomName VARCHAR2(50),
    pbcomDept VARCHAR2(50) ,
    pbcomJob VARCHAR2(50),
    pbcafeName VARCHAR2(13),
    pbnickName VARCHAR2(13),  
   CONSTRAINT P_Info_pIdx_PK PRIMARY KEY(pbidx)
    );  

drop table phoneInfo_basic;
drop table phoneInfo_com;
drop table phoneInfo_univ;   

create table phoneInfo_basic(
    idx number(6) CONSTRAINT phoneInfo_basic_idx_pk PRIMARY key,
    fr_name varchar2(20)not null,
    fr_phonenumber VARCHAR2(20) not null,
    fr_email VARCHAR2(20),
    fr_address VARCHAR2(20),
    fr_regdate DATE DEFAULT SYSDATE
    ); 
    drop table phoneInfo_univ;
    
create table phoneInfo_univ(
    idx number(6) CONSTRAINT phoneInfo_univ_idx_pk PRIMARY key,
    fr_u_major varchar2(20) default'N' not null,
    --'N' 대소문자 주의하기.
    fr_u_year number(1) default'1' 
    CONSTRAINT phoneInfo_univ_fr_u_year_CK check(fr_u_year between 1 and 4) not null,
    fr_ref number(6) 
    CONSTRAINT phoneInfo_univ_fr_ref_FK 
    REFERENCES phoneInfo_basic(idx)on delete CASCADE
    --phoneInfo_basic(idx)>>()안에는 pk값만 들어갈수 있음.
    );    
    
create table phoneInfo_com(
    idx number(6) CONSTRAINT phoneInfo_com_idx_pk PRIMARY key,
    fr_c_company varchar2(20) default'N' not null,
    fr_ref number(6) 
    CONSTRAINT phoneInfo_com_fr_ref_FK 
    REFERENCES phoneInfo_basic(idx) on delete CASCADE
    );--on delete CASCADE를 명시하여 부모테이블을 지워도 자식테이블이 지워지도록 할 수 있음.

--예를들어 게시판에 댓글이 있는 글은 지울수 없습니다 라고 나오는 것들이 외래키로 묶여있다고 보면됨.
--삭제에 대한 이런 부분들을 고려해야 하므로 외래키 설정할때 키워드를 적어 명시할 수 있음.
    
    
    
    
    select * from dba_tablespaces; 
    select distinct tablespace_name from user_tables;
   select CONSTRAINT_NAME from user_CONSTRAINTS where owner='SCOTT';
    select * from user_CONSTRAINTS where owner='SCOTT';
    
    --fk와 참조하는 갓의 사이즈는 꼭 맞춰주어야함.
    ------------------------------------------------------------------------
    
    
    
    
    
                    ----------------------------------------
                                --1. 입력 SQL작성
                    ----------------------------------------

desc phonebook;
    
    
    --기본정보 입력
insert into phonebook(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype)
VALUES(1,'SCOTT','010-9999-1234','SEOUL','SCOTT@aa.com','univ');
--default 입력 처리 pbaddr, pbemail
insert into phonebook(pbidx, pbname, pbnumber, pbtype)
VALUES(2,'KING','010-9999-1235','univ');
    --학교 친구 정보 입력
insert into phonebook(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbmajor, pbgrade)
VALUES(3,'SON','010-8888-1234','SEOUL','SCOTT@aa.com','univ','computer','3');    
    --회사 친구 정보 입력
insert into phonebook(pbidx, pbname, pbnumber, pbtype, pbcomname, pbcomdept, pbcomjob)
VALUES(4,'HYUN','010-7777-1234','com','YEONSE','NN','MASTER'); 
    --모임 친구 정보 입력
insert into phonebook(pbidx, pbname, pbnumber, pbtype, pbcafename, pbnickname)
VALUES(5,'KIM','010-6666-1234','cafe','YENA','JJANG');     
    
    select*from phonebook;
    desc phonebook;
    TRUNCATE table phonebook;
    ---------------------------------------------------------
    --컬럼이 2개이상 비워지면 테이블을 쪼개는 것을 염두해두어야 함.
        ----------------------------------------
                    --정보 출력 질의
        ----------------------------------------
        --1. 기본 정보 출력 질의
select pbidx, pbname, pbnumber from phonebook;                        
        --2. 대학 친구 정보 출력 질의
select pbname, pbnumber, pbmajor, pbgrade from phonebook where pbtype='univ';                        
        --3. 회사 친구 정보 출력 질의
select pbname, pbnumber, pbcomname, pbcomdept,pbcomjob from phonebook where pbtype='com';                        
        --4. 모임 친구 정보 출력 질의
select pbname, pbnumber, pbcafename, pbnickname from phonebook where pbtype='cafe';         

desc phoneInfo_basic;
select * from phoneInfo_basic;
insert into phoneInfo_basic (IDX,FR_NAME,FR_PHONENUMBER, FR_EMAIL,FR_ADDRESS,FR_REGDATE )
values (1,'Seon','010-9999-4567','S@aa.com','SEOUL',SYSDATE);
insert into phoneInfo_basic (IDX,FR_NAME,FR_PHONENUMBER, FR_EMAIL,FR_ADDRESS,FR_REGDATE )
values (2,'NA','010-8888-4567','N@aa.com','SEOUL',SYSDATE);
------------------
--시퀀스 생성후
--------------------
insert into phoneInfo_basic (IDX,FR_NAME,FR_PHONENUMBER, FR_EMAIL,FR_ADDRESS,FR_REGDATE )
values (PB_BASIC_IDX_SEQ.nextval,'Seon1','010-9999-4567','S@aa.com','SEOUL',SYSDATE);

insert into phoneInfo_univ (IDX, FR_U_MAJOR, FR_U_YEAR, FR_REF)
values (PB_UNIV_IDX_SEQ.nextval,'CC','3',PB_BASIC_IDX_SEQ.currval);

insert into phoneInfo_basic (IDX,FR_NAME,FR_PHONENUMBER, FR_EMAIL,FR_ADDRESS,FR_REGDATE )
values (PB_BASIC_IDX_SEQ.nextval,'NA','010-8888-4567','N@aa.com','SEOUL',SYSDATE);

insert into phoneInfo_com (IDX, FR_C_COMPANY,FR_REF)
values (PB_COM_IDX_SEQ.nextval,'YN',PB_BASIC_IDX_SEQ.currval);


desc phoneInfo_univ;
select * from phoneInfo_univ;
insert into phoneInfo_univ (IDX, FR_U_MAJOR, FR_U_YEAR, FR_REF)
values (1,'CC','3',1);

desc phoneInfo_com;
select * from phoneInfo_com;
insert into phoneInfo_com (IDX, FR_C_COMPANY,FR_REF)
values (2,'YN',2);

select * from phoneinfo_basic;
select * from phoneInfo_univ;
select * from phoneInfo_com;
select * from phoneinfo_basic b,phoneInfo_univ u where b.idx=u.fr_ref;
select * from phoneinfo_basic b,phoneInfo_com c where b.idx=c.fr_ref;



--outer join사용
--베이직을 표현하고 싶은 것이기 때문에 반대쪽에 (+)를 해준다.
--그래야 비교해서 원하는 정보를 출력할 수 있음.
select * from phoneinfo_basic b,phoneInfo_univ u,phoneInfo_com c 
where b.idx=u.fr_ref(+) and b.idx=c.fr_ref(+);



--외래키가 들어가있을때는 하위 단계부터 drop한다.
--입력할때는 외래키의 상위가 먼저 등록이 된 후 하위가 등록이 되어야 한다.
--현재 설정은 입력이 2번들어가야 학교친구가 된다. 기본정보+학교정보 회사친구도 마찬가지.
----------------------------------------------
--수정을 위한 SQL
----------------------------------------------
--변경가능 : 이름, 전화번호, 이메일, 주소
--1.학교친구의 정보 변경<<업데이트 2개테이블
update phoneInfo_basic
set FR_NAME='guy',FR_PHONENUMBER='010-2222-7894', 
FR_EMAIL='guy@nn.com',FR_ADDRESS='PUSAN'
where idx=1
;
select * from phoneInfo_basic;
select * from phoneInfo_univ;

update phoneInfo_univ
set fr_u_major='COM', fr_u_year='2'
where fr_ref=1;
--2. 회사 친구의 정보 변경<<업데이트 2개 테이블
update phoneInfo_basic
set FR_NAME='ryu',FR_PHONENUMBER='010-3333-5891', 
FR_EMAIL='nnn@kk.com',FR_ADDRESS='SUWON'
where idx=2
;
select * from phoneInfo_basic;
select * from phoneInfo_com;

update phoneInfo_com
set fr_c_company = 'SKY'
where fr_ref=2;

------------------------------------------------------------
--삭제를 위한 SQL
------------------------------------------------------------
--외래키 설정시 부모의 행이 삭제될 때 설정
--레퍼런스 폰인포베이직(인덱스) on<< 이벤트가 발생했을때
--references phoneinfo_basic(idx) on delete 설정 옵션
--no action : 모두 삭제 불가
--cascade 참조를 하고 있는 자식 테이블의 모든 행도 삭제 
--set null : 참조를 하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 null로 변경
--set default : 참조를 하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 기본값으로 변경


--2개의 테이블이 한번에 삭제가 되어야 친구의 멤버가 완전히 삭제가 됨.
--1. 회사친구 정보를 삭제
select * from phoneInfo_basic;
select * from phoneInfo_com;
select * from phoneInfo_univ;

delete from phoneinfo_com
where fr_ref=2;
DELETE from phoneinfo_basic
where idx=2;

--2. 학교 친구 정보를 삭제
delete from phoneinfo_univ
where fr_ref=1;
DELETE from phoneinfo_basic
where idx=1;

------------------------------------------------------------
--삭제를 위한 SQL
------------------------------------------------------------
--2개의 테이블이 한번에 삭제가 되어야 친구의 멤버가 완전히 삭제가 됨.
--1. 회사친구 정보를 삭제
select * from phoneInfo_basic;
select * from phoneInfo_com;
select * from phoneInfo_univ;

delete from phoneinfo_com
where fr_ref=2;
DELETE from phoneinfo_basic
where idx=2;

--2. 학교 친구 정보를 삭제
delete from phoneinfo_univ
where fr_ref=1;
DELETE from phoneinfo_basic
where idx=1;

-------------------------------------------------------
--뷰 생성
--------------------------------------------------------
--위에 있는 질의를 간단하게 할 수 있는 뷰를 생성
--1학교, 2회사
create or REPLACE view pb_com_all
as
select b.IDX,b.FR_NAME,b.FR_PHONENUMBER, b.FR_EMAIL,b.FR_ADDRESS,b.FR_REGDATE,
       c.fr_c_company,c.fr_ref 
from phoneinfo_basic b,phoneInfo_com c 
where b.idx=c.fr_ref
;
select * from pb_com_all;

create or REPLACE view pb_univ_all
as
select b.IDX,b.FR_NAME,b.FR_PHONENUMBER, b.FR_EMAIL,b.FR_ADDRESS,b.FR_REGDATE,
       u.fr_u_major, u.fr_u_year
from phoneinfo_basic b, phoneinfo_univ u 
where b.idx=u.fr_ref
;

select * from pb_univ_all;

--전체정보출력 뷰
create or REPLACE view pb_all_view
as
select b.IDX,
       b.FR_NAME,
       b.FR_PHONENUMBER, 
       b.FR_EMAIL,
       b.FR_ADDRESS,
       b.FR_REGDATE,
       c.fr_c_company,
       c.fr_ref,
       u.fr_u_major,
       u.fr_u_year
from phoneinfo_basic b,phoneInfo_com c, phoneinfo_univ u
where b.idx=c.fr_ref(+) and b.idx=u.fr_ref(+)
;
select * from pb_all_view;
--가상테이블로 하는 검색질의 작성 



--------------------------------------------------------------------------------
            ----------------------------------
            --05.27 어제꺼 이어서 
            ----------------------------------
--------------------------------------------------------------------------------

--서브쿼리를 이용해서 여러 테이블에 한번에 데이터 삽입
--테스트 테이블 emp_hir : empno, ename, hiredate
--테스트 테이블 emp_mgr : empno, ename, mgr

create table emp_hir
as
select empno, ename, hiredate from emp where 1<0;

create table emp_mgr
as
select empno, ename, mgr from emp where 1<0;

desc emp_hir;
desc emp_mgr;
select * from emp_hir;
select * from emp_mgr;

--두개 테이블에 emp테이블의 데이터를 기반으로 삽입
--insert all into 테이블 이름 values (데이터)
insert all
into emp_hir VALUES (empno, ename, hiredate)
into emp_mgr VALUES (empno, ename, mgr)
select empno, ename, hiredate, mgr
from emp 
;


--조건(WHEN) >> if와 같다.
--when 조건 then


--WHEN 절을 추가해서 조건을 제시하여 조건에 맞는 행만 추출하여 테이블에 추가합니다. 
--EMP_HIR02 테이블에는 
--1982 년 01 월01 일 이후에 입사한 사원들의 번호, 사원 명, 입사일을 추가합니다. 
--EMP_SAL 테이블에는 
--급여가 2000 이상인 사원들의 번호, 사원 명, 급여를 추가합니다. 

create table emp_hir02
as
select empno, ename, hiredate from emp where 1<0;

create table emp_sal
as
select empno, ename, sal from emp where 1<0;

desc emp_hir02;
desc emp_sal;
select * from emp_hir02;
select * from emp_sal;

--조건에 맞을 때만 값을 추출하여 추가 저장.
insert all
when hiredate >'1982/01/01' then
into emp_hir02 values (empno, ename, hiredate)
when sal >= 2000 then
into emp_sal values (empno, ename, sal)
select empno, ename, hiredate, sal
from emp;

create table emp01
as
select * from emp
;

--컬럼의 데이터 변경(수정)
--update table 이름 셋 컬럼이름1=값, 2=값, .... where 행을 찾는 조건식
--where절이 없는 경우 테이블의 모든 행이 영향을 받는다.

select * from emp01;
--모든 사원일때는 따로 where절을 두지 않는다.
--1. 모든 사원의 부서번호를 30번으로 수정
update emp01
set deptno=30
;
--2. 모든 사원의 급여를 10% 인상시키는 UPDATE 문
update emp01
--set sal = sal+sal*0.1
set sal = sal*1.1
;

--3. 모든 사원의 입사일을 오늘로 수정
update emp01
set hiredate=sysdate
;

drop table emp01;
select * from emp01 where deptno=10;
select * from emp01;
--1. 부서번호가 10번인 사원의 
--부서번호를 30번으로 수정합시다.
UPDATE EMP01 
SET DEPTNO=30 
WHERE DEPTNO=10; 

--2. 급여가 3000 이상인 사원만 
--급여를 10% 인상합시다. 
UPDATE EMP01 
SET sal=sal*1.1
WHERE sal>=3000;

--3. 1987년에 입사한 사원의 입사일이 오늘로 수정합시다. 
--조건을 만들때는 먼저 셀렉트를 해서 내가 원하는 조건이 나오는지 먼저 확인한다.
select * from emp01
where hiredate between '1987/01/01' and '1987/12/31';

select * from emp01
where substr(hiredate, 1, 2)='87';

UPDATE EMP01 
SET hiredate = sysdate
WHERE substr(hiredate, 1, 2)='87';

--테이블에서 2개이상의 칼럼 값 변경

--1. SCOTT 사원의 
--부서번호는 10번으로, 
--직급은 MANAGER로 한꺼번에 수정
UPDATE EMP01 
SET DEPTNO=10, JOB='MANAGER' 
WHERE ENAME='SCOTT'; 

select * from emp01 where ename='SCOTT';
--2. SCOTT 사원의 입사일자는 오늘로, 급여를 50 으로 커미션을 4000 으로 수정
UPDATE EMP01 
SET hiredate=sysdate, sal=50, comm=4000 
WHERE ENAME='SCOTT'; 

--서브 쿼리를 이용한 데이터 수정

--1. 20번 부서의 지역명을 40번 부서의 지역명으로 변경하기 위해서 서브쿼리문을 사용
drop table dept01;

create table dept01
as
select * from dept;

select* from dept01;

--단일행, 단일열
update dept01
set loc=(select loc from dept01 where deptno=40)--40번 부서의 지역명 단일행 단일명이나오게 조건을 줘야함.
where deptno = 20;

--2개 이상의 컬럼에 대한 값 변경

--1. 부서 번호가 20번인 부서의 이름과 지역은 RESEARCH와 DALLAS입니다. 
--다음은 부서번호가 20인 부서의 부서명과 지역명을 
--부서번호가 40번인 부서와 동일하게 변경하기 위한 UPDATE 명령문
update dept01
set dname=(select dname from dept01 where deptno=40 ),
loc=(select loc from dept01 where deptno=40)
where deptno = 20;

--2개의 서브쿼리를 1개로 줄여 사용할 수 있다.
update dept01
set (dname,loc)=(select dname,loc from dept01 where deptno=40 )
where deptno = 20;

select * from dept01;

--테이블에 불필요한 행을 삭제하기 위한 DELETE 문
--delete from 테이블 이름 where 행을 찾을 조건식
--where 절이 없으면 모든 행에 영향을 준다.

--부서테이블의 모든 행 삭제
--실행하게 되면 몇개의 행이 영향을 받는지 나오게 된다.
--횟수가 내가 정상적으로 데이터가 처리가 되었는지 판단할 수 있다.
delete from dept01;
select * from dept01;
--외부에서 접근을 하게 되면 아직 물리적으로 저장되지 않아 4개의 행이 보임. 
--외부에서도 보이지 않게 하려면 commit해야 함.
--내부프로그램인 디벨로프에서만 지워져있기때문에 다른 프로그램에서는 다보임. 
--꼭 커밋을 해야 물리적으로 저장되어 지워지게 됨.
rollback;

--where절을 특정행을 찾는거다.
--30번인 행만 삭제가 됨.
delete from dept01 where deptno=30;

--보통은 대리키, pk를 기반으로 삭제하게 됨.

--사원 테이블에서 부서명이 SALES인 사원을 모두 삭제
select deptno from dept where dname='SALES'; --부서번호를 참조하는 쿼리문.
select * from emp01;
delete from emp01 
where deptno=(
    select deptno from dept where dname='SALES'
    );