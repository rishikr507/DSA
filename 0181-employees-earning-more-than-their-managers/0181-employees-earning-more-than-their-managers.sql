# Write your MySQL query statement below
Select e.name as Employee from employee as e 
inner join
employee as m on e.managerid = m.id 
where e.salary > m.salary;