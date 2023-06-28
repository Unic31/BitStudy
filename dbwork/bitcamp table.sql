create table bitcamp(
    num int AUTO_INCREMENT PRIMARY KEY,
    name varchar(10),
    java int check (java>0 and java<101),
    spring int check ( spring>0 and spring<101),
    today date
);


insert into bitcamp values (null,'A',50,60,now());
insert into bitcamp values (null,'B',65,80,now());
insert into bitcamp values (null,'C',98,45,now());
insert into bitcamp values (null,'D',87,70,now());
insert into bitcamp values (null,'E',98,100,now());
insert into bitcamp values (null,'F',45,57,now());
insert into bitcamp values (null,'G',22,87,now());
insert into bitcamp values (null,'H',80,80,now());
insert into bitcamp values (null,'I',100,100,now());
insert into bitcamp values (null,'J',40,45,now());


select * from bitcamp;
select num, name, java, spring, java+spring 합계, round(((java+spring)/2),2) 평균 from bitcamp; -- 1
select * from bitcamp where name like '%A'; -- 2
select * from bitcamp where name like '%A';

select * from bitcamp where name like 'e%' order by name asc;

select * from bitcamp where (java+spring)/2>=60;







