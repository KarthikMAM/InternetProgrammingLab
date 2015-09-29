use db;

drop table users;

create table users (
    user varchar(20),
    pass varchar(20)
);

insert into users values('karthik', '2309');
insert into users values('shanmu', '2309');

select * from users;
