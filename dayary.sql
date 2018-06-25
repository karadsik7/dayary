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

desc diary;

select * from diary;


--member

create table member(
    id varchar2(10) primary key,
    password varchar2(10) not null,
    name varchar2(30) not null,
    email varchar2(30) not null unique,
    gender char(1) check(gender in('m', 'f'))
);

alter table diary add constraint fk_diary_u_id foreign key(u_id) references member(id);

desc member;
select * from member;
select * from diary;

insert into member values('rrb', '123', 'rrb', 'efijoajf@ajfoi.cao', 'm');

insert into member values('admin', '1234', '������', 'asidfoajoifjiodsf@aa.aei', 'm');

create table tag(
    id number primary key,
    d_id number references diary(id),
    name varchar2(30) not null,
    color varchar2(10) default 'default' not null
);

create sequence seq_tag_id;

desc tag;