package xanderson.edu.taskBoard.persistence;

import lombok.NoArgsConstructor;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

@NoArgsConstructor
public class ConnectionUtil{

    public static Connection getConnection() throws SQLException  {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/task_board", "root", "root");
    };

}