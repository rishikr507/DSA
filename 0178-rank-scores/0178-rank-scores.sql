# Write your MySQL query statement below
Select score, 
       Dense_rank() over(order by score DESC) as 'rank'
FROM Scores;