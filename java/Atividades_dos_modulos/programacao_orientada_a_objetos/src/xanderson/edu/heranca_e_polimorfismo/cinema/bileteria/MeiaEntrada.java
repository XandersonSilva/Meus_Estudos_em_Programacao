package xanderson.edu.heranca_e_polimorfismo.cinema.bileteria;

public final class MeiaEntrada extends Ingresso{

    private double valorMeia;

    public MeiaEntrada(String nomeFilme, double valor, boolean dublado) {
        super(nomeFilme, valor, dublado);
        
        CalculaValorMeia();
    }
    
    private void CalculaValorMeia(){
        this.valorMeia = super.getValor() * 0.5;
    }
    
    @Override
    public void valor_real(){
        System.out.println("O valor para meia entrada no filme " + super.getNomeFilme() + " " + super.legendadoOuDublado() + " é R$" + this.valorMeia);
    }

}
