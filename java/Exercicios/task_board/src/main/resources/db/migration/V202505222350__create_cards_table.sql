CREATE TABLE cards(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    column_id BIGINT NOT NULL,
    title VARCHAR(250) NOT NULL,
    description VARCHAR(512) NOT NULL,
    crate_at TIMESTAMP NOT NULL,
    blocked BOOLEAN NOT NULL,
    blockin_reason VARCHAR(512),
    unblockin_reason VARCHAR(512),
    CONSTRAINT fk_column_id FOREIGN KEY (column_id) REFERENCES board_columns(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;