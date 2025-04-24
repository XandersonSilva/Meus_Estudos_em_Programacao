package xanderson.edu.heranca_e_polimorfismo.cinema;

import xanderson.edu.heranca_e_polimorfismo.cinema.bileteria.Ingresso;
import xanderson.edu.heranca_e_polimorfismo.cinema.bileteria.IngressoFamilia;
import xanderson.edu.heranca_e_polimorfismo.cinema.bileteria.MeiaEntrada;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        
        int continuar = 1;
        do{
            System.out.println("[ 0 ] Sair\n" + //
                               "[ 1 ] Comprar Ingresso");
            
            String valorInformado = input.nextLine();
            try {
                continuar = Integer.parseInt(valorInformado);
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                continue;
            }

            switch (continuar) {
                case 0:
                    break;
                case 1:
                    double  valor     = valorFilme();
                    String  nomeFilme = escolherFilme();
                    boolean dublado   = escolherAudio();
                    informacoesFilme(nomeFilme, dublado, valor);
                    Ingresso ingressoEscolhido =  escolherIngresso(nomeFilme, dublado, valor);
                    System.out.println("\n");


                    ingressoEscolhido.valor_real();
                    System.out.println("\n \n \n \n \n \n \n");
                    break;
                default:
                    System.out.println("Informe um  valor valído!");
                    break;

            }

        }while(continuar != 0);
        
        input.close();
    }

    static double   valorFilme(){
        return ThreadLocalRandom.current().nextDouble(20, 90);
    }

    static boolean  escolherAudio(){
        int     continuar = 1;
        boolean dublado   = true;
        do{
            System.out.println("Escolha a versão:\n"+ //
                               "[ 0 ] Sair\n" + //
                               "[ 1 ] Legendado\n" + //
                               "[ 2 ] Dublado");
            
            
            String valorInformado = input.nextLine();
            try {
                continuar = Integer.parseInt(valorInformado);
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                continue;
            }
            
            switch (continuar) {
                case 0:
                    System.exit(0);

                case 1:
                    dublado = false;
                    continuar = 0;
                    break;
                case 2:
                    dublado = true;
                    continuar = 0;
                    break;
                default:
                    System.out.println("informe um  valor valído!");
            }    
        }while(continuar != 0);
        
        return dublado;
    }

    static String   escolherFilme(){
        int    continuar = 1;
        String nomeFilme;
        do{
            System.out.println("Informe o nome do Filme:");
            nomeFilme = input.nextLine();
            
            if (! (nomeFilme == null || nomeFilme.isEmpty())) {
                continuar = 0;
                break;
            }
        }while(continuar != 0);
        return nomeFilme;
    }

    static void     informacoesFilme(String nomeFilme, boolean dublado, double valor){
        String legendadoOuDublado = dublado ? " Dublado"  : "legendado"; 
        System.out.println("O filme filme escolhido foi " + nomeFilme + " " + legendadoOuDublado + " com o valor de R$" + valor);
    }

    static Ingresso escolherIngresso(String nomeFilme, boolean dublado, double valor){
        int     continuar = 1;
        do{
            System.out.println("Escolha o tipo de ingresso desejado:\n" + //
                               "[ 0 ] Sair                          \n" + //
                               "[ 1 ] Meia Entrada                  \n" + //
                               "[ 2 ] Ingresso familía              \n" + //
                               "[ 3 ] Ingresso padrão               \n");
            continuar = input.nextInt();
            
            switch (continuar) {
                case 0:
                    System.exit(0);

                case 1:
                    MeiaEntrada ingressoMeia = new MeiaEntrada(nomeFilme, valor, dublado);
                    continuar = 0;
                    
                    return ingressoMeia;
                case 2:
                    int quantidadePessoas = quantidadePessoas();

                    IngressoFamilia ingressoFamilia = new IngressoFamilia(nomeFilme, valor, dublado, quantidadePessoas);
                    continuar = 0;

                    return ingressoFamilia;
                case 3:
                    Ingresso ingresso = new Ingresso(nomeFilme, valor, dublado);
                    continuar = 0;
                    
                    return ingresso;
                default:
                    System.out.println("Informe um  valor valído!");
            }    
        }while(continuar != 0);
        return null;
    }

    static int      quantidadePessoas(){
        do {
            System.out.println("Informe a quantidade de pessoas:");
            String quantidadePessoas = input.nextLine();
            try {
                int qntdPesssoas = Integer.parseInt(quantidadePessoas);
                return qntdPesssoas;
            } catch (Exception e) {
                System.out.println("O valor da quantidade de pessoas deve ser numerico!");

            }
        } while (true);

    }

}