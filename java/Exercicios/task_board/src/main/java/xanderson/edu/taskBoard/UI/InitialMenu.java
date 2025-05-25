package xanderson.edu.taskBoard.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xanderson.edu.taskBoard.Service.BoardService;
import xanderson.edu.taskBoard.persistence.entitys.BoardEntity;

public class InitialMenu {
    private static Scanner input = new Scanner(System.in);
    private static BoardService boardService = new BoardService();
    

    
    public static void menu(){
        while (true) {
            System.out.println("\n");
            System.out.println("1 Criar novo Board");
            System.out.println("2 Listar Boards");
            System.out.println("3 Selecionar Board");
            System.out.println("4 Deletar Board");
            System.out.println("5 Sair");
            System.out.println("\n");


            int escolha = inputInt();
            switch (escolha) {
                case 1:
                    createNewBoard();
                    break;
                case 2:
                    listBoards();
                    break;
                case 3:
                    BoardMenu.menu(selectBoard());
                    break;
                case 4:
                    deleteBoard();
                break;
                case 5:
                System.out.println("Programa encerrado!");
                System.exit(escolha);
                break;
                
                default:
                System.out.println("Opção inválida!");;
            }
        }
        
    }


    private static void createNewBoard(){
        System.out.println("Informe o nome do board: ");
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

    private static void listBoards(){
        List<BoardEntity> boards = BoardService.findAll();
        int i = 1;
        System.out.println("\n");
        String linha = "----------------------------------------";
        System.out.println(linha);
        for (BoardEntity b : boards) {
            System.out.println((i++) + " | " + b.getBoard_name());
            System.out.println(linha);
        }
        System.out.println("\n");

    }

    private static BoardEntity selectBoard(){
        int selectedBoardByUser = inputInt("Informe o número referente ao board de acordo com a opção 2 (Listar Boards): ");
        List<BoardEntity> boards = BoardService.findAll();
        long boardID = boards.get(selectedBoardByUser -1).getId();

        return boardService.findByID(boardID);
    }

    private static void deleteBoard(){
        int selectedBoardByUser = inputInt("Informe o número referente board ao que deseja deletar de acordo com a opção 2 (Listar Boards): ");
        List<BoardEntity> boards = BoardService.findAll();
        long boardID = boards.get(selectedBoardByUser -1).getId();

        boardService.delete(boardID);
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
