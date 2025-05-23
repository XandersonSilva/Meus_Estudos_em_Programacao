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
    
}
