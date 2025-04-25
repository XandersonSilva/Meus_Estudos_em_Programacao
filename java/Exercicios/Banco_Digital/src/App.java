import java.util.Scanner;

import agentes.Cliente;
import agentes.PessoaFisica;
import agentes.PessoaJuridica;
import banco.Banco;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
public class App {

    static Scanner input = new Scanner(System.in);
    static Banco banco = new Banco("Banco Digital POO");
    public static void main(String[] args) throws Exception {
        
    }

    static void menuInicial(){
        int continuar = -1;
        do {
            System.out.println("[ 0 ] Sair\n" + //
                                "[ 1 ]Fazer Cadastro\n" + //
                                "[ 2 ]Fazer Login;\n"
            );
            continuar = input.nextInt();
            if (continuar == 1){
                cadastrarCliente();
            }
        } while (continuar > 2 || continuar < 0);
    }

    static Cliente cadastrarCliente(){
        int continuar = -1;
        do {
            System.out.println("[ 0 ] Sair\n" + //
                                "[ 1 ]Cadastrar pessoa Juridica\n" + //
                                "[ 2 ]Cadastrar pessoa fisíca;\n"
            );
            continuar = input.nextInt();
        } while (continuar > 2 || continuar < 0);

        if(continuar == 1){
            System.out.println("Informe seu nome:");
            String nome      = input.nextLine();
            System.out.println("Informe seu CNPJ:");
            String CNPJ       = input.nextLine();
            System.out.println("Informe sua senha:");
            String senha     = input.nextLine();

            PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, CNPJ, senha);
            
            banco.adicionarCliente(pessoaJuridica);

            return pessoaJuridica;
        }
        if(continuar == 2){
            System.out.println("Informe seu nome:");
            String nome      = input.nextLine();
            System.out.println("Informe sua data de nascimeto:");
            String nascimeto = input.nextLine();
            System.out.println("Informe seu CPF:");
            String CPF       = input.nextLine();
            System.out.println("Informe sua senha:");
            String senha     = input.nextLine();

            PessoaFisica pessoaFisica = new PessoaFisica(nome, nascimeto, CPF, senha);
            banco.adicionarCliente(pessoaFisica);

            return pessoaFisica;
        }
        

        return null;
    }

    static Conta criarContaPoupaca(Cliente cliente) throws Exception{
        System.out.println("Deseja criar uma conta Corrente?\n Digite 1 para SIM  e 0 para NÃO:");
        
        if(0 != input.nextInt()){
            Conta contaBanco = new ContaPoupanca(cliente);
            return contaBanco;
        }
        return null;
    }

    static Conta criarContaCorrente(Cliente cliente) throws Exception{
            System.out.println("Deseja criar uma conta Corrente?\n Digite 1 para SIM  e 0 para NÃO:");
            
            if(0 != input.nextInt()){
                System.out.println("Deposite o primeiro valor da sua conta:");
                double saldo = input.nextDouble();
                
                Conta contaBanco = new ContaCorrente(cliente, saldo);
                return contaBanco;
            }
            return null;
        }
        
        static void sistema(Cliente cliente, Conta contaBanco) throws Exception{
            Scanner input = new Scanner(System.in);
            int continuar = 1;
            do{
                System.out.println("[ 0 ] Sair\n" + //
                                    "[ 1 ]Consultar saldo\n" + //
                                    "[ 2 ]Depositar dinheiro;\n" + //
                                    "[ 3 ]Sacar dinheiro;\n" + //
                                    "[ 4 ]Transferir dinheiro;\n" 
                                    );

                                    continuar = input.nextInt();
                                    
                                    if(continuar == 1){
                                        System.out.println("Seu saldo atual é:");
                                        contaBanco.consultar_saldo();
                                    }
                                    if(continuar == 2){
                                        System.out.println("Informe o valor que deseja depositar:");
                                        double deposito = input.nextDouble();
                                        contaBanco.depositar(deposito);
                                    }
                                    if(continuar == 3){
                                        System.out.println("Informe o valor que deseja sacar:");
                                        double saque = input.nextDouble();
                                        contaBanco.sacar(saque);
                                    }
                                    if(continuar == 4){
                                        System.out.println("Informe o número da conta do destinatario:");
                                        int numero = input.nextInt();
                                        System.out.println("Informe a agencia da conta do destinatario:");
                                        int agencia = input.nextInt();
                                        System.out.println("Informe o valor que deseja Transferir:");
                                        double valor = input.nextDouble();
                                        

                                    }
            }while(continuar != 0);
            input.close();
        }

       
}

