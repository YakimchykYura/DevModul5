SELECT id, DATEDIFF(
        'MONTH', start_date, finish_date) as months
from project p1
where (DATEDIFF(
        'MONTH', start_date, finish_date)) in (
          select (DATEDIFF(
                  'MONTH', start_date, finish_date)) as months from project p
          order by months desc limit 1);