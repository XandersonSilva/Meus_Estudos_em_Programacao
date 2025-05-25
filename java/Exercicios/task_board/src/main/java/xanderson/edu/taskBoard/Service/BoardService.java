package xanderson.edu.taskBoard.Service;

import java.util.List;

import xanderson.edu.taskBoard.persistence.BoardColumnsDAO;
import xanderson.edu.taskBoard.persistence.BoardDAO;
import xanderson.edu.taskBoard.persistence.entitys.BoardColumnsEntity;
import xanderson.edu.taskBoard.persistence.entitys.BoardEntity;

public class BoardService {
    static BoardDAO boardDAO = new BoardDAO();
    static BoardColumnsDAO boardColumnsDAO = new BoardColumnsDAO();
    static BoardColumnsEntity boardColumnsEntity = new BoardColumnsEntity();


    public static void createBoard(String boardName, List<String> default_titles, List<String> PENDING_titles){
        // Possível melhoria futura: impedir a criação de boards de nome igual
        

        CoutUtil cUtil = new CoutUtil(2);
        BoardEntity board = new BoardEntity();
        board.setBoard_name(boardName);
        boardDAO.insert(board);
        
        // Criando a coluna inicial
        boardColumnsDAO.insert(board.getId(), default_titles.get(0), boardColumnsEntity.getKinds().get(0),1);

        
        // Criando as colunas pendentes de acordo com a quantidade informada pelo user
        PENDING_titles.forEach(
            t ->{
                boardColumnsDAO.insert(board.getId(), t, boardColumnsEntity.getKinds().get(1), cUtil.getCount());
                cUtil.couter();
            }
        );

        // Criando as colunas seguintes
        boardColumnsDAO.insert(board.getId(), default_titles.get(1), boardColumnsEntity.getKinds().get(2), cUtil.getCount());
        cUtil.couter();
        boardColumnsDAO.insert(board.getId(), default_titles.get(2), boardColumnsEntity.getKinds().get(3), cUtil.getCount());
    }

    public static void createBoard(String boardName, List<String> default_titles){
        CoutUtil cUtil = new CoutUtil();
        BoardEntity board = new BoardEntity();
        board.setBoard_name(boardName);
        boardDAO.insert(board);
        
        
        // Criando as colunas com os titulos informados pelo user
        default_titles.forEach(
            t ->{
                boardColumnsDAO.insert(board.getId(), t, boardColumnsEntity.getKinds().get(cUtil.getCount()), cUtil.getCount());
                cUtil.couter();                
            }
        );
    }
    
    public static void deleteByID(long id){
        boardDAO.deleteByID(id);
    }
}
