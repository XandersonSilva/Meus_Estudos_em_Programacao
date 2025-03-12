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
        

    public    char            tipo; // Possibilidades: a:Atendente v:Vendedor g:Gerente
    @SuppressWarnings("unused")
    private   String          nome;
    protected String          email;
    protected String          senha;
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    protected boolean         administrador;
    protected boolean         logado;
    

    protected PlaniliaDeVenda planiliaDeVenda;
    
    
    //Objeto para gerenciamento de vendas pelos diferentes atores dessa classe
    
    
    public Usuario(String  nome, String  email, String  senha, char tipo){
        this.planiliaDeVenda = new PlaniliaDeVenda();
        this.nome            = nome;
        this.email           = email;
        this.senha           = senha;
        this.tipo            = tipo;
        
        
        fazerLogin(email, senha);
    }

    public void alterarDados(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }

    public void alterarSenha(String senha){
        this.senha = senha;
        System.out.println("Senha atualizada!");

    }

    public void fazerLogin(String email, String senha){
        if(this.logado){
            System.out.println("Você já está logado!");
        }
    
        if (!getEmail().equals(email) || !getSenha().equals(senha)) {
            System.out.println("Email ou senha incorretos!");
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
    }
    
    public boolean isAdministrador() {
        return administrador;
    }

    protected void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean isLogado() {
        return logado;
    }
}
    