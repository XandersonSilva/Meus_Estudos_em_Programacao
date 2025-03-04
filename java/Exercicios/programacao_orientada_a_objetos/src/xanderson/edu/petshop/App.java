package xanderson.edu.petshop;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Banho banhoPet = new Banho();
        sistema(banhoPet);

    }

    static void sistema(Banho banhoPet){
        Scanner input = new Scanner(System.in);

        int continuar = 1;
        do{
            System.out.println("[ 0 ] Sair   \n" + //
                                "[ 1 ] Dar banho no pet\n" + //
                                "[ 2 ] Abastecer com água\n" + //
                                "[ 3 ] Abastecer com shampoo\n" + //
                                "[ 4 ] Verificar nivel de água\n" + //
                                "[ 5 ] Verificar nivel de shampoo\n" + //
                                "[ 6 ] Verificar se tem pet no banho\n" + //
                                "[ 7 ] Colocar pet na maquina\n" + //
                                "[ 8 ] Retirar pet da máquina\n" + //
                                "[ 9 ] Limpar maquina");

            continuar = input.nextInt();

            if(continuar == 1){
                banhoPet.Banhar_pet();
            }
            if(continuar == 2){
                banhoPet.Abastecer_agua();
            }
            if(continuar == 3){
                banhoPet.Abastecer_shampoo();
            }
            if(continuar == 4){
                banhoPet.verificar_agua();
            }
            if(continuar == 5){
                banhoPet.verificar_shampoo();
            }
            if(continuar == 6){
                banhoPet.verificar_pet_banho();
            }
            if(continuar == 7){
                banhoPet.colocar_pet();
            }
            if(continuar == 8){
                banhoPet.retirar_pet();
            }
            if(continuar == 9){
                banhoPet.limpar_maquina();
            }

        }while(continuar != 0);
        input.close();
    }
}
