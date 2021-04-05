create database projectdb

use projectdb

create table vendor(
id int PRIMARY KEY,
code varchar(20),
name varchar(20),
type varchar(20),
email varchar(20),
phone varchar(20),
address varchar(20)
)

insert into vendor values(3, '0000', 'BOSCH', 'EUROPE', 'DE', '49', 'GERMANY')

select * from vendor

drop table vendor
