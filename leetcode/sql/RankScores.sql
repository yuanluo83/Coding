/*

Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no "holes" between ranks.

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
For example, given the above Scores table, your query should generate the following report (order by highest score):

+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+

*/

-- Create table Scores
drop table Scores;
create table Scores (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Score float(11) DEFAULT NULL,
  PRIMARY KEY (Id)
);

-- Insert data into Scores
insert into Scores (Score)
values 
  (3.50)
, (3.65)
, (4.00)
, (3.85)
, (4.00)
, (3.65)
;

-- A working solution:
select * from Scores;
select a.Score, count(b.Score)
from Scores a, 
(select Score
from (
	select distinct Score 
	from Scores 
	order by Score desc
	) d
) b 
where a.Score<=b.Score
group by a.Id
order by a.Score desc; 

/*
 * faster solution: 
 * -- put the set command in a separate command doesn't work for Leetcode sql compiler.
 * -- use (select @set=0) as an alternative that works for both mysql cli and Leetcode compiler.
 */
 
--set @row=0;
select a.Score, b.Rank
from Scores a, 
(select Score, @row := @row + 1 as Rank 
from (
	select distinct Score 
	from Scores 
	order by Score desc
	) d, (select @row:=0) e
) b 
where a.Score=b.Score
order by a.Score desc; 


