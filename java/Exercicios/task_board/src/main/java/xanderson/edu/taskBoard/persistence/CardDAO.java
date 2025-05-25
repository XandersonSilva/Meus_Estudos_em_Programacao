package xanderson.edu.taskBoard.persistence;

import static java.time.ZoneOffset.UTC;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.OffsetDateTime;
import java.util.TimeZone;

import xanderson.edu.taskBoard.persistence.entitys.BoardEntity;
import xanderson.edu.taskBoard.persistence.entitys.CardEntity;

public class CardDAO {



    public void insert(long column_id, String title, String description){
        String sql = "INSERT INTO cards (column_id, title, description) values (?, ?, ?) ;";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ){
            prepareStatement.setLong(1, column_id);
            prepareStatement.setString(2, title);
            prepareStatement.setString(3, description);

            prepareStatement.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public CardEntity find(long id){
        CardEntity card = new CardEntity();

        String sql = "SELECT * FROM cards b WHERE b.id = ?;";

        try (Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            
            statement.setLong(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            


            if (resultSet.next()) {
                card.setId(resultSet.getLong("id"));
                card.setColumn_id(resultSet.getLong("column_id"));
                card.setTitle(resultSet.getString("title"));
                card.setDescription(resultSet.getString("description"));
                card.setCreate_at(OffsetDateTime.ofInstant(resultSet.getTimestamp("create_at").toInstant(), UTC));
                card.setBlocked(resultSet.getBoolean("blocked"));
                card.setBlockin_reason(resultSet.getString("blockin_reason"));
                card.setUnblockin_reason(resultSet.getString("unblockin_reason"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return card;
    }


    public void updateColumn(long id, long column_id){
        String sql = "UPDATE cards c set column_id = ? WHERE c.id = ?;";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ){
            prepareStatement.setLong(1, column_id);
            prepareStatement.setLong(2, id);

            prepareStatement.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateBlockCard(long id, String blockin_reason){
        String sql = "UPDATE cards c set blocked = ? , blockin_reason = ? WHERE c.id = ?;";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ){
            prepareStatement.setBoolean(1, true);
            prepareStatement.setString(2, blockin_reason);
            prepareStatement.setLong(3, id);

            prepareStatement.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateUnblockCard(long id, String unblockin_reason){
        String sql = "UPDATE cards c set blocked = ?, unblockin_reason = ? WHERE c.id = ?;";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ){
            prepareStatement.setBoolean(1, false);
            prepareStatement.setString(2, unblockin_reason);
            prepareStatement.setLong(3, id);

            prepareStatement.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateCancelCard(long id, long cancel_column_id){
        String sql = "UPDATE cards c set column_id = ? WHERE c.id = ?;";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ){
            prepareStatement.setLong(1, cancel_column_id);
            prepareStatement.setLong(2, id);

            prepareStatement.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
