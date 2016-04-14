/*

Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.

+---------+------------+------------------+
| Id(INT) | Date(DATE) | Temperature(INT) |
+---------+------------+------------------+
|       1 | 2015-01-01 |               10 |
|       2 | 2015-01-02 |               25 |
|       3 | 2015-01-03 |               20 |
|       4 | 2015-01-04 |               30 |
+---------+------------+------------------+
For example, return the following Ids for the above Weather table:
+----+
| Id |
+----+
|  2 |
|  4 |
+----+

*/

-- Create table Weather
drop table Weather;
create table Weather (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Date int(11),
  Temperature int(11),
  PRIMARY KEY (Id)
);

truncate table Weather;
insert into Weather (Date, Temperature)
values 
(1,10),
(2,25),
(3,20),
(4,30)
;

select * from Weather;

-- too slow, time exceed limit
select w.Id
from 
(
select w1.Id, w1.Date as yd, w2.Date as td, w1.Temperature as yt, w2.Temperature as tt
from 
Weather w1
join 
Weather w2
) w
where yd=subdate(td,1) and yt < tt
;

-- accepted solution. only beats 1.5% of submissions.
select Id
from Weather w1
where w1.Temperature is not null 
and w1.Temperature> (select Temperature from Weather where Date=subdate(w1.Date, 1));

-- ok. this is a really fast solution I came up with. It beats 100.00% of mysqlsubmissions.
select w.Id
from
(
select w1.Id, IF(@temp<w1.Temperature, true, false) as rise, IF(@date=subdate(w1.Date,1), true, false) as cont, (@temp:=w1.Temperature) as Temperature, (@date:=w1.Date) as Date
from (select * from Weather order by Date asc) w1, (select @temp:=9999, @date:=null) var
) w
where w.rise and w.cont and w.Id is not null
order by w.Id asc;

