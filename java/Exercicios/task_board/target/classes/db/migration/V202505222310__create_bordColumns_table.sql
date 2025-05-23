CREATE TABLE board_columns(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    board_id BIGINT NOT NULL,
    title VARCHAR(50),
    kind VARCHAR(50) NOT NULL,
    _order INT NOT NULL,
    CONSTRAINT fk_board_id FOREIGN KEY (board_id) REFERENCES boards(id) ON DELETE CASCADE,
    CONSTRAINT uk_board_id_order UNIQUE KEY unique_board_id_order (board_id, _order)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;