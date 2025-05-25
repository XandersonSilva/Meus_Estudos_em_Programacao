package xanderson.edu.taskBoard.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.StatementImpl;

import java.time.OffsetDateTime;
import static java.time.ZoneOffset.UTC;

import xanderson.edu.taskBoard.persistence.entitys.BoardColumnsEntity;
import xanderson.edu.taskBoard.persistence.entitys.BoardEntity;
import xanderson.edu.taskBoard.persistence.entitys.CardEntity;


public class BoardDAO {

    public void insert(BoardEntity board){

        String sql_board_select = "INSERT INTO boards (board_name) values (?);";
        try (Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql_board_select);
        ){
            
            statement.setString(1, board.getBoard_name());
            statement.execute();

        if(statement instanceof StatementImpl impl){
            board.setId(impl.getLastInsertID());
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }



    public List<BoardEntity> findAll(){
        List<BoardEntity> entities = new ArrayList<>();
        
        String sql_board_select = "SELECT * FROM boards;";

        try(Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement_board = connection.prepareStatement(sql_board_select);
            ){

            statement_board.execute();
            ResultSet resultSet = statement_board.getResultSet();
            Boolean hasNext = resultSet.next();
            while (hasNext) {
                BoardEntity entity = new BoardEntity();
                entity.setBoard_name(resultSet.getString("board_name"));
                entity.setId(resultSet.getLong("id"));
                entities.add(entity);
                hasNext = resultSet.next();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return entities;
    }


    public BoardEntity findByID(long id){
        BoardEntity board = new BoardEntity();

        String sql_board_select = "SELECT * FROM boards b WHERE b.id = ?;";
        String sql_boardColumns_select = "SELECT * FROM board_columns c INNER JOIN boards b ON b.id = c.board_id WHERE b.id = ?;";
        String sql_columns_cards_select = "SELECT * FROM cards c WHERE c.column_id = ?;";
        
        try (Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql_board_select);
        ){
            
            statement.setLong(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            Boolean hasNext = resultSet.next();


            if (hasNext) {
                board.setBoard_name(resultSet.getString("board_name"));
                board.setId(resultSet.getLong("id"));
            }


            
            try (
                PreparedStatement statement_boardColumns = connection.prepareStatement(sql_boardColumns_select);
                ){
                    statement_boardColumns.setLong(1, board.getId());
                    statement_boardColumns.execute();
                    ResultSet resultSet_boardColumns = statement_boardColumns.getResultSet();

                    List<BoardColumnsEntity> columns = new ArrayList<>();
                    
                    hasNext = resultSet_boardColumns.next();
                    while (hasNext) {
                        BoardColumnsEntity boardColumn = new BoardColumnsEntity();
                        
                        boardColumn.setId(resultSet_boardColumns.getLong("id"));
                        boardColumn.setBoard_id(resultSet_boardColumns.getLong("board_id"));
                        boardColumn.setKind(resultSet_boardColumns.getString("kind"));
                        boardColumn.setTitle(resultSet_boardColumns.getString("title"));
                        boardColumn.set_order(resultSet_boardColumns.getInt("_order"));
                        
                        try (
                            PreparedStatement statement_columnCards = connection
                            .prepareStatement(sql_columns_cards_select);){
                            List<CardEntity> cards = new ArrayList<>();
                            
                            statement_columnCards.setLong(1, boardColumn.getId());
                            statement_columnCards.execute();
                            ResultSet resultSet_columnCards = statement_columnCards.getResultSet();

                            hasNext = resultSet_columnCards.next();

                            while (hasNext) {
                                CardEntity card = new CardEntity();

                                card.setId(resultSet_columnCards.getLong("id"));
                                card.setColumn_id(resultSet_columnCards.getLong("column_id"));
                                card.setTitle(resultSet_columnCards.getString("title"));
                                card.setDescription(resultSet_columnCards.getString("description"));
                                card.setBlocked(resultSet_columnCards.getBoolean("blocked"));
                                card.setBlockin_reason(resultSet_columnCards.getString("blockin_reason"));
                                card.setUnblockin_reason(resultSet_columnCards.getString("unblockin_reason"));
                                card.setCreate_at(OffsetDateTime.ofInstant((resultSet_columnCards.getTimestamp("create_at")).toInstant(), UTC));

                                cards.add(card);
                                hasNext = resultSet_columnCards.next();
                            }
                            boardColumn.setCards(cards);

                        } catch (Exception e) {
                            // TODO: handle exception
                            System.out.println(e);
                        }
                        columns.add(boardColumn);
                        hasNext = resultSet_boardColumns.next();
                    }
                    board.setColunas(columns);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e);
                }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return board;
    }

    public void deleteByID(long id){

        String sql_board_select = "DELETE FROM boards b WHERE b.id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql_board_select);
        ){
            
            statement.setLong(1, id);
            statement.execute();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
