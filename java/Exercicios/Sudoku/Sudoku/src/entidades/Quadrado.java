package entidades;

public class Quadrado {
    private int     numero;
    public  int     atual;
    private boolean fixo       = false;
    private boolean preenchido = false;
    
    public Quadrado(int numero, boolean fixo){
        this.numero     = numero;
        this.preenchido = true;
        this.fixo       = fixo;
    }
    
    public boolean verificaCorreto(){
        //Retorna se o número que o usuário informou está correto
        return true ? this.atual == this.numero : false;
    }


    public void preencerNumero(int numero){
        if(this.fixo)return;
        
        this.numero = numero;
        this.preenchido = true;
    };

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
