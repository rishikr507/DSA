CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N = N-1;
    RETURN (
        SELECT distinct salary
        FROM employee 
        Order By salary DESC
        LIMIT 1 OFFSET N
  );
END