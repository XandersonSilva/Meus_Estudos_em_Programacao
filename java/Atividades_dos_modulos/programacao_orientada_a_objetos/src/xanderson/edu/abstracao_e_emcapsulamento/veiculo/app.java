package xanderson.edu.abstracao_e_emcapsulamento.veiculo;
import java.util.Scanner;

public class app {
public static void main(String[] args) {
    Carro carro = new Carro();
    sistema(carro);

}

static void sistema(Carro carro){
    Scanner input = new Scanner(System.in);
    int continuar = 1;

    do{
        System.out.println("[ 0 ] Sair\n" + // 
                            "[ 1 ] Ligar o carro\n" + //
                            "[ 2 ] Desligar o carro\n" + //
                            "[ 3 ] Acelerar\n" + //
                            "[ 4 ] Diminuir velocidade\n" + //
                            "[ 5 ] Virar para esquerda\n" + //
                            "[ 6 ] Virar para direita\n" + //
                            "[ 7 ] Verificar velocidade\n" + //
                            "[ 8 ] Trocar a marcha"
        );

        continuar = input.nextInt();

        if(continuar == 1){
            carro.Ligar_o_carro();
        }
        if(continuar == 2){
            carro.Desligar_o_carro();
        }
        if(continuar == 3){
            carro.Acelerar();
        }
        if(continuar == 4){
            carro.diminuir_velocidade();
        }
        if(continuar == 5){
            carro.virar_para_esquerda();
        }
        if(continuar == 6){
            carro.virar_para_direita();
        }
        if(continuar == 7){
            carro.verificar_velocidade();
        }
        if(continuar == 8){
            System.out.println("informe a nova marcha:");
            int novaMarcha = input.nextInt();
            carro.trocar_a_marcha(novaMarcha);
        }
    }while(continuar != 0);
    input.close();
}

}
