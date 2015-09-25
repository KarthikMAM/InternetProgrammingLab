######################################################################################
##Initialize the database

use db;

drop table questions;
drop table options;
drop table answers;

create table questions (
    id int,
    question varchar(50)
);

create table options (
    id int,
    options varchar(20)
);

create table answers (
    id int,
    answer varchar(20)
);

insert into questions values(1, "Who is the CEO of Microsoft?");
insert into questions values(2, "Who is the CEO of Google?");
insert into questions values(3, "Who is Steve Jobs?");

insert into options values(1, "Satya Nadella");
insert into options values(1, "Bill Gates");
insert into options values(1, "Steve Ballmer");
insert into options values(2, "Larry Page");
insert into options values(2, "Sundar Pichai");
insert into options values(2, "Sergey Brin");
insert into options values(3, "Founder of Microsoft");
insert into options values(3, "Founder of Apple");
insert into options values(3, "Founder of Google");

insert into answers values(1, "Satya Nadella");
insert into answers values(2, "Larry Page");
insert into answers values(3, "Founder of Apple");

select * from questions;
select * from options;
select * from answers;
