# Write your MySQL query statement below
with ranked as(
    Select * , 
           dense_rank() over(partition by product_id order by year ) as rnk
    From sales
)
select product_id , year as first_year, quantity , price
from ranked
where rnk = 1;