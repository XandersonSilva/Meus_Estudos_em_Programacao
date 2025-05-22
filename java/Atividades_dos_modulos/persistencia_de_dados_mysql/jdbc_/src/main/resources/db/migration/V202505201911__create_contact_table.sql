CREATE TABLE contacts(
    id BIGINT not null AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(50) NOT NULL,
    type  VARCHAR(30),
    employee_id BIGINT NOT NULL,
    CONSTRAINT fk_contats_employee FOREIGN KEY (employee_id) REFERENCES employees(id)
)