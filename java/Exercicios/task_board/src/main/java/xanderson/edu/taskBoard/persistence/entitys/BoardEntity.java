package xanderson.edu.taskBoard.persistence.entitys;

import lombok.Data;
import java.util.List;

@Data
public class BoardEntity {
    private long id;
    private String board_name;
    private List<BoardColumnsEntity> colunas;
}
