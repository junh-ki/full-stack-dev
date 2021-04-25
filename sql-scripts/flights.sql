use reservation

select * from flight

insert into flight values(1,'AA1','American Airlines','AUS',
'NYC',STR_TO_DATE('03-31-2021', '%m-%d-%Y'),'2021-03-31 03:14:07');

insert into flight values(2,'AA2','American Airlines','AUS',
'NYC',STR_TO_DATE('03-31-2021', '%m-%d-%Y'),'2021-03-31 05:14:07');

insert into flight values(3,'AA3','American Airlines','AUS',
'NYC',STR_TO_DATE('03-31-2021', '%m-%d-%Y'),'2021-03-31 06:14:07');

insert into flight values(4,'SW1','South West','AUS',
'NYC',STR_TO_DATE('03-31-2021', '%m-%d-%Y'),'2021-03-31 07:14:07');

insert into flight values(5,'UA1','United Airlines','NYC',
'DAL',STR_TO_DATE('03-31-2021', '%m-%d-%Y'),'2021-03-31 10:14:07');

insert into flight values(6,'UA1','United Airlines','NYC',
'DAL',STR_TO_DATE('03-31-2021', '%m-%d-%Y'),'2021-03-31 10:14:07');

insert into flight values(7,'SW1','South West','AUS',
'NYC',STR_TO_DATE('04-01-2021', '%m-%d-%Y'),'2021-04-01 07:14:07');

insert into flight values(8,'SW2','South West','AUS',
'NYC',STR_TO_DATE('04-01-2021', '%m-%d-%Y'),'2021-04-01 08:14:07');

insert into flight values(9,'SW3','South West','NYC',
'DAL',STR_TO_DATE('04-01-2021', '%m-%d-%Y'),'2021-04-01 10:14:07');

insert into flight values(10,'UA1','United Airlines','NYC',
'DAL',STR_TO_DATE('04-01-2021', '%m-%d-%Y'),'2021-04-01 10:14:07');
