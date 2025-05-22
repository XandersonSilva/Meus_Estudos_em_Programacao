CREATE TABLE accesses(
    employee_id BIGINT NOT NULL,
    module_id BIGINT NOT NULL,
    PRIMARY KEY(employee_id, module_id),
    CONSTRAINT fk_employee_id FOREIGN KEY (employee_id) REFERENCES employees(id),
    CONSTRAINT fk_module_id FOREIGN KEY (module_id) REFERENCES modules(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

