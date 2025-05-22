CREATE VIEW view_employee_audit AS 
    SELECT  employee_id,
            nome,
            old_nome,
            salary,
            old_salary,
            birthday,
            old_birthday,
            operation
    FROM employees_audit
    ORDER BY create_at;