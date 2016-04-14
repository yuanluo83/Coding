/*

The Employee table holds all employees. Every employee has an Id, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
| 5  | Janet | 69000  | 1            |
| 6  | Randy | 85000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who earn the top three salaries in each of the department. For the above tables, your SQL query should return the following rows.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Randy    | 85000  |
| IT         | Joe      | 70000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
+------------+----------+--------+


*/

-- Create table Employee
drop table if exists Employee;
create table Employee (
  Id int(16) NOT NULL AUTO_INCREMENT,
  Name varchar(32) DEFAULT NULL,
  Salary int(16),
  DepartmentId int(16),
  PRIMARY KEY (Id)
);

-- Insert data into Scores
insert into Employee (Name,Salary,DepartmentId)
values 
  ('Joe'   , 70000  , 1),
  ('Henry' , 80000  , 2),
  ('Sam'   , 60000  , 2),
  ('Max'   , 90000  , 1),
  ('Janet' , 70000  , 1),
  ('Randy' , 85000  , 1)
;

drop table if exists Department;
create table Department (
  Id int(16) NOT NULL AUTO_INCREMENT,
  Name varchar(32) DEFAULT NULL,
  PRIMARY KEY (Id)
);

-- Insert data into Scores
insert into Department (Name)
values 
  ('IT'),
  ('Sales')
;
select * from Employee;

-- the following answer does not take into consideration multiple entries with same hightest salary in the same department.
select d.Name as Department, computed.Name as Employee, computed.Salary as Salary
from (
	select Name, Salary, DepartmentId, @row := IF(DepartmentId=@did, @row + 1,1) as Rank , @did:=DepartmentId
	from (
		select Name, Salary, DepartmentId
		from Employee
		order by DepartmentId, Salary desc
		) ordered, (select @row:=0, @did:=0) variables
	) computed
join Department d
on computed.DepartmentId=d.Id
where computed.Rank<=3

/*
 Final Answer that beats 93.88% leedcode submissions.
 */
 
select d.Name as Department, e.Name as Employee, computed.Salary as Salary
from Employee e, 
	(
		select Salary, DepartmentId, @row := IF(DepartmentId=@did, @row + 1,1) as Rank , @did:=DepartmentId
		from (
			select distinct Salary, DepartmentId
			from Employee
			order by DepartmentId, Salary desc
			) ordered, (select @row:=0, @did:=0) variables
	) computed,
	Department d
where e.Salary=computed.Salary 
and e.DepartmentId=computed.DepartmentId 
and computed.DepartmentId=d.Id
and computed.Rank<=3
order by computed.DepartmentId, Salary desc


-- A simpler solution from leetcode website, but slower in performance:
select dep.Name as Department, emp.Name as Employee, emp.Salary 
from 	Department dep, 
		Employee emp 
where emp.DepartmentId=dep.Id and (select count(distinct Salary) 
									from Employee 
									where DepartmentId=dep.Id and Salary>emp.Salary)<3

