DELIMITER $$
CREATE PROCEDURE prc_insert_employee(
        OUT p_id  BIGINT,
        IN p_nome VARCHAR(150),
        IN p_salary DECIMAL(10,2),
        IN p_birthday TIMESTAMP
    )
    BEGIN
    INSERT INTO employees ( nome, salary, birthday) VALUES(
            p_nome,
            p_salary,
            p_birthday
    );
    SET p_id = LAST_INSERT_ID();
END $$