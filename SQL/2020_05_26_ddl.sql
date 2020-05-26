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
    fr_ref number(6) CONSTRAINT phoneInfo_univ_fr_ref_FK REFERENCES phoneInfo_basic(idx)
    --phoneInfo_basic(idx)>>()안에는 pk값만 들어갈수 있음.
    );    
    
create table phoneInfo_com(
    idx number(6) CONSTRAINT phoneInfo_com_idx_pk PRIMARY key,
    fr_c_company varchar2(20) default'N' not null,
    fr_ref number(6) CONSTRAINT phoneInfo_com_fr_ref_FK REFERENCES phoneInfo_basic(idx)
    );     
    
    
    
    
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
