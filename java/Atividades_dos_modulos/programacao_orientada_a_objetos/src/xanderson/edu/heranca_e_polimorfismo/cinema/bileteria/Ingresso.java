package xanderson.edu.heranca_e_polimorfismo.cinema.bileteria;



public sealed class Ingresso permits IngressoFamilia, MeiaEntrada{
    
    private String  nomeFilme;
    private double  valor;
    private boolean dublado;



    public Ingresso(String nomeFilme, double valor, boolean dublado){
        this.nomeFilme = nomeFilme;
        this.valor     = valor;
        this.dublado   = dublado;
    }

    public void valor_real(){
        System.out.println("O valor para o filme " + getNomeFilme() + " " + legendadoOuDublado() + " é R$" + getValor());
    }

    protected String legendadoOuDublado(){
        if(this.dublado)
            return "dublado";
        return "legendado";

    }


    protected String getNomeFilme() {
        return nomeFilme;
    }

    protected double getValor() {
        return valor;
    }
    protected boolean isDublado() {
        return dublado;
    }

}
