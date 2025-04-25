package banco;
import java.util.ArrayList;

import agentes.Cliente;
import conta.Conta;

public class Banco {
    private String nome;

    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Banco(String nome){
        this.nome = nome;
    }

    public String nomeBanco(){
        return this.nome;
    }

    public void adicionarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void listarClientes(){
        this.clientes.forEach(cliente -> cliente.dadosClientes().forEach(linha -> System.out.println(linha)));
    }

    public Cliente logar(String nome, String Senha) throws Exception{
        for(Cliente cliente : clientes){
            if(cliente.getNome() == nome && cliente.compararSenha(Senha))
                return cliente;
        }
        return null;
    }

    public void realizarTransferencia(int agencia, int numero, double valor){
        this.clientes.forEach(cliente -> {
            try {
                cliente.receberTransferencia(agencia, numero, valor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}