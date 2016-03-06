/*

The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
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

-- a working answer.
 
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
and computed.Rank<=1
order by computed.DepartmentId, Salary desc


-- A simpler solution from leetcode website, but slower in performance:
select dep.Name as Department, emp.Name as Employee, emp.Salary 
from 	Department dep, 
		Employee emp 
where emp.DepartmentId=dep.Id and (select count(distinct Salary) 
									from Employee 
									where DepartmentId=dep.Id and Salary>emp.Salary)<1

