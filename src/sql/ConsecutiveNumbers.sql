/*

Write a SQL query to find all numbers that appear at least three times consecutively.

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

*/

drop table if exists Logs;
create table Logs 
(
	Id int(8) not null AUTO_INCREMENT,
	Num int(8),
	PRIMARY KEY (Id)
);

insert into Logs (Num)
values  (1),
		(1),
		(1),
		(2),
		(1),
		(1),
		(3),
		(3),
		(3);
		
select * from Logs;


-- Solution, Runtime beats 77% of mysqlsubmissions.
select distinct c.Num 
from
(
select Num, @prev_num, @cnt := IF(@cnt=3 or Num!=@prev_num, 1, @cnt+1) as cnt, @prev_num:=Num, IF(@cnt=3, true,false) as mark
from Logs, (select @cnt:=0, @prev_num:=0) v
) c
where mark
;

-- Faster solution: Remove the @prev_num column from inner select. Runtime beats 88.23% of mysqlsubmissions.
select distinct c.Num 
from
(
select Num, @cnt := IF(@cnt=3 or Num!=@prev_num, 1, @cnt+1) as cnt, @prev_num:=Num, IF(@cnt=3, true,false) as mark
from Logs, (select @cnt:=0, @prev_num:=0) v
) c
where mark
;
