package xanderson.edu.taskBoard.persistence.entitys;

import lombok.Data;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.List;

@Data
public class BoardColumnsEntity {
    
private long id;

private long board_id;

private String title;

private String kind;

private int _order;

private List<CardEntity> cards;

@Setter(AccessLevel.NONE)
private List<String> kinds = List.of("INITIAL", "PENDING", "FINAL", "CANCELLATION" );

}
