# Write your MySQL query statement below
-- select * from (Select d.name as Department,
--         e.name as Employee,
--         e.salary as Salary
-- from employee as e
-- left join department as d
-- on e.departmentId = d.id)
-- group by department
-- having Salary = max(Salary);

-- Select max(salary) from employee group by departmentId;



Select d.name as Department,
        e.name as Employee,
        e.salary as Salary
from employee as e
left join department as d
on e.departmentId = d.id
where e.salary = ( select max(e2.salary) from employee as e2 
                    where e2.departmentid = e.departmentid);