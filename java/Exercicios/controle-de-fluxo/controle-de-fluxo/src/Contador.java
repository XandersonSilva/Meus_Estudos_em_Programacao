import java.util.Scanner;

public class Contador {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro parâmetro");
		int parametroUm = terminal.nextInt();
		System.out.println("Digite o segundo parâmetro");
		int parametroDois = terminal.nextInt();
		
		try {
			
			contar(parametroUm, parametroDois);
		
		}catch (ParametrosInvalidosException exception) {
			System.out.println(exception.getMessage());
		}

        	terminal.close();
		
	}
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		if(parametroDois < parametroUm){
            		throw new ParametrosInvalidosException("O segundo valor deve ser maior que o primeiro valor");
        }
        
		int contagem = parametroDois - parametroUm;
	        for(int i = 0; i <= contagem; i++){
	            System.err.println("Imprimindo o número " + (parametroUm + i));
	        }
	}
}
