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

insert into diary values(seq_diary_id.nextval, 'test', '�׽�Ʈ����', '�׽�Ʈ����', sysdate);
insert into diary values(seq_diary_id.nextval, 'test', '�׽�Ʈ����2', '�׽�Ʈ����2', sysdate);
insert into diary values(seq_diary_id.nextval, 'test', '�׽�Ʈ����3', '�׽�Ʈ����3', sysdate);

select * from diary;