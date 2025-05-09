import java.util.List;
import java.util.Scanner;

import entidades.Grade;
import entidades.Quadrado;
import util.NovoJogo;

public class App {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Grade grade = new Grade();

        int entrada = 0;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        do {
            
            System.out.println( "    1. Iniciar um novo o jogo\r\n" + //
                                "    2. Colocar um novo número\r\n" + //
                                "    3. Remover um número\r\n" + //
                                "    4. Verificar jogo\r\n" + //
                                "    5. Verificar status do jogo\r\n" + //
                                "    6. Limpar\r\n" + //
                                "    7. finalizar o jogo\n" + //
                                "    8. Sair\r\n");
            System.out.println("Informe a opção desejada para prosseguir:");
            entrada = inputNumero();

            sistema(entrada, grade);
        } while (entrada != 8);

    }

   static int inputNumero(){
        while (true) {
            try {
            return Integer.parseInt(input.nextLine()); 
            } catch (Exception e) {
                System.out.println("informe um numero válido");
            }
        }
   }
   static int inputNumero(String mensagem){
    System.out.println(mensagem);
    while (true) {
        try {
        return Integer.parseInt(input.nextLine()); 
        } catch (Exception e) {
            System.out.println("informe um numero válido");
        }
    }
}
   static void sistema(int entrada, Grade grade){
    int linha ;
    int coluna;
    switch (entrada) {
        case 1:
            System.out.println(grade.iniciarJogo() ? "Jogo inicializado" : "Termine o jogo atual para realizar essa ação!");
            break;
        case 2:
            linha  = inputNumero("Informe a linha desejada:");
            coluna = inputNumero("Informe a coluna desejada:"); 
            int numero = inputNumero("Informe o número a ser inserido:"); 
        
            colocarNovoNumero(linha, coluna, numero, grade);
            break;
        case 3:
            linha  = inputNumero("Informe a linha desejada:");
            coluna = inputNumero("Informe a coluna desejada:"); 
            
            removerNumero(linha, coluna, grade);
            break;
        case 4:
            if (grade.isJogando()) {
                System.out.println(grade.verificarJogo());
                System.out.println("O jogo contem " + grade.contarErros() + " erros e " + grade.haVazios() + "espaços vazios!");
            }else{
                System.out.println("Jogo não iniciado!");
            }
            break;
        case 5:
            System.out.println(grade.verificarStatus());
            break;
        case 6:
            grade.limpar();
            System.out.println("Tabuleiro limpo");
            break;
        case 7:
            System.out.println(grade.terminarJogo()  ? "Jogo finalizado" : "Para finalizar o jogo todos os espaços devem ser preenchidos sem erros!");
            break;
        case 8:
            System.exit(0);
            break;
    
        default:
            System.out.println("Opção inválida! Tente novamente");
            break;
    }
   }

   static void colocarNovoNumero(int linha, int coluna, int numero, Grade grade){
        if(!grade.isJogando()) {
            System.out.println("Inicie o jogo para realizar essa ação!");
            return;
        }
        if(grade.preencherCedula(linha, coluna, numero)){
            System.out.println("Número " + numero+ " alocado na linha:" + linha + " e couna: "+ coluna);
            return;
        }
        System.out.println("Não é possível realizar a ação pois o espaço informado já está preenchido!");

   }

   static void removerNumero(int linha, int coluna, Grade grade){
        if(!grade.isJogando()) {
            System.out.println("Inicie o jogo para realizar essa ação!");
            return;
        }
        if (grade.limparCedula(linha, coluna)) {
            System.out.println("Número alocado na linha:" + linha + " e couna: " + coluna + " foi removido.");
            return ;
        }
        System.out.println("Não é possível realizar a ação com a possição informada!");
   }
}
