package xanderson.edu.taskBoard.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xanderson.edu.taskBoard.Service.BoardService;

public class InitialMenu {
    private static Scanner input = new Scanner(System.in);
    private static BoardService boardService = new BoardService();
    

    
    public static void menu(){
        System.out.println("1 Criar novo Board");
        System.out.println("2 Listar Boards");
        System.out.println("3 Selecionar Board");
        System.out.println("4 Deletar Board");
        System.out.println("5 Sair");
        System.out.println("");


        int escolha = inputInt();
        switch (escolha) {
            case 1:
                createNewBoard();
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                System.out.println("Programa encerrado!");
                break;
            
            default:
                System.out.println("Opção inválida!");;
        }
        
    }


    private static void createNewBoard(){
        System.out.println("Informe o titulo para o board: ");
        String title = input.nextLine();
        List<String> columnsTitles = new ArrayList();
        
        int pendingColumQuant = inputInt("Informe a quantidade de colunas do tipo pendente que deseja no board:");

        System.out.println("Informe o titulo para a coluna inicial: ");
        columnsTitles.add(input.nextLine());

        if (pendingColumQuant > 1) {
            List<String> pendingColumnsTitles = new ArrayList();
            for (int i = 0; i < pendingColumQuant; i++) {
                System.out.println("Informe o titulo para a coluna pendente "+ (i + 1) +": ");
                pendingColumnsTitles.add(input.nextLine());
            }
            System.out.println("Informe o titulo para a coluna final: ");
            columnsTitles.add(input.nextLine());
            System.out.println("Informe o titulo para a coluna cancelados: ");
            columnsTitles.add(input.nextLine());

            boardService.createBoard(title, columnsTitles, pendingColumnsTitles);
            return;
        }
        
        System.out.println("Informe o titulo para a coluna pendente: ");
        columnsTitles.add(input.nextLine());
        System.out.println("Informe o titulo para a coluna final: ");
        columnsTitles.add(input.nextLine());
        System.out.println("Informe o titulo para a coluna cancelados: ");
        columnsTitles.add(input.nextLine());
        boardService.createBoard(title, columnsTitles);

    }

    private static int inputInt(){
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("O valor informado não é numerico!");
            }
        }
    }

    private static int inputInt(String msg){
        System.out.println(msg);
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("O valor informado não é numerico!");
            }
        }
    }
}
