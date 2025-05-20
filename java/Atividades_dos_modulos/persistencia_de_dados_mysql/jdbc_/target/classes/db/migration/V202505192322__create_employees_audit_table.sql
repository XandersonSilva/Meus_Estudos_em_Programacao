CREATE TABLE employees_audit(
    id BIGINT NOT NULL auto_increment PRIMARY KEY,
    nome VARCHAR(150) ,
    old_nome VARCHAR(150) ,
    salary DECIMAL(10,2),
    old_salary DECIMAL(10,2),
    birthday TIMESTAMP,
    old_birthday TIMESTAMP, 
    operation CHAR(1),
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
