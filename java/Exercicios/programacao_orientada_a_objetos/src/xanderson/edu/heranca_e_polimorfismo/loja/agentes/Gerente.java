package xanderson.edu.heranca_e_polimorfismo.loja.agentes;
import java.util.List;

public final class Gerente extends Usuario{
    /*
    Gerente métodos 
            Gerar relatório financeiro,
            Consultar vendas
    */

    public Gerente(String nome, String email, String senha, char tipo) {
        super(nome, email, senha, tipo);
        setAdministrador(true);
    }
    
    public void gerarRelatórioFinanceiro(){
        if(!(this.logado)){
            System.out.println("Você precissa fazer login para realizar essa ação!");
            return;
        }
        List<String[]> vendas = planiliaDeVenda.getVendas();
        double pago    = 0;
        double naoPago = 0;
        for (String[] venda : vendas) {
            Boolean pagou =  Boolean.getBoolean(venda[0]) ? true : false;    System.out.println("Lucro atual: R$"  + pago + "\nValor não recebido: R$" + naoPago );

            if(pagou){
                pago += Double.parseDouble(venda[3]);
            }else{
                naoPago += Double.parseDouble(venda[3]);
            }            
        }
        System.out.println("Lucro atual: R$"  + pago + "\n"+//
                            "Valor não recebido: R$" + naoPago );
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
}
