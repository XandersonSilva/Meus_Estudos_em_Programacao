package edu.xanderson.execoes;

public class FormatadorCepExemplo{

    public static void main(String[] args) {
        try {
            String cepFormatado = formatarCep("23765064");
            System.out.println("Cep formatado: " + cepFormatado);
        } catch (CepInvalidoExecao e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    static String formatarCep(String cep) throws CepInvalidoExecao{
        if (cep.length() != 8)
            throw new CepInvalidoExecao();
            
            //Simulando um cep formatado

            return "23.765-064";
        
    }
    

}