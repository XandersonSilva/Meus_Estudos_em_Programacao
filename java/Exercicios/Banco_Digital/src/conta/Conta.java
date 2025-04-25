package conta;

import java.util.Random;
import agentes.Cliente;
import banco.Banco;


public abstract class Conta {
    protected Cliente titular;
    protected int     AGENCIA;
    protected int     NUMERO  = 1000000;
    protected double  saldo;
    protected String  tipo;
    private   Random random = new Random();

    public Conta(Cliente cliente){
        this.NUMERO = random.nextInt(100000,900000);
        this.titular = cliente;
        this.saldo  = 0;
    }

    public abstract void sacar(double valor);
    
    public void depositar(double valor) throws Exception{
        if(valor < 0){
            System.out.println("valor inválido");
            return;
        }

        this.saldo += valor;
    }

    public void transferir(Banco banco, int agencia, int numero, double valor) throws Exception{
        if(valor < 0 && this.saldo >= valor){
        System.out.println("Valor inválido para operação");
        banco.realizarTransferencia(agencia, numero, valor);
        this.saldo -= valor;
        return;
    }
            
        
    }

    public boolean validarAgenciaNumero(int agencia, int numero){
        if(this.AGENCIA == agencia && this.NUMERO == numero){
            return true;
        }
        return false;
    }

    public double consultar_saldo(){
        return this.saldo;
    }

    public String getTitular(){
        return this.titular.getNome();
    }
    
    public int getAgencia() {
        return AGENCIA;
    }
    public int getNumero() {
        return NUMERO;
    }
}
