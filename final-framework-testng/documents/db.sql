Create DB
-------------------------------
create database elearning default character set utf8 default collate utf8_bin;
alter table registration add column TeachCoursesOption varchar(20) not null;
use elearning;

create table login(username varchar(50) not null, password varchar(50));
insert into login values("admin", "admin@123");
insert into login values("boiju1", "Password1");
insert into login values("boiju2", "Password2");

create table registration(FirstName varchar(50) not null, LastName varchar(50) not null, eMail varchar(20) not null, UserName varchar(20) not null, Pass varchar(20) not null, ConfirmPass varchar(20) not null, Phone varchar(20) not null, Language varchar(20) not null);

insert into registration values("SujayS0", "BhattS", "bhattS0@gmail.com", "bhatts0", "bhatts", "bhatts", "9898765002", "English", "Y")
insert into registration values("manzoor", "mehadi", "manzoor@gmail.com", "manzoor", "manzoor", "manzoor", "9876543210", "English");
insert into registration values("alex", "hales", "alex@gmail.com", "alex", "alex", "alex", "9876543211", "English");
insert into registration values("george", "bush", "george@gmail.com", "george", "george", "george", "9876543212", "English");
insert into registration values("mark", "angel", "mark@gmail.com", "mark", "mark", "mark", "9876543213", "English");

create table assessment(UserName varchar(50) not null, Password varchar(50) not null, Weight varchar(20) not null, sUserName varchar(50) not null,sPassword varchar(50) not null, Search varchar(50) not null)

insert into assessment values("bhatts9", "bhatts", "1","bhatts10","bhatts","AutomateELTC_079");


alter table assessment add column sUserName varchar(50) not null, add column sPassword varchar(50) not null;

UserName
Password

SujayS10 

