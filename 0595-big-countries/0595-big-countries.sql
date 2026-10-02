# Write your MySQL query statement below
select name , population, w.area 
from world as w
where w.area >= 3000000 or population >= 25000000;