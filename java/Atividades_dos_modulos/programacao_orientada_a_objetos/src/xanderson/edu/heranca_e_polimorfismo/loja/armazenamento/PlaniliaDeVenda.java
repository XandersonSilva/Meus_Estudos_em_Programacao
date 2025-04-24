package xanderson.edu.heranca_e_polimorfismo.loja.armazenamento;
import java.util.ArrayList;
import java.util.List;

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
    
    private ArrayList<String[]> vendas;
    private int id;


    
    public PlaniliaDeVenda() {
        this.vendas = new ArrayList<String[]>();  // Inicializa a lista de vendas
        this.id = 0;
    }

    public void realizarVenda(String[] venda) {
        this.vendas.add(venda); 
    }

    public void pagarCompra(int id_venda){
        for (String[] venda : vendas) {
            if(String.valueOf(id_venda) == venda[4]){
                venda[0] = String.valueOf(true);
            }
        }
    }
    
    public void atualizarVenda(String[] vendaPaga, String[] vendaEmDebito) {
        vendas.remove(vendaEmDebito);
        vendas.add(vendaPaga);
    }

    public List<String[]> getVendas(){
        return vendas;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}