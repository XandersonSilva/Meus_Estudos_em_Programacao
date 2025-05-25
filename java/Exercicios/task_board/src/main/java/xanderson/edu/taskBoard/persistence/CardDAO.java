package xanderson.edu.taskBoard.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
        String sql = "UPDATE cards c set blocked = ?, blockin_reason = ? WHERE c.id = ?;";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ){
            prepareStatement.setBoolean(1, true);
            prepareStatement.setString(2, unblockin_reason);
            prepareStatement.setLong(3, id);

            prepareStatement.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
