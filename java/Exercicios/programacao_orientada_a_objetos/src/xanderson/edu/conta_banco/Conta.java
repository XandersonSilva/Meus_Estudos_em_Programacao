package xanderson.edu.conta_banco;


/* TODO: Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:
[ x ]Consultar saldo
[ x ]consultar cheque especial
[ x ]Depositar dinheiro;
[ x ]Sacar dinheiro;
[ x ]Pagar um boleto.
[ x ]Verificar se a conta está usando cheque especial.
*/

public class Conta{
    private double saldo;
    private double chequeEspecial;
    private double maxChequeEspecial;

    

    public Conta(int numero, double saldo){
        this.saldo = saldo;

        if(saldo <= 500){
            this.chequeEspecial = 50;
            this.maxChequeEspecial = this.chequeEspecial;
            return;
        }
        this.chequeEspecial = saldo * 0.5;
        this.maxChequeEspecial = this.chequeEspecial;
    }



    
    public void Consultar_saldo(){
        PagarChequeEspecial();
        if(this.saldo >0){
            System.out.println(this.saldo + this.chequeEspecial);
            return;
        }
        System.out.println(this.chequeEspecial);
        
    }
    
    public void Consultar_cheque_especial(){
        PagarChequeEspecial();
        System.out.println(this.chequeEspecial);
    }
    
    public void Depositar_dinheiro(double deposito){
        double saldoAnterior = this.saldo;
        if(deposito <= 0){
            System.out.println("você não pode depositar valores negativos ou nulos");
            return;
        }
        this.saldo += deposito;
        PagarChequeEspecial();
        System.out.println("\n Você depositou R$"+ deposito + " \n Saldo anterior era de R$" + saldoAnterior + " \n O saldo atual é de R$ " + (this.saldo + this.chequeEspecial));
    }
    
    public void Sacar_dinheiro(double saque){
        PagarChequeEspecial();
        if(saque <= 0){
            System.out.println("você não pode sacar valores negativos ou nulos");
            return;
        }
        if(this.saldo >= saque){
            this.saldo -= saque;
            return;
        }
        if( (this.saldo + this.chequeEspecial) >= saque ){
            double valorPagarComCheque = saque - this.saldo;
            this.saldo = 0;
            this.chequeEspecial -= valorPagarComCheque;
            return;
        }
        System.out.println("Seu saldo é insuficiente para realizar essa ação!");
    }

    public void PagarBoleto(double valorBoleto){
        PagarChequeEspecial();
        if(valorBoleto <= 0){
            System.out.println("você não pode depositar valores negativos ou nulos");
            return;
        }

        if(this.saldo >= valorBoleto){
            this.saldo -= valorBoleto;
        } else if( (this.saldo + this.chequeEspecial) >= valorBoleto ){
            this.saldo -= valorBoleto;
            this.chequeEspecial += this.saldo;
        } else{
            System.out.println("Seu saldo é insuficiente para realizar essa ação!");
        }
    }

    private void PagarChequeEspecial(){
        double valorChequeUsado = this.maxChequeEspecial - this.chequeEspecial;

        if(this.saldo >= (valorChequeUsado * 2)){
            this.saldo -= valorChequeUsado;
            this.chequeEspecial += valorChequeUsado;
            return;
        }

        if(this.saldo > (valorChequeUsado * 0.2) && this.chequeEspecial < this.maxChequeEspecial){   
            this.saldo -= valorChequeUsado * 0.2;
            this.chequeEspecial += valorChequeUsado * 0.2;

        }

    }    
    
    public void VerificarUsoChequeEspecial(){
        if(this.chequeEspecial < this.maxChequeEspecial){
            System.out.println("Você está usando o cheque especial");
            return;
        }
        System.out.println("Você não está usando o cheque especial");
    }

}
