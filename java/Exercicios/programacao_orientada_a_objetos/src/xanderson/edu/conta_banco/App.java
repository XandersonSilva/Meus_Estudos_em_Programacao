package xanderson.edu.conta_banco;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Conta contaBanco = criarConta();
        
        int continuar;
        if(contaBanco != null){
            do{
                System.out.println("[ 0 ] Sair\n" + //
                                    "[ 1 ]Consultar saldo\n" + //
                                    "[ 2 ]consultar cheque especial\n" + //
                                    "[ 3 ]Depositar dinheiro;\n" + //
                                    "[ 4 ]Sacar dinheiro;\n" + //
                                    "[ 5 ]Pagar um boleto.\n" + //
                                    "[ 6 ]Verificar se a conta está usando cheque especial.");

                                    continuar = input.nextInt();
                                    
                                    if(continuar == 1){
                                        System.out.println("Seu saldo atual é:");
                                        contaBanco.Consultar_saldo();
                                    }
                                    if(continuar == 2){
                                        System.out.println("O valor disponível no cheque especial é de:");
                                        contaBanco.Consultar_cheque_especial();
                                    }
                                    if(continuar == 3){
                                        System.out.println("Informe o valor que deseja depositar:");
                                        double deposito = input.nextDouble();
                                        contaBanco.Depositar_dinheiro(deposito);
                                    }
                                    if(continuar == 4){
                                        System.out.println("Informe o valor que deseja sacar:");
                                        double saque = input.nextDouble();
                                        contaBanco.Sacar_dinheiro(saque);
                                    }
                                    if(continuar == 5){
                                        System.out.println("Informe o valor do boleto a ser pago:");
                                        double valorBoleto = input.nextDouble();
                                        contaBanco.PagarBoleto( valorBoleto);
                                    }
                                    if(continuar == 6){
                                        contaBanco.VerificarUsoChequeEspecial();
                                    }
            }while(continuar != 0);
            input.close();
        }
        
    }
        static Conta criarConta(){
            Scanner input = new Scanner(System.in);
            System.out.println("Deseja criar uma conta?\n Digite 1 para SIM  e 0 para NÃO:");
            if(1 != input.nextInt())
               return null;
            System.out.println("Informe o número da conta:");
            int numero = input.nextInt();
            System.out.println("Deposite o primeiro valor da sua conta:");
            double saldo = input.nextDouble();
            
            Conta contaBanco = new Conta(numero, saldo);
            return contaBanco;
        }        

       
}
