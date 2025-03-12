package xanderson.edu.heranca_e_polimorfismo.loja.agentes;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

public final class Vendedor extends Usuario{

    public Vendedor(String nome, String email, String senha, char tipo) {
        super(nome, email, senha, tipo);
        this.administrador = false;
    }

    public void realizarVenda(String nomeProduto, int quantidade, Usuario usuario){
        if(!(this.logado)){
            System.out.println("Você precissa fazer login para realizar essa ação!");
            return;
        }

        if(!(usuario instanceof Vendedor)){
            System.out.println("Apenas vendedores podem realizar vendas!");
            return;    
        }
        
        planiliaDeVenda.setId(planiliaDeVenda.getId()+1);
        
        String pagamentoRealizado_Convert = String.valueOf(false);
        String quantidade_Convert = String.valueOf(quantidade);
        String valorTotal_Convert = String.valueOf(gerarValor());
        String id_Convert = String.valueOf(planiliaDeVenda.getId());

        String[] venda = {pagamentoRealizado_Convert, nomeProduto, quantidade_Convert, valorTotal_Convert, id_Convert};

        planiliaDeVenda.realizarVenda(venda);
    }

    public void consultarVendas(){
        if(!(this.logado)){
            System.out.println("Você precissa fazer login para realizar essa ação!");
            return;
        }
        List<String[]> vendas = planiliaDeVenda.getVendas();
        for (String[] venda : vendas) {
            String pagamento =  Boolean.getBoolean(venda[0]) ? "Pagamento realizado"  : "Pagamento pendente";
            System.out.println(pagamento + "; nome do produto:" + venda[1] + ", quantidade: " + venda[2] + ", valorTotal: "+ venda[3] + ", id: " + venda[4]);
        }
    }

    private double gerarValor(){
        return ThreadLocalRandom.current().nextDouble(0, 100000);
    }

    
}
