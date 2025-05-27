package xanderson.edu.primeiros_passos;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApp implements CommandLineRunner{
    @Autowired
    private Calculadora calculadora; 
    Scanner input = new Scanner(System.in);
    

    @Override
    public void run(String [] args) throws Exception{
        double numero = 0;
        double limite = 10;
        while (true) {
            try {
                System.out.println("Informe o número que deseja saber sua tabuada: ");
                numero = Double.parseDouble(input.nextLine());
                System.out.println("Informe o tamanho limite da sua tabuada: ");
                limite = Double.parseDouble(input.nextLine());
            } catch (Exception e) {
                System.out.println("O valor tem que ser numerico");
            }
            rodarComandoRepetido(calculadora, numero, limite);
        }
    }
    
    private void rodarComandoRepetido(Calculadora calculadora, double numero, double limite){
        System.out.println("\nTabuada de adição: ");
        for (int i = 1; i < limite+1; i++) {
            System.out.print((numero +" + "+ i + " = "));
            System.out.println( calculadora.somar(numero, i));
        }

        System.out.println("\nTabuada de subitração: ");
        for (int i = 0; i < limite+1; i++) {
            System.out.print((numero +" - "+ i + " = "));
            System.out.println( calculadora.subtrair(numero, i));
        }

        System.out.println("\nTabuada de multiplicação: ");
        for (int i = 0; i < limite+1; i++) {
            System.out.print((numero +" x "+ i + " = "));
            System.out.println( calculadora.multiplicar(numero, i));
        }

        System.out.println("\nTabuada de divisão: ");
        for (int i = 0; i < limite+1; i++) {
            System.out.print((numero +" / "+ i + " = "));
            System.out.println( calculadora.dividir(numero, i));
        }

        System.out.println("\nTabuada de exponênciação: ");
        for (int i = 0; i < limite+1; i++) {
            System.out.print((numero +" ^ "+ i + " = "));
            System.out.println( calculadora.exponenciar(numero, i));
        }
        
        System.out.println("\nRaiz quadrada: ");
        System.out.println(calculadora.raizQuadrada(numero));
        System.out.println("\n");

    }
}
