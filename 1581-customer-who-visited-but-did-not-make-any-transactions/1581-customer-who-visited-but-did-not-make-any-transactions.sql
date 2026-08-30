# Write your MySQL query statement below
with cte as(
    select visit_id
    from Visits
    where visit_id not in(
        select visit_id 
        from Transactions
    )
)

select customer_id, count(customer_id) as count_no_trans
from Visits
where visit_id in (
    select visit_id from cte
) 
group by customer_id;
