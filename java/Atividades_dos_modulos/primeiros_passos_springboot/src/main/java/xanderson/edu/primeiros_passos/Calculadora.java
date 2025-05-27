package xanderson.edu.primeiros_passos;

import org.springframework.stereotype.Component;


@Component
public class Calculadora {
    public double somar(double a, double b){
        return a + b;
    }

    public double multiplicar(double a, double b){
        return a * b;
    }

    public double dividir(double a, double b){
        return a / b;
    }

    public double subtrair(double a, double b){
        return a - b;
    }

    public double exponenciar(double exponenciando, double expoente){
        return Math.pow(exponenciando, expoente);
    }
    
    public double raizQuadrada(double a){
        return Math.sqrt(a);
    }
}
