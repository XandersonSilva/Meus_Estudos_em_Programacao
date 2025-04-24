package xanderson.edu.heranca_e_polimorfismo.loja;

import java.util.Scanner;

import xanderson.edu.heranca_e_polimorfismo.loja.agentes.Atendente;
import xanderson.edu.heranca_e_polimorfismo.loja.agentes.Gerente;
import xanderson.edu.heranca_e_polimorfismo.loja.agentes.Usuario;
import xanderson.edu.heranca_e_polimorfismo.loja.agentes.Vendedor;
import xanderson.edu.heranca_e_polimorfismo.loja.armazenamento.PlaniliaDeVenda;

/*
    TODO: Criar um sistema para integrar os métodos dos agentes:

    Métodos compartilhados:
        Realizar login
        Realizar logoff
        alterar dados
        alterar senha

    Atendente métodos:
        Receber pagamentos
        Fechar o caixa

    Gerente métodos:
        Gerar relatório financeiro
        Consultar vendas

    Vendedor métodos:
        Realizar Venda
        Consultar Vendas


*/

public class App {
    static Scanner input = new Scanner(System.in);
    static PlaniliaDeVenda planiliaDeVenda = new PlaniliaDeVenda();
    public static void main(String[] args) {
        Usuario usuario = selecionarAgente();

        sistema(usuario);
    
    }

    private static Usuario selecionarAgente(){
        int escolha;
        Boolean continua = true;
        do{
            @SuppressWarnings("unused")
            Usuario usuario;
            String nome ;
            String email;
            String senha;
            System.out.println("Quem está logando?\n" + //
                                "[ 0 ] Sair      \n"   + //
                                "[ 1 ] Atendente \n"   + //
                                "[ 2 ] Gerente   \n"   + //
                                "[ 3 ] Vendedor"
                                );
            escolha = informarNumero();

            

            switch (escolha) {
                case 0:
                    System.exit(0);
                    break;
                    
                case 3:
                    continua = false;
                    nome  = definirNome();
                    email = definirEmail();
                    senha = definirSenha();
                    return new Vendedor(nome, email, senha, 'v', planiliaDeVenda);

                case 2:
                    continua = false;
                    nome  = definirNome();
                    email = definirEmail();
                    senha = definirSenha();
                    return new Gerente(nome, email, senha, 'g', planiliaDeVenda);
                    
                case 1:
                    continua = false;
                    nome  = definirNome();
                    email = definirEmail();
                    senha = definirSenha();
                    return new Atendente(nome, email, senha, 'a', planiliaDeVenda);

                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
            
        }while(continua);
        return null;
    }


    static void sistema(Usuario usuario){
        boolean continuar = true;
        int     escolha = -1;
        do{
            System.out.println( "[ 0 ] Sair           \n"   + //
                                "[ 1 ] Realizar login \n"   + //
                                "[ 2 ] Realizar logoff \n"   + //
                                "[ 3 ] alterar dados  \n"   + //
                                "[ 4 ] alterar senha"
                                );
            if (usuario.isLogado() && usuario.tipo == 'a') {         
         
         
                System.out.println( "[ 5 ] Receber pagamentos \n"   + //
                                    "[ 6 ] Fechar o caixa"
                                );

                escolha = informarNumero();
                
                if(escolha == 5){
                    int id = informarIdCompra();
                    ((Atendente)usuario).receberPagamento(usuario, id);
                }

                if(escolha == 6){
                    ((Atendente)usuario).feicharCaixa();
                }
            } else if (usuario.isLogado() && usuario.tipo == 'g') {
                System.out.println( "[ 5 ] Gerar relatório financeiro \n"   + //
                                    "[ 6 ] Consultar vendas"
                                );

                escolha = informarNumero();
                
                if(escolha == 5){
                    ((Gerente)usuario).gerarRelatórioFinanceiro();
                }

                if(escolha == 6){
                    ((Gerente)usuario).consultarVendas();
                }
            } else if (usuario.isLogado() && usuario.tipo == 'v') {
                System.out.println( "[ 5 ] Realizar Venda \n"   + //
                                    "[ 6 ] Consultar Vendas"
                                );

                escolha = informarNumero();
                
                if(escolha == 5){
                    String nomeProduto;
                    int    quantidadeProduto;

                    nomeProduto = informarNomeProduto();
                    quantidadeProduto = informarQuantidade();

                    ((Vendedor)usuario).realizarVenda(nomeProduto, quantidadeProduto, usuario);
                }

                if(escolha == 6){
                    ((Vendedor)usuario).consultarVendas();
                }
            }else{
                escolha = informarNumero();
            }            

            if(escolha == 1){
                if (! usuario.isLogado()) {

                    usuario = selecionarAgente();
    
                    String email = definirEmail();
                    String senha = definirSenha();
    
                    usuario.fazerLogin(email, senha);
                }else{
                    System.out.println("Você já está logado!");
                }
            }
            
             if(escolha == 2){
                usuario.fazerLogoff();
            }
            
            if(escolha == 3){
                String nome  = definirNome();
                String email = definirEmail();

                usuario.alterarDados(email, nome) ;
            }
            
            if(escolha == 4){
                System.out.println("Informe a nova senha");
                String senha = input.next();

                usuario.alterarSenha(senha);
            }

            if(escolha == 0){
                continuar = false;
            }
        
        
        }while(continuar);
    }

    static String definirNome(){
        System.out.println("informe o seu nome: ");
        
        String nome = input.next();
        return nome;
    }
    static String definirEmail(){
        System.out.println("informe o seu email: ");
        
        String email = (String)input.next();
        return email;
    }
    static String definirSenha(){
        System.out.println("informe o seu senha: ");
        
        String senha = (String)(input.next());
        return senha;
    }
    
    static int    informarIdCompra(){
        boolean continua = true;
        int     id       = 0;
        
        do{
            System.out.println("Informe o ID da compra:");
            try {
                id = Integer.parseInt(input.next());
                continua = false;
                return id;

            } catch (Exception e) {
                System.out.println("Informe um valor válido!");
            }

        }while(continua);
        
        return id;
    }

    static String informarNomeProduto(){
        System.out.println("Informe o nome do produto:");
        return input.next();
    }

    static int    informarQuantidade(){
        boolean continua = true;
        int     quantidade = 0;
        
        do{
            System.out.println("Informe a quantidade que deseja comprar:");
            try {
                quantidade = Integer.parseInt(input.next());
                continua = false;
                return quantidade;

            } catch (Exception e) {
                System.out.println("Informe um valor válido!");
            }

        }while(continua);
        
        return quantidade;
    }

    static int    informarNumero(){
        boolean continua = true;
        int     valor = 0;
        
        do{
            try {
                valor = Integer.parseInt(input.next());
                continua = false;
                return valor;

            } catch (Exception e) {
                System.out.println("Informe um valor válido!");
            }

        }while(continua);
        
        return valor;
    }
}
