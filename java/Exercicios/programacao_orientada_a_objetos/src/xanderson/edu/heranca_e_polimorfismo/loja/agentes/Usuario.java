package xanderson.edu.heranca_e_polimorfismo.loja.agentes;
import xanderson.edu.heranca_e_polimorfismo.loja.armazenamento.PlaniliaDeVenda;


public sealed abstract class Usuario permits Atendente, Gerente, Vendedor{

    /*  TODO criar classe usuário

            Usuário atributos:
                nome
                email
                senha
                administrador

            Usuário métodos: 
                Realizar login,
                Realizar logff,
                alterar dados,
                alterar senha;
     */
        

    @SuppressWarnings("unused")
    private   String          nome;
    private   String          email;
    private   String          senha;
    protected boolean         administrador;
    private   boolean         logado;
    protected PlaniliaDeVenda planiliaDeVenda;
    
    
    //Objeto para gerenciamento de vendas pelos diferentes atores dessa classe
    
    
    public Usuario(String  nome, String  email, String  senha){
        this.planiliaDeVenda = new PlaniliaDeVenda();
        this.nome            = nome;
        this.email           = email;
        this.senha           = senha;
    }

    public void alterarDados(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }

    public void alterarSenha(String senha){
        if(this.senha == senha){
            System.out.println("A nova senha não pode ser igual a antiga!");
            return;
        }
        this.senha = senha;
        System.out.println("Senha atualizada!");

    }

    public void fazerLogin(String email, String senha){
        if(this.logado){
            System.out.println("Você já está logado!");
        }

        if(!(this.email == email && this.senha == senha)){
            System.out.println("email ou senha incorretos!");
            return;
        }
        this.logado = true;
        System.out.println("Login realizado com sucesso!");
    }

    public void fazerLogoff(){
        if(!this.logado){
            System.out.println("Você precissa estár logado para fazer logoff!");
            return;
        }
        this.logado = false;
        this.nome   = null;
        this.email  = null;
        this.senha  = null;
    }
    
    public boolean isAdministrador() {
        return administrador;
    }

    protected void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
}
    