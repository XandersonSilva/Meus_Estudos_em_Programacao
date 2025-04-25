package banco;

import java.util.HashSet;
import java.util.Set;

import agentes.Cliente;

public class Banco {
    private String nome;
    private Set<Cliente> clientes = new HashSet<Cliente>();

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

    public void realizarTransferencia(int agencia, int numero, double valor){
        this.clientes.forEach(cliente -> {
            try {
                cliente.receberTransferencia(agencia, numero, valor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Cliente buscarCliente(String CPF_OU_CNPJ, String senha){
        for(Cliente cliente : clientes){
            if(cliente.validarLogin(CPF_OU_CNPJ, senha))
                return cliente;
        }
        return null;
    }
}