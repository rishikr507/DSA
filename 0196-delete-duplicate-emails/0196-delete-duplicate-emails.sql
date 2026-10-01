
delete from person
where id in (
    select id 
    from (
        Select id, row_number() over(partition by email order by id) as rnk
        from person
    ) as t
    where rnk > 1
);
