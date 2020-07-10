--방명록 테이블

create table guestbook_message(

    message_id number(4) PRIMARY KEY,
    guest_name VARCHAR2(50) not null,
    password VARCHAR2(10) not null,
    message VARCHAR2(2000) not null
);

create sequence message_id_seq INCREMENT BY 1 START WITH 1;

insert into guestbook_message 
values (message_id_seq.NEXTVAL, '테스터01', '1111', '글쓰기1');
insert into guestbook_message 
values (message_id_seq.NEXTVAL, '테스터02', '1111', '글쓰기2');
insert into guestbook_message 
values (message_id_seq.NEXTVAL, '테스터03', '1111', '글쓰기3');
insert into guestbook_message 
values (message_id_seq.NEXTVAL, '테스터04', '1111', '글쓰기4');
insert into guestbook_message 
values (message_id_seq.NEXTVAL, '테스터05', '1111', '글쓰기5');
insert into guestbook_message 
values (message_id_seq.NEXTVAL, '테스터06', '1111', '글쓰기6');
insert into guestbook_message 
values (message_id_seq.NEXTVAL, '테스터07', '1111', '글쓰기7');
insert into guestbook_message 
values (message_id_seq.NEXTVAL, '테스터08', '1111', '글쓰기8');
insert into guestbook_message 
values (message_id_seq.NEXTVAL, '테스터09', '1111', '글쓰기9');




select * from guestbook_message order by message_id desc;

SELECT ROWNUM, message_id, message
from  guestbook_message;


select rownum, message_id,guest_name,password, message 
from(select * from guestbook_message order by message_id);
--delete from guestbook_massage;
--commit;
--
--ROLLBACK;

--가장 최근에 글쓴 순서로 출력
select rownum, message_id,guest_name,password, message 
from(select * from guestbook_message order by guestbook_message.message_id desc);

--2페이지 : 4~6
select rownum rnum, message_id,guest_name,password, message 
from(select * from guestbook_message order by guestbook_message.message_id desc
)where ROWNUM <= 6;

select message_id, guest_name, password, message
from(
    select rownum rnum, message_id,guest_name,password, message 
    from(select * from guestbook_message order by guestbook_message.message_id desc
    )where ROWNUM <= 6
)where rnum >= 4;

select count(*) from guestbook_message;