package conta;

import agentes.Cliente;
import banco.Banco;

//REGRA DE NEGOCIO:
// A linha de credito será implementada seguindo a seguintes diretrizes:
// R$0          -> Para primeiro deposito abaixo de R$200,00
// R$300        -> Para primeiro deposito abaixo de R$1500,00 e superior a R$200,00
// R$500 + 25%  -> Para primeiro deposito acima de R$3000,00


public class ContaCorrente extends Conta{
    private double linhaCredito;
    
    
    public ContaCorrente(Cliente cliente, double primeiroDeposito) throws Exception{
        super(cliente);
        this.AGENCIA  = 10110;
        this.saldo   += primeiroDeposito;
        
        if (primeiroDeposito <= 0){
            System.out.println("O valor depositado deve ser maior que 0");
            return;
        }
        if(primeiroDeposito >= 3000){
            this.linhaCredito = 500 + primeiroDeposito * 0.25;
            return;
        }
        if(primeiroDeposito >= 1500)
            this.linhaCredito = 300;
    }

    @Override
    public void sacar(double valor) {
        if(valor < 0){
            System.out.println("Valor inválido para operação");
            return;
        }
        if(this.saldo - valor < -linhaCredito){
            System.out.println("Saldo insuficiente para operação");
            return;
        };
        this.saldo -= valor;
    }
    
    @Override
    public void transferir(Banco banco, int agencia, int numero, double valor) throws Exception{
        if(valor < 0){
            System.out.println("Valor inválido para operação");
            return;
        }
        if(this.saldo - valor < -linhaCredito){
            System.out.println("Saldo insuficiente para operação");
            return;
        }

        banco.realizarTransferencia(agencia, numero, valor);
        this.saldo -= valor;
    }
    
}
