package xanderson.edu.petshop;


/*
    TODO: Escreva um código onde temos o controle de banho de um petshop, a maquina de banhos dos pets deve ter as seguintes operações:

    Dar banho no pet
    Abastecer com água
    Abastecer com shampoo
    Verificar nivel de água
    Verificar nivel de shampoo
    Verificar se tem pet no banho
    Colocar pet na maquina
    Retirar pet da máquina
    Limpar maquina

*/


public class Banho {
    
    private int     agua          = 30;
    private int     shampoo       = 10;
    private boolean pet_no_banho  = false;
    private boolean maquina_limpa = true;
    private boolean pet_limpo     = false;
    


    public void  Banhar_pet(){
        if (this.pet_limpo) {
            System.out.println("O pet na máquina já está limpo");
            return;
        }
        
        if (! this.maquina_limpa) {
            System.out.println("Limpe a máquina para realizar essa ação");
            return;
        }

        if (! this.pet_no_banho) {
            System.out.println("Não há pet na máquina");
            return;
        }
        
        if(! (this.agua >= 10 && this.shampoo >= 2)){
            System.out.println("Produtos insuficientes para limpar o pet");
            this.pet_limpo = false;
            this.maquina_limpa = false;
            return;
        }
        this.agua -= 10;
        this.shampoo -= 2;
        this.pet_limpo = true;

        System.out.println("Pet limpo com sucesso");
    }


    public void  Abastecer_agua(){
        if(this.agua >  28){
            System.out.println("Não é possível colocar mais água na máquina");
            return;
        }
        this.agua += 2;
    }

    public void  Abastecer_shampoo(){
        if(this.shampoo > 8){
            System.out.println("Não é possível colocar mais shampoo na máquina");
            return;
        }
        this.shampoo += 2;
    }

    public void  verificar_agua(){
        System.out.println("A máquina possui " + this.agua + " litros de água");
    }

    public void  verificar_shampoo(){
        System.out.println("A máquina possui " + this.shampoo + " litros de shampoo");
    }

    public void  verificar_pet_banho(){
        if(this.pet_no_banho){
            System.out.println("A máquina está ocupada por um pet");
            return;
        }
        System.out.println("A máquina não está ocupada por um pet");
    }

    public void  colocar_pet(){
        if(this.pet_no_banho){
            System.out.println("A máquina está ocupada por um pet");
            return;
        }
        this.pet_no_banho = true;
    }

    public void  retirar_pet(){
        if(! this.pet_no_banho){
            System.out.println("A máquina não está ocupada por um pet");
            return;
        }
        this.pet_no_banho = false;
        this.pet_limpo    = false;
    }
    
    public void  limpar_maquina(){
        if (this.maquina_limpa) {
            System.out.println("A máquina já está limpa!");
            return;
        }

        if (this.pet_no_banho) {
            System.out.println("A máquina não pode ser limpa pois há um pet nela!");
            return;
        }

        if (!(this.agua >= 3 && this.shampoo >= 1)) {
            System.out.println("Para realizar a limpeza da máquia é necessário no minímo 3 litros de água e 1 litro de shampoo");
            return;
        }

        this.maquina_limpa = true;
        this.agua    -= 3;
        this.shampoo -= 1;
    }

}
