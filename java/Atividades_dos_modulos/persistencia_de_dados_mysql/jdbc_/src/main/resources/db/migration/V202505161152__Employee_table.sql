CREATE TABLE employees(
    id BIGINT NOT NULL auto_increment PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    salary DECIMAL(10,2),
    birthday TIMESTAMP NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
