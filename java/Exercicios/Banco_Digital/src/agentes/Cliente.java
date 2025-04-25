package agentes;

import conta.Conta;
import java.util.ArrayList;

public abstract class Cliente {
    public String nome;
    protected long ID_CONTADOR = 10000;
    protected ArrayList<Conta> contas = new ArrayList<Conta>();

    public Cliente(){
        ID_CONTADOR ++;
    }

    public void adicionarConta(Conta conta){
        this.contas.add(conta);
    }

    public void receberTransferencia(int agencia, int numero, double valor) throws Exception{
        for(Conta conta : contas){
            if(conta.getAgencia() == agencia && conta.getNumero() == numero)
                conta.depositar(valor);
        }        
    } 

    public ArrayList<String> dadosClientes(){
        
        ArrayList<String> ClientesDados = new ArrayList<>();
        for (Conta conta : contas) {
            String dado = "Titular: "+conta.getTitular() + " Agencia: "+ conta.getAgencia() + " Número: " + conta.getNumero();
            ClientesDados.add(dado);
        }
        return ClientesDados;

    }
}


