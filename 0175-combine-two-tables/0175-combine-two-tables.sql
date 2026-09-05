# Write your MySQL query statement below
Select p.firstname AS firstName,
        p.lastname AS lastName,
        a.city as city,
        a.state as state
FROM person as p
LEFT JOIN
address as a
on p.personid = a.personid ;