package edu.xanderson.smartTV;

public class SmartTV {
    
    boolean ligada;
    int canal;
    int volume;

    public void MudaCanal(int novoCanal){
        canal = novoCanal;
    }

    public void MudaEstadoLigada(){
        ligada = ligada ? false : true;
    }
    
    public void VoltaCanal (){
        canal--;
    }

    public void AvancaCanal (){
        canal++;
    }
    
    public void AumentaVolume(){
        volume++;
    }
    
    public void DiminuVolume(){
        volume--;
    }
}
