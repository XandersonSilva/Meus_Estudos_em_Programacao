package xanderson.edu.taskBoard.persistence.entitys;

import java.util.List;

public class BoardColumnsEntity {
    
private long id;

private long board_id;

private String title;

private String kind;

private int _order;

private List<CardEntity> cards;

}
