DELIMITER $

CREATE TRIGGER tgr_employee_audit_insert AFTER INSERT ON employees
    FOR EACH ROW
        BEGIN
            INSERT INTO employees_audit (
                employee_id,
                nome,
                salary,
                birthday,
                operation
            ) VALUES(
                NEW.id,
                NEW.nome,
                NEW.salary,
                NEW.birthday,
                'I'
            );

END $