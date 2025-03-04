package xanderson.edu.veiculo;


/*
    TODO: Escrever um código onde controlamos as funções de um carro, ele deve ter as seguintes funções:

    Ligar o carro
    Desligar o carro
    Acelerar
    diminuir velocidade
    virar para esquerda
    virar para direita
    verificar velocidade
    trocar a marcha
 */

public class Carro {

    private boolean estado;
    private int     velocidade;
    private int     marcha;
    @SuppressWarnings("unused")
    private String  direcao;

    public Carro(){
        this.estado     = false;
        this.velocidade = 0;
        this.marcha     = 0;
    }


    public void Ligar_o_carro(){       

        if(this.estado){
            System.out.println("O carro já está ligado!");
            return;
        }
        this.estado = true;
        System.out.println("Carro ligado!");
    }

    public void Desligar_o_carro(){
        if(! verifica_ligado())
            return;
        

        if(!this.estado){
            System.out.println("O carro já está desligado!");
            return;
        }
        if(this.velocidade != 0){
            System.out.println("O carro não pode ser desligado pois sua velocidade é superior a 0km por hora!");
            return;
        }
        if(this.marcha != 0){
            System.out.println("O carro não pode ser desligado pois não está em ponto morto!");
            return;
        }

        this.estado = false;
        System.out.println("Carro desligado!");

    }

    public void Acelerar(){
        if(! verifica_ligado())
            return;
        

        if(this.velocidade == 0){
            System.out.println("O veículo está parado!");
        }
        if(this.velocidade <= 20){
            if(this.marcha != 1){
                System.out.println("Para acelerar você precisa usar a 1ª marcha!");
                return;
            }
            this.velocidade ++;
            return;
        }
        if(this.velocidade <= 40){
            if(this.marcha != 2){
                System.out.println("Para acelerar você precisa usar a 2ª marcha!");
                return;
            }
            this.velocidade ++;
            return;
        }
        if(this.velocidade <= 60){
            if(this.marcha != 3){
                System.out.println("Para acelerar você precisa usar a 3ª marcha!");
                return;
            }
            this.velocidade ++;
            return;
        }
        if(this.velocidade <= 80){
            if(this.marcha != 4){
                System.out.println("Para acelerar você precisa usar a 4ª marcha!");
                return;
            }
            this.velocidade ++;
            return;
        }
        if(this.velocidade <= 100){
            if(this.marcha != 5){
                System.out.println("Para acelerar você precisa usar a 5ª marcha!");
                return;
            }
            this.velocidade ++;
            return;
        }
        if(this.velocidade < 120){
            if(this.marcha != 6){
                System.out.println("Para acelerar você precisa usar a 6ª marcha!");
                return;
            }
            this.velocidade ++;
            return;
        }
        if(this.velocidade == 120)
            System.out.println("Esse veículo não atinge uma velocidade maior que 120km");
    }

    public void diminuir_velocidade(){
        if(! verifica_ligado())
            return;
        
        if(this.velocidade == 0){
            System.out.println("O veículo está parado!");
            return;
        }

        if(this.velocidade <= 21){
            if(this.marcha != 1){
                System.out.println("Para diminuir a velocidade você precisa usar a 1ª marcha!");
                return;
            }
            this.velocidade --;
            return;
        }
        if(this.velocidade <= 41){
            if(this.marcha != 2){
                System.out.println("Para diminuir a velocidade você precisa usar a 2ª marcha!");
                return;
            }
            this.velocidade --;
            return;
        }
        if(this.velocidade <= 61){
            if(this.marcha != 3){
                System.out.println("Para diminuir a velocidade você precisa usar a 3ª marcha!");
                return;
            }
            this.velocidade --;
            return;
        }
        if(this.velocidade <= 81){
            if(this.marcha != 4){
                System.out.println("Para diminuir a velocidade você precisa usar a 4ª marcha!");
                return;
            }
            this.velocidade --;
            return;
        }
        if(this.velocidade <= 101){
            if(this.marcha != 5){
                System.out.println("Para diminuir a velocidade você precisa usar a 5ª marcha!");
                return;
            }
            this.velocidade --;
            return;
        }
        if(this.velocidade <= 120){
            if(this.marcha != 6){
                System.out.println("Para diminuir a velocidade você precisa usar a 6ª marcha!");
                return;
            }
            this.velocidade --;
            return;
        }
    }

    public void virar_para_esquerda(){
        if(! verifica_ligado())
            return;
        

        if(!(this.velocidade <= 41 && this.velocidade > 0)){
            System.out.println("Para virar para esquerda se sua velocidade precisa ser de no mínimo 1km e no máximo 40km");
            return;
        }
        this.direcao = "e";
    }

    public void virar_para_direita(){
        if(! verifica_ligado())
            return;
        

        if(!(this.velocidade <= 41 && this.velocidade > 0)){
            System.out.println("Para virar para esquerda se sua velocidade precisa ser de no mínimo 1km e no máximo 40km");
            return;
        }
        this.direcao = "d";    
    }

    public void verificar_velocidade(){
        if(! verifica_ligado())
            return;
        

        System.out.println("Sua velocidade atual é "+ this.velocidade +"km/h");
    }

    public void trocar_a_marcha(int novaMarcha){
        if(! verifica_ligado())
            return;
    
        int proxMarcha = this.marcha + 1;
        int anteMarcha = this.marcha - 1;

        if(novaMarcha < 0){
            System.out.println("Marcha inválida informada!");
            return;
        }

        if (novaMarcha == proxMarcha || novaMarcha == anteMarcha) {
            
            switch (novaMarcha) {
                case 1:
                    if(this.velocidade >= 0   && this.velocidade <= 20){
                        this.marcha = novaMarcha;
                    }
                    break;
                case 2:
                    if(this.velocidade >= 21  && this.velocidade <=  41){
                        this.marcha = novaMarcha;
                    }
                    break;
                case 3:
                    if(this.velocidade >= 41  && this.velocidade <=  61){
                        this.marcha = novaMarcha;
                    }
                    break;
                case 4:
                    if(this.velocidade >= 61  && this.velocidade <=  81){
                        this.marcha = novaMarcha;
                    }
                    break;
                case 5:
                    if(this.velocidade >= 81  && this.velocidade <=  101){
                        this.marcha = novaMarcha;
                    }
                    break;
                case 6:
                    if(this.velocidade >= 101 && this.velocidade <=   120){
                        this.marcha = novaMarcha;
                    }
                    break;

                default:
                    System.out.println("Marcha inválida informada!");
                    break;
            }



            return;
        }
        
        System.out.println("Marcha inválida informada!");

    }
    
    private boolean verifica_ligado(){
        if(! this.estado) {
            System.out.println("Para realizar essa ação primeiro ligue o carro!");
            return false;
        }
        return true;
    }

}
