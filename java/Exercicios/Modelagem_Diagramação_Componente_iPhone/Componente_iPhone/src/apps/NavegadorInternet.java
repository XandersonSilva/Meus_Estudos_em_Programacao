package apps;

import java.util.ArrayList;

public class NavegadorInternet{
    private String       paginaAtual;
    private ArrayList<String> abasAbertas = new ArrayList<String>();
    private ArrayList<String> historico = new ArrayList<String>();
    
    public void exibirPagina(String url){
        if(url == paginaAtual){
            System.out.println("Você já está acessado a página: " + url );
            return;
        }
        this.paginaAtual = url;
        
        if (!this.historico.contains(url)) {
            this.historico.add(url);
        }
        System.out.println("A página " + this.paginaAtual + " está sendo exibida!");
    }
    
    public void adicionarNovaAba(String url){
        this.abasAbertas.add(url);
        exibirPagina(url);
        System.out.println("A nova aba está exibindo a página " + url);
    }
    
    public void atualizarPagina(){
        System.out.println("Página atualizada!");
    }
}