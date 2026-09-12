# Write your MySQL query statement below
Select d.name as Department,
        e.name as Employee,
        e.salary as Salary
from employee as e
left join department as d
on e.departmentId = d.id
where e.salary = ( select max(e2.salary) from employee as e2 
                    where e2.departmentid = e.departmentid);