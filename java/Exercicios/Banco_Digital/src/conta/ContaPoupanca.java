package conta;

import agentes.Cliente;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente){
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        if(valor > this.saldo)
            throw new UnsupportedOperationException("Não há saldo suficiente para realizar essa operação");
        this.saldo -= valor;
    }


}
