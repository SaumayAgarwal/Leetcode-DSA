# Write your MySQL query statement below
select s.user_id, ifnull(confirmation_rate, 0) as confirmation_rate
from Signups s
left join (
    select user_id, (round(sum(action="confirmed")/count(action), 2))as confirmation_rate
    from Confirmations
    group by user_id
) t1 
on s.user_id=t1.user_id;