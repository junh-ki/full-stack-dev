create database projectdb

use projectdb

create table customertab(
id int PRIMARY KEY AUTO_INCREMENT,
cname varchar(20),
cemail varchar(30)
)

select * from customertab

drop table customertab
