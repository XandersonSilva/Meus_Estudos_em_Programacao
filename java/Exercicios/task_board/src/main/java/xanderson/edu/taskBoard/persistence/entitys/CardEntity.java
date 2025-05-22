package xanderson.edu.taskBoard.persistence.entitys;

import java.time.OffsetDateTime;

public class CardEntity {
private long id;
private long board_id;
private String title;
private String description;
private OffsetDateTime crate_at;
private String blockin_reason;
private String unblockin_reason;
}
