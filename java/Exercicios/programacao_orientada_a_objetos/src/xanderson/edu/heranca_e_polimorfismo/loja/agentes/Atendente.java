package xanderson.edu.heranca_e_polimorfismo.loja.agentes;


public final class Atendente extends Usuario{
/*
    Atendente métodos:
        Receber pagamentos
        Fechar o caixa
*/

    private double caixa;
    
    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha);
        
    }
    

    public void receberPagamento(Usuario usuario, int id){
        String[] vendaEmDebito = null;

        if(!(usuario instanceof Atendente)){
            System.out.println("Apenas atendentes podem receber pagamentos!");
            return;    
        }
        for (String[] venda : planiliaDeVenda.getVendas()) {
            if(Integer.valueOf(venda[4]) == id && !(Boolean.parseBoolean(venda[0]))){
                vendaEmDebito = venda;
            }
        }
        
        if(vendaEmDebito == null){
            System.out.println("Não há vendas não pagas referente ao id informado!");
            return;    
        }
        
        String pagamentoRealizado_Convert = String.valueOf(true);
        String id_Convert = String.valueOf(id);

        String[] vendaPaga = {pagamentoRealizado_Convert, vendaEmDebito[1], vendaEmDebito[2], vendaEmDebito[3], id_Convert};

        planiliaDeVenda.atualizarVenda(vendaPaga, vendaEmDebito);

        this.caixa += Double.parseDouble(vendaPaga[3]);
    }

    public void feicharCaixa(){
        System.out.println("O valor atual do caixa é: R$ " + caixa);
    }
}
