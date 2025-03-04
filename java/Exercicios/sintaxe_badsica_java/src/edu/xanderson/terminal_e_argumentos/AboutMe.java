package edu.xanderson.terminal_e_argumentos;
import java.util.Scanner;
import java.util.Locale;//Importante devido a entrada de dados decimais

public class AboutMe {
    public static void main(String[] args) {


        // Preenchedo dados via argumentos na execução via terminal
        /* 
         * String nome = args[0];
         * String sobrenome = args[1];
         * int idade =   Integer.valueOf(args[2]);
         * double altura = Double.valueOf(args[3]);
         * 
         * System.out.println("Olá, me chamo "+ nome +" "+sobrenome);
         * System.out.println("Tenho " +idade+" anos");
         * System.out.println("Minha altura é " + altura + " m");
        */


        // Pegando dados via Scanner 
        Scanner input = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Informe seu nome:");
        String nome = input.nextLine();
        System.out.println("Informe seu sobrenome:");
        String sobrenome = input.nextLine();
        System.out.println("Informe sua idade:");
        int idade = input.nextInt();
        System.out.println("Informe sua altura (em metros):");
        double altura = input.nextDouble();

        input.close();
        

        System.out.println("Olá, me chamo "+ nome +" "+sobrenome);
        System.out.println("Tenho " +idade+" anos");
        System.out.println("Minha altura é " + altura + " m");

    }
}
