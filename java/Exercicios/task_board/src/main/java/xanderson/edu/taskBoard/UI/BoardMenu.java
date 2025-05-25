package xanderson.edu.taskBoard.UI;

import java.util.Scanner;

import xanderson.edu.taskBoard.Service.BoardService;
import xanderson.edu.taskBoard.Service.CardService;
import xanderson.edu.taskBoard.persistence.entitys.BoardColumnsEntity;
import xanderson.edu.taskBoard.persistence.entitys.BoardEntity;
import xanderson.edu.taskBoard.persistence.entitys.CardEntity;

public class BoardMenu {
    private static Scanner input = new Scanner(System.in);

    public static void menu(BoardEntity board){
        int escolha = 0;
        while (escolha != 7) {
            
            System.out.println("\n");
            System.out.println("1 Exibir conteúdo do Board");
            System.out.println("2 Mover card para próxima coluna");
            System.out.println("3 Cancelar card");
            System.out.println("4 Criar card");
            System.out.println("5 Bloquear card");
            System.out.println("6 Desbloquear card");
            System.out.println("7 Fechar board");

            escolha = inputInt();
            switch (escolha) {
                case 1:
                    showBoard(board);
                    break;
                case 2:
                    moveCardNextColumn(board);
                    break;
                case 3:
                    cancelCard(board);
                    break;
                case 4:
                    createCard(board);
                    break;
                case 5:
                    blockCard();
                    break;
                case 6:
                    unblockCard();
                    break;
                case 7:
                    break;
                default:
                System.out.println("Opção inválida!");
                break;
            }
            board = reloadBoard(board);
        }
    }

    private static void showBoard(BoardEntity board){
        String linha = "---------------------------------------------------------------------------------";
        System.out.println(linha);
        System.out.println("         Coluna          |   ID  |          Card");
        System.out.println(linha);
        
        for (BoardColumnsEntity c : board.getColunas()) {
            try {
                for (CardEntity card : c.getCards()) {
                    System.out.println(   completeSpace(c.getTitle(), 25)
                                        +" |"
                                        + completeSpace(String.valueOf(card.getId()), 8)
                                        +"| "
                                        + card.getTitle()
                                        +": "
                                        + card.getDescription());
                    System.out.println(linha);

                }
            } catch (Exception e) {
                System.out.println(e);
            }
            if (c.getCards().size() < 1) {
                System.out.println(completeSpace(c.getTitle(), 25) +" | Não há nenhum card resistrado nessa coluna " );
                System.out.println(linha);          
            }
        }
    }

    private static void moveCardNextColumn(BoardEntity board){
        long cardId = inputLong("Informe o ID do card que deseja mover para sua respectiva proxíma coluna: ");
        CardService.moveCard(board, cardId);
    }

    private static void cancelCard(BoardEntity board){
        long cardId = inputLong("Informe o ID do card que deseja cancelar:");
        CardService.cancelCard(board, cardId);
    }

    private static void createCard(BoardEntity board){
        System.out.println("Informe o titulo do card");
        String title = input.nextLine();
        System.out.println("Informe o descrição do card");
        String description = input.nextLine();

        CardService.createCard(board, title, description);
    }
    
    private static void blockCard(){
        long cardId = inputLong("Informe o ID do card que deseja bloquear: ");
        System.out.println("Informe a rasão do bloqueio: ");

        String reason = input.nextLine();

        CardService.blockCard(cardId, reason);
    }

    private static void unblockCard(){
        long cardId = inputLong("Informe o ID do card que deseja desbloquear: ");
        System.out.println("Informe a rasão do desbloqueio: ");
        String reason = input.nextLine();

        CardService.unblockCard(cardId, reason);
    }

    private static BoardEntity reloadBoard(BoardEntity board){
        return BoardService.findByID(board.getId());
    }

    private static String completeSpace(String text, int mintSize){
        if (text.length()< mintSize) {
            int spaces = mintSize - text.length();
            for (int i = 0; i < spaces/2; i++) {
                text = " " + text;
            }
            for (int i = 0; i < spaces/2; i++) {
                text = text + " ";
            }
        }

        return text;
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

    private static int inputLong(String msg){
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
