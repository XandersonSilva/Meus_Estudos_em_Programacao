package conta;

import agentes.Cliente;

public abstract class Conta {
    protected Cliente titular;
    protected int     AGENCIA = 00001;
    protected int     NUMERO  = 00001;
    protected double  saldo;
    protected String  tipo;


    public void conta(Cliente cliente){
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

    public abstract void transferir(Cliente destinatario,int agencia, int numero, double valor) throws Exception;


    public int getAgencia() {
        return AGENCIA;
    }
    public int getNumero() {
        return NUMERO;
    }
}
