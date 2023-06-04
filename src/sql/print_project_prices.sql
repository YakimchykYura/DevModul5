SELECT 'Project 1' AS name, (
    SELECT MAX(months) FROM (
     SELECT DATEDIFF('MONTH', start_date, finish_date) as months
     FROM project)) * _sum_salary AS project_prices FROM (SELECT SUM(worker.salary) AS _sum_salary
        FROM worker
        WHERE id IN (
            SELECT worker_id
            FROM project_worker
            WHERE project_id = 1)
             ) UNION
SELECT 'Project 2' AS name, (
    SELECT MAX(months) FROM (
    SELECT DATEDIFF('MONTH', start_date, finish_date) as months
    FROM project)) * _sum_salary AS project_prices FROM (SELECT SUM(worker.salary) AS _sum_salary
        FROM worker
        WHERE id IN (
            SELECT worker_id
            FROM project_worker
            WHERE project_id = 2)
            ) UNION
SELECT 'Project 3' AS name, (
    SELECT MAX(months) FROM (
    SELECT DATEDIFF('MONTH', start_date, finish_date) as months
    FROM project)) * _sum_salary AS project_prices FROM (SELECT SUM(worker.salary) AS _sum_salary
        FROM worker
        WHERE id IN (
            SELECT worker_id
            FROM project_worker
            WHERE project_id = 3)
            ) UNION
SELECT 'Project 4' AS name, (
    SELECT MAX(months) FROM (
    SELECT DATEDIFF('MONTH', start_date, finish_date) as months
    FROM project)) * _sum_salary AS project_prices FROM (SELECT SUM(worker.salary) AS _sum_salary
        FROM worker
        WHERE id IN (
            SELECT worker_id
            FROM project_worker
            WHERE project_id = 4)
            ) UNION
SELECT 'Project 5' AS name, (
    SELECT MAX(months) FROM (
    SELECT DATEDIFF('MONTH', start_date, finish_date) as months
    FROM project)) * _sum_salary AS project_prices FROM (SELECT SUM(worker.salary) AS _sum_salary
        FROM worker
        WHERE id IN (
            SELECT worker_id
            FROM project_worker
            WHERE project_id =5)
            ) UNION
SELECT 'Project 6' AS name, (
    SELECT MAX(months) FROM (
        SELECT DATEDIFF('MONTH', start_date, finish_date) as months
        FROM project)) * _sum_salary AS project_prices FROM (SELECT SUM(worker.salary) AS _sum_salary
            FROM worker
            WHERE id IN (
                SELECT worker_id
                FROM project_worker
                WHERE project_id = 6)
                ) UNION
SELECT 'Project 7' AS name, (
    SELECT MAX(months) FROM (
    SELECT DATEDIFF('MONTH', start_date, finish_date) as months
    FROM project)) * _sum_salary AS project_prices FROM (SELECT SUM(worker.salary) AS _sum_salary
        FROM worker
        WHERE id IN (
            SELECT worker_id
            FROM project_worker
            WHERE project_id = 7)
            ) UNION
SELECT 'Project 8' AS name, (
    SELECT MAX(months) FROM (
    SELECT DATEDIFF('MONTH', start_date, finish_date) as months
     FROM project)) * _sum_salary AS project_prices FROM (SELECT SUM(worker.salary) AS _sum_salary
        FROM worker
        WHERE id IN (
            SELECT worker_id
            FROM project_worker
            WHERE project_id = 8)
            ) UNION
SELECT 'Project 9' AS name, (
    SELECT MAX(months) FROM (
    SELECT DATEDIFF('MONTH', start_date, finish_date) as months
    FROM project)) * _sum_salary AS project_prices FROM (SELECT SUM(worker.salary) AS _sum_salary
        FROM worker
        WHERE id IN (
            SELECT worker_id
            FROM project_worker
            WHERE project_id = 9)
           ) UNION
SELECT 'Project 10' AS name, (
    SELECT MAX(months) FROM (
    SELECT DATEDIFF('MONTH', start_date, finish_date) as months
    FROM project)) * _sum_salary AS project_prices FROM (SELECT SUM(worker.salary) AS _sum_salary
        FROM worker
        WHERE id IN (
        SELECT worker_id
        FROM project_worker
        WHERE project_id = 10)
        ) UNION
SELECT 'Project 11' AS name, (
    SELECT MAX(months) FROM (
    SELECT DATEDIFF('MONTH', start_date, finish_date) as months
     FROM project)) * _sum_salary AS project_prices FROM (SELECT SUM(worker.salary) AS _sum_salary
        FROM worker
        WHERE id IN (
        SELECT worker_id
        FROM project_worker
        WHERE project_id = 10)
        )ORDER BY project_prices DESC;