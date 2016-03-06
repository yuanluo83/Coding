/*

The Trips table holds all taxi trips. Each trip has a unique Id, while Client_Id and Driver_Id are both foreign keys to the Users_Id at the Users table. Status is an ENUM type of (‘completed’, ‘cancelled_by_driver’, ‘cancelled_by_client’).

+----+-----------+-----------+---------+--------------------+----------+
| Id | Client_Id | Driver_Id | City_Id |        Status      |Request_at|
+----+-----------+-----------+---------+--------------------+----------+
| 1  |     1     |    10     |    1    |     completed      |2013-10-01|
| 2  |     2     |    11     |    1    | cancelled_by_driver|2013-10-01|
| 3  |     3     |    12     |    6    |     completed      |2013-10-01|
| 4  |     4     |    13     |    6    | cancelled_by_client|2013-10-01|
| 5  |     1     |    10     |    1    |     completed      |2013-10-02|
| 6  |     2     |    11     |    6    |     completed      |2013-10-02|
| 7  |     3     |    12     |    6    |     completed      |2013-10-02|
| 8  |     2     |    12     |    12   |     completed      |2013-10-03|
| 9  |     3     |    10     |    12   |     completed      |2013-10-03| 
| 10 |     4     |    13     |    12   | cancelled_by_driver|2013-10-03|
+----+-----------+-----------+---------+--------------------+----------+
The Users table holds all users. Each user has an unique Users_Id, and Role is an ENUM type of (‘client’, ‘driver’, ‘partner’).

+----------+--------+--------+
| Users_Id | Banned |  Role  |
+----------+--------+--------+
|    1     |   No   | client |
|    2     |   Yes  | client |
|    3     |   No   | client |
|    4     |   No   | client |
|    10    |   No   | driver |
|    11    |   No   | driver |
|    12    |   No   | driver |
|    13    |   No   | driver |
+----------+--------+--------+
Write a SQL query to find the cancellation rate of requests made by unbanned clients between Oct 1, 2013 and Oct 3, 2013. For the above tables, your SQL query should return the following rows with the cancellation rate being rounded to two decimal places.

+------------+-------------------+
|     Day    | Cancellation Rate |
+------------+-------------------+
| 2013-10-01 |       0.33        |
| 2013-10-02 |       0.00        |
| 2013-10-03 |       0.50        |
+------------+-------------------+

*/
-- Create table Trips
drop table if exists Trips;
create table Trips (
  Id int(16) NOT NULL AUTO_INCREMENT,
  Client_Id int(32),
  Driver_Id int(16),
  City_Id int(16),
  Status varchar(32),
  Request_at varchar(32),
  PRIMARY KEY (Id)
);

-- Create table Users
drop table if exists Users;
create table Users (
  Users_Id int(16) NOT NULL AUTO_INCREMENT,
  Banned varchar(16),
  Role varchar(32),
  PRIMARY KEY (Users_Id)
);

-- Insert data into Scores
truncate table Trips;
insert into Trips (Client_Id, Driver_Id, City_Id, Status, Request_at)
values 
(1     ,    10     ,    1    ,     'completed'      ,'2013-10-01'),
(2     ,    11     ,    1    , 'cancelled_by_driver','2013-10-01'),
(3     ,    12     ,    6    ,     'completed'      ,'2013-10-01'),
(4     ,    13     ,    6    , 'cancelled_by_client','2013-10-01'),
(1     ,    10     ,    1    ,     'completed'      ,'2013-10-02'),
(2     ,    11     ,    6    ,     'completed'      ,'2013-10-02'),
(3     ,    12     ,    6    ,     'completed'      ,'2013-10-02'),
(2     ,    12     ,    12   ,     'completed'      ,'2013-10-03'),
(3     ,    10     ,    12   ,     'completed'      ,'2013-10-03'),
(4     ,    13     ,    12   , 'cancelled_by_driver','2013-10-03')
;

truncate table Users;
insert into Users (Users_Id ,Banned ,Role)
values 
(   1     ,   'No'   , 'client' ),
(   2     ,   'Yes'  , 'client' ),
(   3     ,   'No'   , 'client' ),
(   4     ,   'No'   , 'client' ),  
(   10    ,   'No'   , 'driver' ),
(   11    ,   'No'   , 'driver' ),
(   12    ,   'No'   , 'driver' ),
(   13    ,   'No'   , 'driver' )
;



-- A working solution, but really slow.
select total.Request_at, round(IF(cancelled.cnt, cancelled.cnt/total.cnt, 0), 2) as Cancel_rate
from
(
select Request_at,  count(Request_at) as cnt
from Trips t
where Request_at between '2013-10-01' and '2013-10-03'
and (select Banned from Users u where t.Client_Id=Users_Id)='No'
and (select Banned from Users u where t.Driver_Id=Users_Id)='No'
group by Request_at
) total
left join
(
select Request_at,  count(Request_at) as cnt
from Trips t
where Request_at between '2013-10-01' and '2013-10-03'
and (select Banned from Users u where t.Client_Id=Users_Id)='No'
and (select Banned from Users u where t.Driver_Id=Users_Id)='No'
and Status like '%cancelled%'
group by Request_at
) cancelled
on total.Request_at=cancelled.Request_at
;

-- Faster solution by eliminating a left join. Runtime beats 81.30% of mysqlsubmissions.
select grp.Request_at, round(sum(grp.cancelled)/sum(grp.cnt),2) as Cancel_rate
from
(
select Request_at,   count(Request_at) as cnt, IF(Status like '%cancelled%', count(Request_at), 0) as cancelled
from Trips t
where Request_at between '2013-10-01' and '2013-10-03'
and (select Banned from Users u where t.Client_Id=Users_Id)='No'
and (select Banned from Users u where t.Driver_Id=Users_Id)='No'
group by Request_at, Status
) grp
group by grp.Request_at
;


