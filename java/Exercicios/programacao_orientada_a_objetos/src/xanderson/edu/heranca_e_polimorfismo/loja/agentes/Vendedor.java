package xanderson.edu.heranca_e_polimorfismo.loja.agentes;

import java.util.List;

public final class Vendedor extends Usuario{

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
        this.administrador = false;
    }

    public void realizarVenda(String nomeProduto, int quantidade, double valorTotal, Usuario usuario){
        if(!(usuario instanceof Vendedor)){
            System.out.println("Apenas vendedores podem realizar vendas!");
            return;    
        }
        
        planiliaDeVenda.setId(planiliaDeVenda.getId()+1);
        
        String pagamentoRealizado_Convert = String.valueOf(false);
        String quantidade_Convert = String.valueOf(quantidade);
        String valorTotal_Convert = String.valueOf(valorTotal);
        String id_Convert = String.valueOf(planiliaDeVenda.getId());

        String[] venda = {pagamentoRealizado_Convert, nomeProduto, quantidade_Convert, valorTotal_Convert, id_Convert};

        planiliaDeVenda.realizarVenda(venda);
    }

    public void consultarVendas(){
        List<String[]> vendas = planiliaDeVenda.getVendas();
        for (String[] venda : vendas) {
            String pagamento =  Boolean.getBoolean(venda[0]) ? "Pagamento realizado"  : "Pagamento pendente";
            System.out.println(pagamento + "; nome do produto:" + venda[1] + ", quantidade: " + venda[2] + ", valorTotal: "+ venda[3] + ", id: " + venda[4]);
        }
    }

    
}
