create user karadsik7 identified by 11111111;

grant dba to karadsik7;

create table diary(
    id number primary key,
    u_id varchar2(15),
    title varchar2(50),
    content clob not null,
    regdate date not null
);

create sequence seq_diary_id;

insert into diary values(seq_diary_id.nextval, 'test', '테스트제목', '테스트본문', sysdate);
insert into diary values(seq_diary_id.nextval, 'test', '테스트제목2', '테스트본문2', sysdate);
insert into diary values(seq_diary_id.nextval, 'test', '테스트제목3', '테스트본문3', sysdate);

desc diary;

select * from diary;