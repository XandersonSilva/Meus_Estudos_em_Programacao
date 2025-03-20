package apps;

public class ReprodutorMusical {
    private boolean tocandoMusica = false;
    private String  musica = "";
    
    public void tocarMusica(){
        if(tocandoMusica){
            System.out.println("A música já está tocando!");
            return;
        }
        if(this.musica.isEmpty() || this.musica == null || this.musica == ""){
            System.out.println("Não há música selecionada!");
            return;
        }
        System.out.println("A música está tocando!");
        this.tocandoMusica = true;
    }
    
    public void pausarMusica(){
        if(!tocandoMusica){
            System.out.println("Nenhuma música está sendo reproduzida!");
            return;
        }
        System.out.println("A música foi pausada!");
        this.tocandoMusica = false;
    }
    
    public void pararMusica(){
        if(!tocandoMusica){
            System.out.println("Nenhuma música está sendo reproduzida!");
            return;
        }
        System.out.println("A música foi parada!");
        this.tocandoMusica = false;
    }
    
    public void retrocederMusica(){
        if(!tocandoMusica){
            System.out.println("Nenhuma música está sendo reproduzida!");
            return;
        }
        System.out.println("Tocando a música anterior");
    }
    
    public void avançarMusica(){
        if(!tocandoMusica){
            System.out.println("Nenhuma música está sendo reproduzida!");
            return;
        }
        System.out.println("Tocando a proxima música");
    }
    
    public void selecionarMusica(String musica){
        this.musica = musica;
        System.out.println("A música " + this.musica + " foi selecionada!");
    }
}
