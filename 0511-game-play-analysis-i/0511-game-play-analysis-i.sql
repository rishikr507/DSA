# Write your MySQL query statement below
with ranked as (
    Select * ,
           dense_rank() over(partition by player_id order by event_date asc ) as rnk
    from activity
) 
Select player_id, event_date as first_login 
from ranked
where rnk =1;