    select 'OLDEST' as type, name, birthday  from worker
    where birthday in (select MIN(birthday) from worker)
    union
    select 'YOUNGEST' as type, name, birthday  from worker
    where birthday in (select MAX(birthday) from worker);