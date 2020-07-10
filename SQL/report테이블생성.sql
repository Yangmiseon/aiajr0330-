--report테이블 생성

create table report(
    idx NUMBER(4) PRIMARY KEY,
    sname VARCHAR2(20) not null,
    sno VARCHAR(10) not null,
    reportfile VARCHAR2(100) not null
);

create SEQUENCE report_seq;

insert into report values (report_seq.nextval, '길동','1234','/file/1231234123_report.ppt');

select * from report;