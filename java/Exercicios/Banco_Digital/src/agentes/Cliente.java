package agentes;

import conta.Conta;
import java.util.ArrayList;

public abstract class Cliente {
    public String nome;
    protected long ID_CONTADOR = 000001;
    protected ArrayList<Conta> contas = new ArrayList<Conta>();

    public Cliente(){
        ID_CONTADOR ++;
    }

    public void adicionarConta(long ID, Conta conta){
        this.contas.add(conta);
    }

    public void receberTransferencia(int agencia, int numero, double valor) throws Exception{
        for(Conta conta : contas){
            if(conta.getAgencia() == agencia && conta.getNumero() == numero)
                conta.depositar(valor);
        }        
    } 

}


