package xanderson.edu.taskBoard.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardColumnsDAO{

    public void insert(long board_id,String title,String kind,int _order){
        String sql = "INSERT INTO board_columns (board_id, title, kind, _order) values (?, ?, ?, ?);";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setLong(1, board_id);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, kind);
            preparedStatement.setInt(4, _order);

            preparedStatement.execute();


        } catch (Exception e) {
            System.out.println(e);
        }
    } 

}