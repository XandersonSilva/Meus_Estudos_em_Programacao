package xanderson.edu.heranca_e_polimorfismo.loja.sistema;
import java.util.List;

import xanderson.edu.heranca_e_polimorfismo.loja.agentes.Usuario;
import xanderson.edu.heranca_e_polimorfismo.loja.agentes.Vendedor;

public class PlaniliaDeVenda {
    /*
        ESTRUTURA DO ARRAY:
            O Array vendas conterá sub-arrays cada um referente a uma venda realizada,
            cada sub-array possuirá obrigatoriamente cinco valores: o primeiro indicando 
            se o pagamento foi realizado, o segundo sendo o nome do produto, o terceiro
            sendo a quantidade vendida, o quarto sendo o valor da venda e o quinto sendo o
            identificador. Sendo todos String (por conta do java ser uma linguagem fortemente
            tipada) cabendo ao desenvolvedor fazer as devidas conversões.
        EXEMPLO:
            [
                [pagamentoRealizado, nomeProduto, quantidade, valorTotal, id]
            ]
    */
    
    private List<String[]> vendas; // Usando uma lista para armazenar as vendas
    private int id;
    public Object getVendas;

    public PlaniliaDeVenda() {
        this.id = 0; 
    }

    public void realizarVenda(boolean pagamentoRealizado, String nomeProduto, int quantidade, double valorTotal, Usuario usuario) {
        if(!(usuario instanceof Vendedor)){
            System.out.println("Apenas vendedores podem realizar vendas!");
            return;    
        }
        this.id++;
        String pagamentoRealizado_Convert = String.valueOf(pagamentoRealizado);
        String quantidade_Convert = String.valueOf(quantidade);
        String valorTotal_Convert = String.valueOf(valorTotal);
        String id_Convert = String.valueOf(this.id);

        String[] venda = {pagamentoRealizado_Convert, nomeProduto, quantidade_Convert, valorTotal_Convert, id_Convert};
        this.vendas.add(venda); // Adicionando a nova venda à lista
    }

    public void pagarCompra(int id_venda){
        for (String[] venda : vendas) {
            if(String.valueOf(id_venda) == venda[4]){
                venda[0] = String.valueOf(true);
            }
        }
    }
    
    public List<String[]> getVendas(){
        return vendas;
    }
}