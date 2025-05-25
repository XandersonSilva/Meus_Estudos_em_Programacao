package xanderson.edu.taskBoard;

import xanderson.edu.taskBoard.UI.InitialMenu;
import xanderson.edu.taskBoard.persistence.FlywayStart;

public class Main {
    public static void main(String[] args){
        
        FlywayStart.startFlyway();
        InitialMenu.menu();


    }
}