package conta;

import agentes.Cliente;

//REGRA DE NEGOCIO:
// A linha de credito será implementada seguindo a seguintes diretrizes:
// R$0          -> Para primeiro deposito abaixo de R$200,00
// R$300        -> Para primeiro deposito abaixo de R$1500,00 e superior a R$200,00
// R$500 + 25%  -> Para primeiro deposito acima de R$3000,00


public class ContaCorrente extends Conta{

    double linhaCredito;

    public ContaCorrente(Cliente cliente, double primeiroDeposito) throws Exception{
        super(cliente);
        if (primeiroDeposito <= 0)
            throw new Exception("O valor depositado deve ser maior que 0");
            
        if(primeiroDeposito >= 3000){
            this.linhaCredito = 500 + primeiroDeposito * 0.25;
            return;
        }
        if(primeiroDeposito >= 1500)
            this.linhaCredito = 300;
    }

    @Override
    public void sacar(double valor) {
        if(valor < 0)
            throw new UnsupportedOperationException("Valor inválido para operação");
        if(this.saldo - valor < -linhaCredito)
            throw new UnsupportedOperationException("Saldo insuficiente para operação");
        this.saldo -= valor;
    }
    
    @Override
    public void transferir(Cliente destinatario, int agencia, int numero, double valor) throws Exception{
        if(valor < 0)
            throw new UnsupportedOperationException("Valor inválido para operação");
        if(this.saldo - valor < -linhaCredito)
            throw new UnsupportedOperationException("Saldo insuficiente para operação");

        destinatario.receberTransferencia(numero, agencia, valor);
        this.saldo -= valor;
    }
}
