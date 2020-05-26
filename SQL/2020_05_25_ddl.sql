--20.05.25

------------------------------------------------------------
--DDL
------------------------------------------------------------

--테이블 생성
--create table 테이블의 이름(); <<괄호 안에 컬럼을 정의
--(컬럼명1 타입(사이즈), 컬럼명2 타입(사이즈), 컬럼명3 타입(사이즈),..............)
--ddl_test라는 이름의 테이블을 생성
--컬럼1 : no 숫자타입 사이즈는 3
--컬럼2 : name 가변 문자열 저장 사이즈는 10
--컬럼3 : birth 날짜타입 
-->>DEFAULT sysdate기본값은 현재 날짜와 시간 날짜를 입력하지 않으면 현재 시간이 저장됨

create table ddl_test(
    no number(3),
    name VARCHAR2(10),
    birth date DEFAULT sysdate)
;

desc ddl_test;
select * from tab;

select * from ddl_test;

insert into ddl_test(no, name) VALUES (1, 'SCOTT');

--emp 테이블 참조
--사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 
--EMP01 테이블을 생성
desc emp;

create table emp_01(
    empno number(4),
    enmae VARCHAR2(10),
    sal NUMBER(7,2)
);

select * from tab;
select * from emp_01;
desc emp_01;

--테이블의 복사 : 서브 쿼리 이용 >> 스키마 복사, 행 복사, 단, 제약조건의 복사는 되지 않는다.
--백업용으로 사용하기도 함.
create table emp_02
as
select * from emp; -->> 셀렉뒤에 컬럼을 지정해주면 지정된 컬럼으로만 생성

select * from emp_02;

--지정된 컬럼만 생성
--emp테이블의 empno와 ename 컬럼만 복사해서 새로운 테이블 emp03생성
create table emp03
as
select empno,ename from emp;

select * from emp03;
desc emp03;

--emp 테이블의 10번 부서의 데이터만 복사해서 새로운 테이블
--emp05테이블을 생성하자
CREATE TABLE EMP04 
AS 
SELECT * FROM EMP 
WHERE DEPTNO=10; 
select * from emp04;

--emp 테이블의 스키마 구조만 복사해서 새로운 테이블 emp04생성
--반드시 모든행에 대해 false가 나오게 한다. << 데이터는 가져오지 않고 구조만 가져오게 된다.
CREATE TABLE EMP05 
AS 
SELECT * FROM EMP WHERE 1<0; 
select * from emp05;

--테이블에 컬럼 추가
--alter table 테이블 이름 add (컬럼정의)
--emp01테이블에 직급(job) 컬럼을 추가하자
desc emp_01;

alter table emp_01 add(job VARCHAR2(10));


--컬럼의 변경(수정)
--alter table 테이블 이름 modify(컬럼정의)
--직급(job) 칼럼을 최대 30글자까지 저장할 수 있게 변경해 보도록 하자
--MODIFY가 낫널이면  영향이 없지만 기존의 데이터들은 널이들어감. 외래키는 변경이 되지 ㅇ낳음.
--사이즈의 경우는 뒤가 다 잘림. 기존의 데이터들은 잘리기때문에 늘리는 쪽으로 함.
--따로 경고를 주거나 하지 않기때문에 항상 주의해야함.
--자동포맷이 되기 때문에 복구가되지 않음.
--정기적으로 백업해두는것은 가져올수있으나 그 직전의 것은 안됨.
alter table emp_01 MODIFY(job VARCHAR2(30) not null);

--컬럼의 삭제
--alter table 테이블이름 drop column 이름
alter table emp_01 drop column sal;
desc emp_01;

--테이블 객체 삭제<<원래 남아있던 데이터들 모두 삭제
--drop table 테이블이름;
DROP TABLE emp_01;

--로우를 제거하기 위한 명령어
--데이터를 삭제할땐 주로 dalete를 사용. trucate는 가급적 사용하지 않음.
--복구할수있는 시점자체를 잃을 수 있기때문에 주의해야함.
select * from emp_02;
TRUNCATE table emp_02;



--테이블 이름의 변경
--rename 현재 테이블 이름 to 새로운 테이블 이름
rename emp_02 to t_emp;
select * from t_emp;
select * from tab;

desc dept;
insert into dept values(10,'test', 'SEOUL');






---------------------------------------------------------------------------
--제약조건
---------------------------------------------------------------------------
--not null 제약 : 컬럼의 값에 null 값을 허용하지 않는다.
--컬럼 레벨에서만 정의가 가능
 create table emp01 (
     empno number(4) not null
 )

 create table emp01 (
    empno number(4) ,
    primary key(empno)
);
--not null 제약 : 컬럼의 값에 null 값을 허용하지 않는다.
-- 컬럼 레벨에서만 정의가 가능

--사원 테이블(EMP02)을 
--사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성하되 
--이번에는 사원번호와 사원명에 NOT NULL 조건을 지정
--제약 조건은 칼럼명과 자료형을 기술한 후에 연이어서 NOT NULL을 기술

create table emp02(
    empno number(4) not null,
    ename VARCHAR2(10) not null,
    job VARCHAR2(10),
    deptno number(2)
    );
    
desc emp02;

insert into emp02 VALUES (null, null,'MANAGER', 10);
insert into emp02 VALUES (1111, null,'MANAGER', 10);
insert into emp02 VALUES (1111, 'SON','MANAGER', 10);

select * from emp02;

--UNIQUE:유일성, 중복허용안함
drop table emp03;

create table emp03(
    empno number(4) UNIQUE,
    ename VARCHAR2(10) not null,
    JOB VARCHAR2(10), 
    DEPTNO NUMBER(2) 
);
desc emp03;

insert into emp03 VALUES(1111,'test','manager',10);
insert into emp03 VALUES(1111,'test123','manager',20);
insert into emp03 VALUES(null,'test123','manager',20);

select * from emp03;

--개선

create table emp03(
    empno number(4) UNIQUE not null,--여러가지 제약조건들을 줄수 있음.
    ename VARCHAR2(10) not null,
    JOB VARCHAR2(10), 
    DEPTNO NUMBER(2) 
);

--사원번호, 사원명, 
--직급, 부서번호 4개의 칼럼으로 구성된 
--EMP04 테이블을 생성하되
--사원번호에는 유일키로 사원명은 NOT NULL 제약조건을 설정

drop table emp04;
create table emp04(
    EMPNO NUMBER(4) CONSTRAINT EMP04_EMPNO_UK UNIQUE 
                    CONSTRAINT EMP04_EMPNO_NN not null, 
    ENAME VARCHAR2(10) CONSTRAINT EMP04_ENAME_NN NOT NULL, 
    JOB VARCHAR2(10), 
    DEPTNO NUMBER(2) 
    );
desc emp04;

insert into emp04 VALUES(1111,'test','manager',10);
insert into emp04 VALUES(1111,'test123','manager',20);
insert into emp04 VALUES(null,'test123','manager',20);

select * from emp04;


--사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
--테이블을 생성하되 기본 키 제약조건을 설정
--empno NUMBER(4) PRIMARY KEY <<이렇게만해도됨
--PRIMARY KEY:개체무결성조건.
create table emp05(
    empno NUMBER(4) CONSTRAINT EMP05_EMPNO_PK PRIMARY KEY , 
    ENAME VARCHAR2(10) CONSTRAINT EMP05_ENAME_NN NOT NULL, 
    JOB VARCHAR2(10), 
    DEPTNO NUMBER(2) 

);
select * from emp05;
insert into emp05 VALUES(1111,'test','manager',10);
insert into emp05 VALUES(1111,'test123','manager',20);
insert into emp05 VALUES(null,'test123','manager',20);

select * from emp06;


--FOREIGN KEY제약조건
--사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
--테이블을 생성하되 기본 키 제약조건을 설정
--deptno를 외래키로 제약조건을 설정
drop table emp07;
create table emp06(
    empno NUMBER(4) CONSTRAINT EMP06_EMPNO_PK PRIMARY KEY , 
    ENAME VARCHAR2(10) CONSTRAINT EMP06_ENAME_NN NOT NULL, 
    JOB VARCHAR2(10), 
    DEPTNO NUMBER(2) CONSTRAINT EMP06_ENAME_FK REFERENCES DEPT(DEPTNO) 

);
select * from dept;
insert into emp06 VALUES(1111,'test','manager',10);
insert into emp06 VALUES(1111,'test123','manager',20);
insert into emp06 VALUES(null,'test123','manager',20);
insert into emp06 VALUES(2222,'test123','manager',50);


select * from emp06;

--사원번호, 사원명, 직급, 부서번호, 직급, 성별 생일 7개의 칼럼으로 구성된 테이블을 생성하되
-- 기본 키 제약 조건, 외래키 제약 조건은 물로 
--CHECK 제약 조건도 설정
--default 제약 조건으로 birthday sysdate 로 입력되도록 처리하자
CREATE TABLE EMP07( 
EMPNO NUMBER(4) CONSTRAINT EMP07_EMPNO_PK PRIMARY KEY , 
ENAME VARCHAR2(10) CONSTRAINT EMP07_ENAME_NN NOT NULL, 
JOB VARCHAR2(10) default 'MANAGER',
DEPTNO NUMBER(2) CONSTRAINT EMP07_ENAME_FK REFERENCES DEPT(DEPTNO),
GENDER VARCHAR2(1) CONSTRAINT EMP07_GENDER_CK CHECK (GENDER IN('M', 'F')),-- CHECK (GENDER='M' or GENDER='F')
SAL NUMBER(7, 2) CONSTRAINT EMP07_SAL_CK CHECK(SAL BETWEEN 500 AND 5000), 
BIRTHDAY DATE DEFAULT SYSDATE
); ------------------------------------------------------------------

CREATE TABLE EMP07(
    EMPNO NUMBER(4) CONSTRAINT EMP07_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP07_ENAME_NN NOT NULL,
    JOB VARCHAR2(10) DEFAULT 'MANAGER',
    DEPTNO NUMBER(2) CONSTRAINT EMP07_DEPTNO_FK REFERENCES DEPT(DEPTNO),--<<참조하는테이블. 
    GENDER CHAR(1) CONSTRAINT EMP07_GENDER_CK CHECK (GENDER='M' OR GENDER='F'),
    SAL NUMBER(7,2) CONSTRAINT EMP07_SAL_CK CHECK (SAL BETWEEN 500 AND 5000),
    BIRTHDAY DATE DEFAULT SYSDATE
);

INSERT INTO EMP07 VALUES (1111, 'TEST', NULL, 10, 'F', 600, NULL);
INSERT INTO EMP07 VALUES (1115, 'TEST', NULL, 10, 'M', 6000, NULL);
INSERT INTO EMP07 VALUES (1116, 'TEST', NULL, 10, 'M', 6000, NULL);


INSERT INTO EMP07 (EMPNO, ENAME, DEPTNO, GENDER, SAL) 
           VALUES (1113, 'TEST', 10, 'F', 1600);

SELECT * FROM EMP07;
