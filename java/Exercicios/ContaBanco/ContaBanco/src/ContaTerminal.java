import java.util.Scanner;
import java.util.Locale;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        String numero;
        String agencia;
        String nomeCliente;
        double saldo;
        
        System.out.println("Informe o numero da conta");
        numero = input.nextLine();
        
        System.out.println("Informe a agencia da conta");
        agencia = input.nextLine();
        
        System.out.println("Informe o seu nome");
        nomeCliente = input.nextLine();
        
        System.out.println("Informe o saldo da conta");
        saldo = input.nextDouble();

        input.close();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "+ agencia +", conta "+ numero +" e seu saldo "+ saldo +" já está disponível para saque");

    }
}
