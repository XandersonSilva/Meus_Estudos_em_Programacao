package xanderson.edu.taskBoard.persistence;

import org.flywaydb.core.Flyway;

public class FlywayStart {

    public static void startFlyway(){
        Flyway flyway = Flyway.configure()
                                .dataSource(
                "jdbc:mysql://localhost:3306/task_board", "root", "root").load();
            flyway.migrate();
    }

}
