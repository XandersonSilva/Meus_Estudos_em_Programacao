package agentes;

public class PessoaJuridica extends Cliente{
    private String CNPJ;

    public PessoaJuridica(String nome, String senha, String CNPJ){
        this.nome = nome;
        this.senha = senha;
        this.CNPJ = CNPJ;
    };
}
