package conta;

import agentes.Cliente;

public class ContaPoupanca extends Conta{

    @Override
    public void sacar(double valor) {
        if(valor > this.saldo)
            throw new UnsupportedOperationException("Não há saldo suficiente para realizar essa operação");
        this.saldo -= valor;
    }


    @Override
    public void transferir(Cliente destinatario, int agencia, int numero, double valor) throws Exception{
        if(valor < 0)
            throw new UnsupportedOperationException("Valor inválido para operação");

        destinatario.receberTransferencia(numero, agencia, valor);
    }    
}
