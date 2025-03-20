package apps;

import java.util.ArrayList;

public class AparelhoTelefonico {
    private ArrayList<String> historicoChamadas = new ArrayList<String>();
    private boolean      emChamada;
    
    public void ligar(String numero){
        if (this.emChamada) {
            System.out.println("Não é possível realizar essa ação enquando você está em uma chamada!");
            return;
        }
        this.emChamada = true;
        this.historicoChamadas.add(numero);
    }
    
    public void atender(){
        if (this.emChamada) {
            System.out.println("Não é possível realizar essa ação enquando você está em uma chamada!");
            return;
        }
        this.emChamada = true;
        this.historicoChamadas.add("Número desconhecido");
    }
    
    public void iniciarCorreioVoz(){
        if (this.emChamada) {
            System.out.println("Não é possível realizar essa ação enquando você está em uma chamada!");
            return;
        }
        System.out.println("Reproduzindo correio de voz");
    }

    public void encerrarChamada(){
        if (!this.emChamada) {
            System.out.println("Não é possível realizar essa ação se você não está em uma chamada!");
            return;
        }
        this.emChamada = false;
        System.out.println("Chamada encerrada!");
    }
}
