package agentes;

import java.util.Objects;

public class PessoaFisica extends Cliente{
    @SuppressWarnings("unused")
    private String nascimento;
    private String CPF;

    public PessoaFisica(String nome, String nascimento, String CPF, String senha){
        
        this.nome = nome;
        this.nascimento = nascimento;
        this.CPF = CPF;
        this.senha = senha;

    }

    @Override
    public boolean validarLogin(String CPF, String senha) {
        if (CPF.isEmpty() || senha.isEmpty()) 
            throw new UnsupportedOperationException("Senha ou CPF não informado!");
        if (this.CPF.equals(CPF) && this.senha.equals(senha))
            return true;
        return false;
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.CPF);
    }
    
}
