import java.util.Scanner;

import apps.AparelhoTelefonico;
import apps.NavegadorInternet;
import apps.ReprodutorMusical;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        sistema();
    }


    static void sistema(){
        int escolha;
        ReprodutorMusical  iPod     = new ReprodutorMusical();
        NavegadorInternet  safari   = new NavegadorInternet();
        AparelhoTelefonico telefone = new AparelhoTelefonico();
        do{
            System.out.println( " [ 0 ] Desligar\n"+//
                                " [ 1 ] Abrir iPod\n"+//
                                " [ 2 ] Abrir Safari\n"+//
                                " [ 3 ] Abrir telefone\n"         
            );   

            escolha = informarNumero(); 
            int retorno = 1;
            switch (escolha) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    do {
                        retorno = iPod(iPod);

                    } while (retorno == 1);
                    break;
                    case 2:
                        do {
                            retorno = safari(safari);

                        } while (retorno == 1);
                        break;
                case 3:
                    do {
                        retorno = telefone(telefone);
                                        
                    } while (retorno == 1);
                    break;
            
                default:
                    System.out.println("Opção inválida");
            }
        }while(true);
    }

    
    static int iPod(ReprodutorMusical iPod){
        
        System.out.println( "[ 0 ] Sair             \n"+//
                            "[ 1 ] Tocar Musica      \n"+//
                            "[ 2 ] Pausar Musica     \n"+//
                            "[ 3 ] Parar Musica      \n"+//
                            "[ 4 ] Retroceder Musica \n"+//
                            "[ 5 ] Avançar Musica    \n"+//
                            "[ 6 ] Selecionar Musica \n"
                            );                    
        int escolha = informarNumero();
        
        switch (escolha) {
            case 0:
                return 0;
            case 1:
                iPod.tocarMusica();
                return 1;
            case 2:
                iPod.pausarMusica();
                return 1;
            case 3:
                iPod.pararMusica();
                return 1;
            case 4:
                iPod.retrocederMusica();
                return 1;
            case 5:
                iPod.avançarMusica();
                return 1;
            case 6:
                System.out.println("Informe o nome da música:");
                iPod.selecionarMusica(input.nextLine());
                return 1;
            
            default:
                return 1;
        }
    }
    
    static int safari(NavegadorInternet safari){
    
        System.out.println( "[ 0 ] Sair               \n"+//
                            "[ 1 ] Exibir Página      \n"+//
                            "[ 2 ] Adicionar Nova Aba \n"+//
                            "[ 3 ] Atualizar Pagina   \n"
                        );
        int escolha = informarNumero();
    
        switch (escolha) {
            case 0:
                
                return 0;
            case 1:
                System.out.println("Informe o endereço a ser acessado:");
                safari.exibirPagina(input.nextLine());
                return 1;
            case 2:
                System.out.println("Informe o endereço a ser acessado:");
                safari.adicionarNovaAba(input.nextLine());
                return 1;
            case 3:
                safari.atualizarPagina();
                return 1;
            default:
                return 1;
        }
        
    }
    static int telefone(AparelhoTelefonico telefone){
        System.out.println( "[ 0 ] Sair           \n"+//
                            "[ 1 ] Ligar          \n"+//
                            "[ 2 ] Atender        \n"+//
                            "[ 3 ] Correio de Voz \n"+//
                            "[ 4 ] Desligar        \n"
                        );
        int escolha = informarNumero();
        
        switch (escolha) {
            case 0:
                
                return 0;
            case 1:
                System.out.println("Informe o número a ser ligado:");
                telefone.ligar(input.nextLine());
                return 1;
            case 2:
                telefone.atender();
                return 1;
            case 3:
                telefone.iniciarCorreioVoz();
                return 1;
            case 4:
                telefone.encerrarChamada();
                return 1;
            default:
                return 1;
        }
        
    }

    static int informarNumero(){
        boolean contina = true;
        while (contina) {
            try {
                contina = false;
                return Integer.parseInt(input.nextLine());
            }catch(Exception e){
                contina = true;
                System.out.println("Informe um valor numerico!");
            }            
        }
        return -1;
    }
}