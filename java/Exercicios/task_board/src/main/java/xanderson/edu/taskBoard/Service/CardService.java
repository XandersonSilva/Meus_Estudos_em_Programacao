package xanderson.edu.taskBoard.Service;


import java.util.List;

import xanderson.edu.taskBoard.persistence.CardDAO;
import xanderson.edu.taskBoard.persistence.entitys.BoardColumnsEntity;
import xanderson.edu.taskBoard.persistence.entitys.BoardEntity;
import xanderson.edu.taskBoard.persistence.entitys.CardEntity;

public class CardService{
    private static CardDAO cardDAO = new CardDAO();


    public static void createCard(BoardEntity board, String title, String description){
        long initialColumnId = board.getColunas().get(0).getId();

        cardDAO.insert(initialColumnId, title, description);
    }

    public boolean moveCard(BoardEntity board, long cardId){
        CardEntity card = cardDAO.find(cardId);
        if (card.isBlocked()) return false;

        
        int index_column = 0;
        int cout = 0;
        for (BoardColumnsEntity c : board.getColunas()) {
            if (c.getId() == card.getColumn_id()) {
                index_column = cout;
            }
            cout ++;
        }
        if (board.getColunas().get(index_column).getKind().equals(BoardColumnsEntity.getKinds().get(3))) return false;
        if (board.getColunas().get(index_column).getKind().equals(BoardColumnsEntity.getKinds().get(2))) return false;

        BoardColumnsEntity proximaColuna = board.getColunas().get(index_column + 1);


        cardDAO.updateColumn(cardId, proximaColuna.getId());

        return true;
    }

    public void cancelCard(BoardEntity board, long cardId){
        int lastColumn = board.getColunas().size() -1;
        long cancelColumnId = board.getColunas().get(lastColumn).getId();

        cardDAO.updateCancelCard(cardId, cancelColumnId);
    }

    public void blockCard(long id, String reason){
        cardDAO.updateBlockCard(id, reason);
    }

    public void unblockCard(long id, String reason){
        cardDAO.updateUnblockCard(id, reason);
    }
}
