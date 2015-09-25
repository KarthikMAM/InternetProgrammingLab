#######################################################################################
##Initial Creation of the database

use db;

drop table student;

create table student(
    id int,
    name varchar(20),
    roll int,
    branch varchar(20),
    year int,
    semester int,
    dob varchar(20),
    address varchar(20)
);

insert into student values(1, 'Karthik', 1234, 'CSE', 3, 5, '05-01-1996', 'Chennai');
insert into student values(2, 'Karuppiah', 1235, 'CSE', 3, 5, '05-01-1996', 'Chennai');
insert into student values(3, 'Dharma', 1236, 'CSE', 3, 5, '05-01-1996', 'Chennai');
insert into student values(4, 'Anirruth', 1237, 'CSE', 3, 5, '05-01-1996', 'Chennai');
insert into student values(5, 'Akshay', 1237, 'CSE', 3, 5, '05-01-1996', 'Chennai');

select * from student;
#######################################################################################
##Sample queries

select * from student where id = 1;

update student
    set name    = 'Karthik',
        roll    = 1234,
        branch  = 'CSE',
        year    = 3,
        semester= 5,
        dob     = '05-01-1996',
        address = 'Erode'
    where id = 1;

delete from student where id = 1;

insert into student values(1, 'Karthik', 1234, 'CSE', 3, 5, '05-01-1996', 'Erode');

#######################################################################################
