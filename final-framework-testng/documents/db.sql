Create DB
-------------------------------
create database elearning default character set utf8 default collate utf8_bin;

use elearning;

create table login(username varchar(50) not null, password varchar(50));
insert into login values("admin", "admin@123");
insert into login values("boiju1", "Password1");
insert into login values("boiju2", "Password2");

create table registration(FirstName varchar(50) not null, LastName varchar(50) not null, eMail varchar(20) not null, UserName varchar(20) not null, Pass varchar(20) not null, ConfirmPass varchar(20) not null, Phone varchar(20) not null, Language varchar(20) not null);


insert into registration values("manzoor", "mehadi", "manzoor@gmail.com", "manzoor", "manzoor", "manzoor", "9876543210", "English");

insert into registration values("alex", "hales", "alex@gmail.com", "alex", "alex", "alex", "9876543211", "English");

insert into registration values("george", "bush", "george@gmail.com", "george", "george", "george", "9876543212", "English");

insert into registration values("mark", "angel", "mark@gmail.com", "mark", "mark", "mark", "9876543213", "English");

						




Select FirstName, LastName, eMail, UserName, Pass, ConfirmPass, Phone, Language
