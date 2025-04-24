package edu.xanderson.execoes;
import java.util.Scanner;
import java.util.Locale;


public class MinhaClasse {
    public class AboutMe {
        public static void main(String[] args) {
            int idade = 0;
            double altura = 0;
            
            Scanner input = new Scanner(System.in).useLocale(Locale.US);


            
            System.out.println("Informe seu nome:");
            String nome = input.nextLine();
        
            System.out.println("Informe seu sobrenome:");
            String sobrenome = input.nextLine();

            System.out.println("Informe sua idade:");
            try{
                idade = input.nextInt();
            }catch(Exception e){
                System.out.println(e);

            }
            System.out.println("Informe sua altura (em metros):");
            try {
                altura = input.nextDouble();                
            } catch (Exception e) {
                System.out.println(e);
            }
    
            input.close();
            
    
            System.out.println("Olá, me chamo "+ nome +" "+sobrenome);
            System.out.println("Tenho " +idade+" anos");
            System.out.println("Minha altura é " + altura + " m");
    
        }
    }
    
}
