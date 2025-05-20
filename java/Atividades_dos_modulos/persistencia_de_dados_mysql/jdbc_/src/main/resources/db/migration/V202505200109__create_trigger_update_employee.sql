DELIMITER $

CREATE TRIGGER tgr_employee_audit_update BEFORE    UPDATE ON employees
    FOR EACH ROW
        BEGIN
            INSERT INTO employees_audit (
                employee_id,
                nome,
                old_nome,
                salary,
                old_salary,
                birthday,
                old_birthday,
                operation
            ) VALUES(
                NEW.id,
                NEW.nome,
                OLD.nome,
                NEW.salary,
                OLD.salary,
                NEW.birthday,
                OLD.birthday,
                'U'
            );

END $