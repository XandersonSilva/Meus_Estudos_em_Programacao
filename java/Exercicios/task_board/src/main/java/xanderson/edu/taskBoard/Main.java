package xanderson.edu.taskBoard;

import java.sql.SQLException;

import org.flywaydb.core.Flyway;

import xanderson.edu.taskBoard.persistence.BoardColumnsDAO;
import xanderson.edu.taskBoard.persistence.BoardDAO;
import xanderson.edu.taskBoard.persistence.CardDAO;

public class Main {

    private static BoardDAO  boardDAO = new BoardDAO();
    private static CardDAO cardDAO = new CardDAO();
    private static BoardColumnsDAO boardColumnsDAO = new BoardColumnsDAO();

    public static void main(String[] args){
        Flyway flyway = Flyway.configure()
                              .dataSource(
            "jdbc:mysql://localhost:3306/task_board", "root", "root").load();
        flyway.migrate();


        //System.out.println(boardDAO.findByID(1));
        //boardDAO.insert("teste " + 2);
        //boardDAO.deleteByID(2);
        //boardDAO.findAll().forEach(System.out::println);
        //boardColumnsDAO.insert(1, "teste", "teste", 5);


    }
}