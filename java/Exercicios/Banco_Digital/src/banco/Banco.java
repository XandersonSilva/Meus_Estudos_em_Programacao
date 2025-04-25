package banco;
import java.util.ArrayList;

import agentes.Cliente;

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

    public void listarCientes(){
        this.clientes.forEach(cliente -> cliente.dadosClientes().forEach(linha -> System.out.println(linha)));
    }
}
