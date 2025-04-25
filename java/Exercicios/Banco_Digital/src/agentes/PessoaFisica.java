package agentes;

public class PessoaFisica extends Cliente{
    private String nascimento;
    private String CPF;

    public PessoaFisica(String nome, String nascimento, String CPF, String senha){
        
        this.nome = nome;
        this.nascimento = nascimento;
        this.CPF = CPF;
        this.senha = senha;

    }
}
