package edu.xanderson.smartTV;
/* @autor Xanderson Silva;
 * @version 0.1;
 * @since 2025-02-15;
 */

public class app{
    
public static void main(String[] args) {
    
    SmartTV MinhaTV = new SmartTV();

    MinhaTV.MudaEstadoLigada();
    System.out.println("MinhaTV MudaEstadoLigada " + MinhaTV.ligada);
    MinhaTV.MudaCanal(15);
    System.out.println("MinhaTV MudaCanal " + MinhaTV.canal);
    MinhaTV.VoltaCanal();
    System.out.println("MinhaTV VoltaCanal " + MinhaTV.canal);
    MinhaTV.AvancaCanal();
    System.out.println("MinhaTV AvancaCanal " + MinhaTV.canal);
    MinhaTV.AumentaVolume();
    System.out.println("MinhaTV AumentaVolume " + MinhaTV.volume);
    MinhaTV.DiminuVolume();
    System.out.println("MinhaTV DiminuVolume " + MinhaTV.volume);

} 
    
}
