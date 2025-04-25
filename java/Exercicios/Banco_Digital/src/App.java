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
        int a = 0;
        do {
            menuCliente(menuInicial());

        } while (a == 0);
        input.close();
    }

    static Cliente menuInicial(){
        int continuar = -1;
        do {
            System.out.println( "[ 0 ]Sair\n" + //
                                "[ 1 ]Fazer Cadastro\n" + //
                                "[ 2 ]Fazer Login;\n"
            );
            continuar = inputNumero();
            if(continuar == 0){
                System.exit(continuar);
            }
            if (continuar == 1){
                return cadastrarCliente();
            }
            if (continuar == 2){
                return fazerLogin();
            }

        } while (continuar > 2 || continuar < 0);
        return null;
    }

    static Cliente cadastrarCliente(){
        int continuar = -1;
        do {
            System.out.println("[ 0 ] Sair\n" + //
                                "[ 1 ]Cadastrar pessoa Juridica\n" + //
                                "[ 2 ]Cadastrar pessoa fisíca;\n"
            );
            continuar = inputNumero();
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

    static Cliente fazerLogin(){

        System.out.println("Informe seu CNPJ ou CPF:");
        String CNPJ_CPF  = input.nextLine();
        System.out.println("Informe sua senha:");
        String senha     = input.nextLine();

        return banco.buscarCliente(CNPJ_CPF,  senha);
    }

    static void menuCliente(Cliente cliente) throws Exception{
        int continuar = -1;
        do {
            System.out.println("[ 0 ] Sair\n" + //
                                "[ 1 ]Criar conta poupança   \n" + //
                                "[ 2 ]Criar conta corrente   \n" + //
                                "[ 3 ]Listar contas do banco \n" + //
                                "[ 4 ]Entrar na minha conta; \n"
            );
            continuar = inputNumero();
            if(continuar == 0){
              break;  
            }
            if (continuar == 1){
                criarConta(cliente, 1);
            }
            if (continuar == 2){
                criarConta(cliente, 2);
                
            }
            if (continuar == 3){
                banco.listarClientes();
            }
            if (continuar == 4){
                System.out.println("Informe a agencia da sua conta:");
                int agencia      = inputNumero();
                System.out.println("Informe seu numero da sua conta:");
                int numero       = inputNumero();

                Conta conta = cliente.buscarConta(agencia, numero);
                if(conta != null){
                    movimentarConta(cliente, conta);
                }
            }
        } while (continuar != 0);
    }


    static void criarConta(Cliente cliente, int tipoConta) throws Exception{ // tipoConta = 1 -> poupaça; tipoConta = 2 -> corrente;   
        if (tipoConta == 2) {
            System.out.println("Deposite o primeiro valor da sua conta:");

            cliente.adicionarConta(new ContaCorrente(cliente, inputFlutuante()));
            banco.adicionarCliente(cliente);
            return;
        }
        cliente.adicionarConta(new ContaPoupanca(cliente));
        banco.adicionarCliente(cliente);
    }
        
    static void movimentarConta(Cliente cliente, Conta contaBanco) throws Exception{
        int continuar = 1;
        do{
            System.out.println("[ 0 ] Sair\n" + //
                                "[ 1 ]Consultar saldo\n" + //
                                "[ 2 ]Depositar dinheiro;\n" + //
                                "[ 3 ]Sacar dinheiro;\n" + //
                                "[ 4 ]Transferir dinheiro;\n" 
                                );

            continuar = inputNumero();
            
            if(continuar == 1){
                System.out.println("Seu saldo atual é:");
                System.out.println(contaBanco.consultar_saldo());
            }
            if(continuar == 2){
                System.out.println("Informe o valor que deseja depositar:");
                double deposito = inputFlutuante();
                contaBanco.depositar(deposito);
            }
            if(continuar == 3){
                System.out.println("Informe o valor que deseja sacar:");
                double saque = inputFlutuante();
                contaBanco.sacar(saque);
            }
            if(continuar == 4){
                System.out.println("Informe o número da conta do destinatario:");

                int numero = inputNumero();
                System.out.println("Informe a agencia da conta do destinatario:");

                int agencia = inputNumero();
                System.out.println("Informe o valor que deseja Transferir:");

                double valor = inputFlutuante();

                contaBanco.transferir(banco, agencia, numero, valor);
                //Já são dois dias tentando fazer essa função funcionar, sinceramente, desisto
            }
        }while(continuar != 0);
    }

    static int inputNumero(){
        try {
            return Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
    
    static double inputFlutuante(){
        try {
            return Double.parseDouble(input.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
}

