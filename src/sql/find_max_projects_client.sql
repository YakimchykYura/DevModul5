SELECT client.name, project.project_count
FROM client
         JOIN  (
    SELECT client_id, COUNT(id) AS project_count
    FROM project
    GROUP BY client_id
)
    project ON client.id = project.client_id
WHERE project.project_count >= (
    SELECT MAX(project_count)
    FROM (
             SELECT COUNT(id) AS project_count
             FROM project
             GROUP BY client_id
         ) AS max_project_count);