use mydb;

create table product(
id int PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3) 
);
insert into product values(102,'Mukesh','Mumbai',12.25);
insert into product values(103,'Pankaj','Mumbai',5.25);
insert into product values(104,'Abhishek','Dehli',112.25);
insert into product values(105,'Suraj','Nasik',15.25);
select * from product;
commit;