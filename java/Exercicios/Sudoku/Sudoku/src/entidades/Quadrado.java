package entidades;

public class Quadrado {
    private int     numero;
    private  int     atual = 0;
    private boolean fixo       = false;
    private boolean preenchido = false;
    
    public Quadrado(int numero, boolean fixo){
        this.numero     = numero;
        this.preenchido = true;
        this.fixo       = fixo;
        if(fixo){
            this.atual = this.numero;
        }
    }
    
    public boolean verificaCorreto(){
        //Retorna se o número que o usuário informou está correto
        return this.atual == this.numero ? true : false;
    }


    public void atualizarAtual(int numero){
        if(this.fixo)return;
        
        this.atual = numero;
        this.preenchido = true;
    };

    public int pegarAtual(){
        return atual;
    }


    public boolean estaPreencido(){
        return this.preenchido;
    }
    
    public boolean estaFixo(){
        return this.fixo;
    }

    public int getNumero() {
        return numero;
    }
}
