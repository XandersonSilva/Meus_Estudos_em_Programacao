package xanderson.edu.taskBoard.persistence.entitys;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CardEntity {
private long id;
private long column_id;
private String title;
private String description;
private OffsetDateTime create_at;
private boolean blocked;
private String blockin_reason;
private String unblockin_reason;
}
