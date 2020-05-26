--20.05.26

---------------------------------
--dml
---------------------------------

drop table dept01;

create table dept01
as
select * from dept where 1<0
;--구조만 가져옴.

desc dept01;
select * from dept01;

--새로운 부서 정보를 입력 : 행단위 입력
--insert into 테이블 이름(입력하고자 하는 컬럼들) values (데이터들)
--입력 컬럼의 순서와 입력데이터의 순서는 같아야 한다.
insert into dept01 (deptno, dname, loc) values (10,'MARKETING','SEOUL');
--데이터들이 순서대로 들어감.
insert into dept01 values (20,'R*D','PUSAN');
insert into dept01 (loc, dname,deptno) values ('LONDON','SALES',10);

insert into dept01(deptno, dname) values (40,'DEV');

--빈칸없이 입력할것이기 때문에 생략가능, 하지만 순서는 지켜야함.
desc dept01;


create table dept02(
    deptno number(2) not null,
    dname VARCHAR2(20) not null,
    loc VARCHAR2(20) DEFAULT 'SEOUL'
    );
insert into dept02 (deptno, dname, loc) values (10,'MARKETING','SEOUL');
insert into dept02(deptno, dname) values (40,'DEV');
insert into dept02 (deptno, dname, loc) values (20,'MARKETING',null);
insert into dept02 (deptno, dname, loc) values (30,'MARKETING','');

--값을 입력안하면 디폴트가 들어가고 null혹은 ''(공백문자)을 입력하면 null이 들어감.
--디폴트 값을 입력하기 위해선 컬럼명시를 하지 말아야함. 필요한 컬럼기술 후 컬럼위치에 맞게 데이터를 넣어주어야 함.

--오류:컬럼이2개인데 값이 3개여서 오류가 생김.
insert into dept02(deptno, dname) values (40,'DEV','PUSAN');
--오류:컬럼이 3개인데 값이 2개여서 들어가지 않음.
insert into dept02(deptno, dname, loc) values (40,'DEV');
--오류: 컬럼명을 생략해도 값의 수가 부족하기 때문에 오류가 생김.
insert into dept02 values (40,'DEV');
--오류: 타입이 맞지 않을 때도 오류가 난다. 문자열은 '' 작은 따옴표를 붙여 주어야 함.
insert into dept02 values (40,DEV,'SUWON');

select * from dept02;

--명시하지 않았기 때문에 자연적으로 null값이 들어감.
--null은 명시적으로 넣어줄수도 있고 컬럼명지정없이 없이 값을 입력하면 알아서 들어가기도 함.

--insert구문을 만들때 앞에 null이 있는지 없는지 확실하게 봐야함.
--중복되지 않은 값을 넣기 위해 주의 해야함.
desc dept02;
--not null조건에 충족되지 않아 오류가 생김.
insert into dept02 (dname, loc) VALUES ('test','locTest');
insert into dept02 (deptno,dname, loc) VALUES (60,'test','locTest');