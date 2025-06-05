package xanderson.edu.gof.padrao_strategy;

public class ComportamentoDefensivo  implements Comportamento{

    @Override
    public void mover() {
        System.out.println("Movendo-se defensivamente...");
    }
}
