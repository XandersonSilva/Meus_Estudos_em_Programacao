package xanderson.edu.heranca_e_polimorfismo.loja.agentes;

public final class Vendedor extends Usuario{

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
        this.administrador = false;
    }


    
}
