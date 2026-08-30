# Write your MySQL query statement below
select Department, Employee, Salary
from (
    select d.name as Department, e.name as Employee, salary as Salary,
    dense_rank() over (partition by d.id order by salary desc) as r
    from Employee e
    join Department d
    on e.departmentId=d.id
) t1
where r<=3;

