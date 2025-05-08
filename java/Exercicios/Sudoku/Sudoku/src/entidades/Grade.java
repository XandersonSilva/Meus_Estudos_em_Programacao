package entidades;

import java.util.LinkedHashMap;
import java.util.Map;
import util.NovoJogo;

public class Grade{
    private  Map<Integer, Map<Integer, Quadrado>> grade = new LinkedHashMap<>();
    private boolean jogando = false;
        
    public boolean iniciarJogo(){
        if (jogando) {
            return false;
        }
        grade = NovoJogo.tabuleiro;
        jogando = true;
        return true;
    }

    public int     contarErros(){
        int contador = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (! grade.get(i).get(j).verificaCorreto() && grade.get(i).get(j).pegarAtual()!= 0) 
                contador++;
            }
        }
        return contador;
    }

    public int haVazios(){
        int contador = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grade.get(i).get(j).pegarAtual() == 0) 
                    contador++;
            }
        }
        return contador;
    }

    public String verificarStatus(){
        if (!jogando) {
            return "Não iniciado!";
        }
        if (jogando || this.haVazios() != 0 || this.contarErros() != 0) {
            return "Incompleto!";
        }
        return "Completo!";
    }

    public boolean terminarJogo(){
        if (this.haVazios() != 0 && this.contarErros() == 0) {
            jogando = false;
            return true;
        }
        return false;
    }

    public boolean preencherCedula(int linha, int coluna, int numero){
        if(grade.get(linha).get(coluna).estaFixo() ||
           grade.get(linha).get(coluna).pegarAtual() != 0 ||
           numero > 9 ||
           numero < 1
           ){return false;}

        grade.get(linha).get(coluna).atualizarAtual(numero);
        return true;
    }

    public boolean limparCedula(int linha, int coluna){
        if(grade.get(linha).get(coluna).estaFixo() ||
           grade.get(linha).get(coluna).pegarAtual() == 0 
           ){return false;}

        grade.get(linha).get(coluna).atualizarAtual(0);
        return true;
    }

    public Map<Integer, Map<Integer, Quadrado>> getGrade() {
        return grade;
    }  

    public void limpar(){
        if (!jogando) {
            return;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (! grade.get(i).get(j).estaFixo())
                    grade.get(i).get(j).atualizarAtual(0);
            }
        }
    }
    
    public boolean isJogando() {
        return jogando;
    }
}