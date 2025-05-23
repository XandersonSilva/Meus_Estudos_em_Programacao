package xanderson.edu.taskBoard;

import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                              .dataSource(
            "jdbc:mysql://localhost:3306/task_board", "root", "root").load();
        flyway.migrate();

    
    }
}