package agentes;

import java.util.Objects;

public class PessoaJuridica extends Cliente{
    @SuppressWarnings("unused")
    private String CNPJ;

    public PessoaJuridica(String nome, String senha, String CNPJ){
        this.nome = nome;
        this.senha = senha;
        this.CNPJ = CNPJ;
    };

    @Override
    public boolean validarLogin(String CNPJ, String senha) {
        if (CNPJ.isEmpty() || senha.isEmpty()) 
            throw new UnsupportedOperationException("Senha ou CNPJ não informado!");
        if (this.CNPJ.equals(CNPJ) && this.senha.equals(senha))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.CNPJ);
    }
}
