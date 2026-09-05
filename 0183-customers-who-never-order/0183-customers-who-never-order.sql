# Write your MySQL query statement below
Select c.name as Customers
From Customers as c
left join orders as o
on c.id = o.customerId
where o.id is null;