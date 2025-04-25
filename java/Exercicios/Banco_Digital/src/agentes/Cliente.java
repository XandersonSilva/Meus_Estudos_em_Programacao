package agentes;
import conta.Conta;
import java.util.ArrayList;

public abstract class Cliente {
    protected   String nome;
    protected   String senha;
    protected long ID_CONTADOR = 10000;
    protected ArrayList<Conta> contas = new ArrayList<Conta>();

    public Cliente(){
        ID_CONTADOR ++;
    }

    public void adicionarConta(Conta conta){
        this.contas.add(conta);
    }

    public void receberTransferencia(int agencia, int numero, double valor) throws Exception{
        for(Conta conta : contas){
            if(conta.getAgencia() == agencia && conta.getNumero() == numero)
                conta.depositar(valor);
        }        
    } 

    public ArrayList<?> dadosClientes(){
        ArrayList<ArrayList<?>> ClientesDados = new ArrayList<>();

        for (Conta conta : contas) {
            ArrayList<String> dado = new ArrayList<>();
            dado.add(conta.getTitular());
            dado.add(String.valueOf(conta.getAgencia()));
            dado.add(String.valueOf(conta.getNumero()));
            dado.add(String.valueOf(conta.consultar_saldo()));

            ClientesDados.add(dado);
        }
        return ClientesDados;
    }
    
    public Conta buscarConta(int agencia, int numero){
        for(Conta conta : contas){
            
            if(conta.validarAgenciaNumero(agencia, numero)) return conta;
        }
        return null;
    }
    
    public abstract boolean validarLogin(String CPF_OU_CNPJ, String senha);
    
    public abstract int hashCode();
    
    public String getNome() {
        return nome;
    }
}