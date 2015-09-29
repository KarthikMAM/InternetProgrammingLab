use db;

drop table account;

create table account (
    user varchar(20),
    amt int
);

insert into account values('karthik', '2000');
insert into account values('shanmu', '5000');

select * from account;
