package conta;

import agentes.Cliente;

public abstract class Conta {
    protected Cliente titular;
    protected int     AGENCIA = 50501;
    protected int     NUMERO  = 10000;
    protected double  saldo;
    protected String  tipo;


    public Conta(Cliente cliente){
        this.titular = cliente;
        this.NUMERO  ++;
        this.saldo  = 0;
    }

    public abstract void sacar(double valor);
    
    public void depositar(double valor) throws Exception{
        if(valor < 0)
            throw new Exception("valor inválido");

        this.saldo += valor;
    }

    public void transferir(Cliente destinatario, int agencia, int numero, double valor) throws Exception{
        if(valor < 0)
            throw new UnsupportedOperationException("Valor inválido para operação");

        destinatario.receberTransferencia(numero, agencia, valor);
    }

    public int getAgencia() {
        return this.AGENCIA;
    }
    public int getNumero() {
        return this.NUMERO;
    }

    public double consultar_saldo(){
        return this.saldo;
    }

    public String getTitular(){
        return this.titular.getNome();
    }
}
