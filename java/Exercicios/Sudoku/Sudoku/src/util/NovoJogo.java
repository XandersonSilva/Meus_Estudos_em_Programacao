package util;
import java.util.random.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import entidades.Quadrado;

public class NovoJogo {
    Random random = new Random();

    private Map<Integer, Map<Integer, Quadrado>> linhas = gerarListaInicial();
    private Map<Integer, Map<Integer, Quadrado>> colunas = new LinkedHashMap<>();
    private Map<Integer, Map<Integer, Quadrado>> ilhas_3_x_3 = new LinkedHashMap<>();

    Map<Integer, Map<Integer, Quadrado>>  a =  desfazerRepeticoesParteTabuleiro(linhas);

    private Map<Integer, Map<Integer, Quadrado>> gerarColunas(Map<Integer, Map<Integer, Quadrado>> origem){
        Map<Integer, Quadrado> coluna = new LinkedHashMap<>();
        
        for (int aux = 0; aux < 9; aux++){
            coluna = new LinkedHashMap<>();
            int contador = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(aux == j){ coluna.put(contador  ++, origem.get(j).get(i));}
                }
            }
            colunas.put(aux, coluna);
        }
        return colunas;    
    }
    private Map<Integer, Map<Integer, Quadrado>> gerarIlhas(Map<Integer, Map<Integer, Quadrado>> origem){
        for (int ilha = 0; ilha < 9; ilha++) {
            Map<Integer, Quadrado> ilha_3x3 = new LinkedHashMap<>();
        
            int linhaInicio = (ilha / 3) * 3;
            int colunaInicio = (ilha % 3) * 3;
        
            int k = 0;
            for (int i = linhaInicio; i < linhaInicio + 3; i++) {
                for (int j = colunaInicio; j < colunaInicio + 3; j++) {
                    ilha_3x3.put(k++, origem.get(i).get(j));
                }
            }
        
            ilhas_3_x_3.put(ilha, ilha_3x3);
        }
        return ilhas_3_x_3;
    }


    public Map<Integer, Map<Integer, Quadrado>> gerarListaInicial(){
        Map<Integer, Map<Integer, Quadrado>> linhas = new LinkedHashMap<>();
        List<Boolean> fixos  = gerarPossicoesFixas();
        
        for (int i = 0; i < 9; i++) {
            Map<Integer, Quadrado> linha = new LinkedHashMap<>();
            for (int j = 0; j < 9; j++) {
                linha.put(j,new Quadrado(random.nextInt(1,9), fixos.get((i * 9 + j))));
            }
            linhas.put(i ,linha);
        }
        return linhas;
    }

    public List<Boolean> gerarPossicoesFixas(){
        List<Integer> sortidos_fixos = new ArrayList<>();
        List<Boolean> fixos = new ArrayList<>();
        for(int a = 1; a <5; a++){
            sortidos_fixos.add(random.nextInt(20));
        }
        for(int a = 1; a <5; a++){
            sortidos_fixos.add(random.nextInt(20,40));
        }
        for(int a = 1; a <5; a++){
            sortidos_fixos.add(random.nextInt(40,60));
        }
        for(int a = 1; a <5; a++){
            sortidos_fixos.add(random.nextInt(60,81));
        }
        for (int i = 1; i < 83; i++) {
            Integer temp = i;
            fixos.add(true ? sortidos_fixos.contains(temp): false);
        }
        return fixos;
    };

    private Set<Integer> verificarRepeticoes(Map<Integer, Quadrado> lista){
        Map<Integer, Integer> contagem = new HashMap<>();
        Set<Integer> repetidos = new HashSet<>();
    
        for (int i = 0; i < lista.size(); i++) {
            int numero = lista.get(i).getNumero();
            contagem.put(numero, contagem.getOrDefault(numero, 0) + 1);
        }
    
        for (int i = 0; i < lista.size(); i++) {
            int numero = lista.get(i).getNumero();
            if (contagem.get(numero) > 1) {
                repetidos.add(i); 
            }
        }
    
        return repetidos;
    }
    

    private Map<Integer, Map<Integer, Quadrado>> desfazerRepeticoesParteTabuleiro(Map<Integer, Map<Integer, Quadrado>> linhas_){
        Map<Integer, Map<Integer, Quadrado>> linhasInterna = new LinkedHashMap();
        for (int i = 0; i < 9; i++) {
            Map<Integer, Quadrado> linha = new LinkedHashMap<>();
            Set<Integer> usados = new HashSet<>();
            List<Integer> disponiveis = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9));
            int novoNumero = -1;
            
            Set<Integer> rep = verificarRepeticoes(linhas_.get(i));
            for (int j = 0; j < 9; j++) {
                if (!rep.contains(j)) {
                    usados.add(linhas_.get(i).get(j).getNumero());
                    disponiveis.remove(Integer.valueOf(linhas_.get(i).get(j).getNumero()));
                    Collections.shuffle(disponiveis);
                    linha.put(j, new Quadrado(linhas_.get(i).get(j).getNumero(), linhas_.get(i).get(j).estaFixo()));
                }
            }
            for (int indice : rep) {
                if(usados.size() < 9){
                    Collections.shuffle(disponiveis);
                    novoNumero = disponiveis.get(0);
                    disponiveis.remove(0);
                    usados.add(novoNumero);
                    linha.put(indice, new Quadrado(novoNumero, linhas_.get(i).get(indice).estaFixo()));
                }
            }
        linhasInterna.put(i, linha);
        }
        return linhasInterna;
    }



}

