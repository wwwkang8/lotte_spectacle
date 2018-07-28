
-------------------------------------------------------------------------
CREATE TABLE lotte_member(
	id varchar2(100) PRIMARY KEY,
	password varchar2(100) not null,
	name varchar2(100) not null,
	phoneNumber varchar2(100) not null,
	sms varchar2(100)
);
drop table lotte_member
-----------------------------------------------------------------------
CREATE TABLE log_info(
	log_idx varchar2(100) PRIMARY KEY,
	log_time date not null,
	log_id varchar2(100) not null,
	log_name varchar2(100) not null,
	log_phoneNumber varchar2(100) not null,
	constraint log_id_fk foreign key(log_id) references lotte_member(id) on delete cascade
);
drop table log_info
----------------------------------------------------------------------
CREATE SEQUENCE log_seq;
DROP SEQUENCE log_seq;
----------------------------------------------------------------------

insert into LOTTE_MEMBER(id, password, name, phoneNumber, sms)
values('aaa','123','jake','01012341234','1')
select * from LOTTE_MEMBER
select * from lotte_member where id=null
select * from log_info









