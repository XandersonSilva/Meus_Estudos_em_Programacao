package conta;

import agentes.Cliente;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente){
        super(cliente);
        this.AGENCIA = 20220;
    }

    @Override
    public void sacar(double valor) {
        if(valor > this.saldo){
            System.out.println("Não há saldo suficiente para realizar essa operação");
            return;
        }
        this.saldo -= valor;
    }
    

}
