package xanderson.edu.heranca_e_polimorfismo.cinema.bileteria;

public final class IngressoFamilia extends Ingresso{
    
    private int    quantidadePessoas;
    private double valorFamilia;

    public IngressoFamilia(String nomeFilme, double valor, boolean dublado, int quantidadePessoas) {
        super(nomeFilme, valor, dublado);

        this.quantidadePessoas = quantidadePessoas;
        CalculaValorFamilia();
    }

    private void CalculaValorFamilia(){
        if(this.quantidadePessoas > 3){
            this.valorFamilia = (super.getValor() * this.quantidadePessoas) * 0.95;
            return;
        }
        this.valorFamilia = super.getValor() * this.quantidadePessoas;
    }
    
    @Override
    public void valor_real(){
        System.out.println("O valor do ingresso familía para " + this.quantidadePessoas + " pessoas no filme " + super.getNomeFilme() + " " + super.legendadoOuDublado() + " é R$" + this.valorFamilia);
    }
    
}
