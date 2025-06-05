package xanderson.edu.gof;

import xanderson.edu.gof.padrao_facade.Facade;
import xanderson.edu.gof.padrao_singleton.SingletonEager;
import xanderson.edu.gof.padrao_singleton.SingletonLazy;
import xanderson.edu.gof.padrao_singleton.SingletonLazyHolder;

import xanderson.edu.gof.padrao_strategy.Comportamento;
import xanderson.edu.gof.padrao_strategy.ComportamentoAgressivo;
import xanderson.edu.gof.padrao_strategy.ComportamentoDefensivo;
import xanderson.edu.gof.padrao_strategy.ComportamentoNormal;
import xanderson.edu.gof.padrao_strategy.Robo;


public class App {
    public static void main(String[] args) throws Exception {

        // Testes Desing pattern Singleton
        
        SingletonLazy lazy = SingletonLazy.getInstance();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstance();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstance();
        System.out.println(eager);
        eager = SingletonEager.getInstance();
        System.out.println(eager);


        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(lazyHolder);



        // Testes Desing pattern Strategy
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento normal = new ComportamentoNormal();        
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();

        robo.setComportamento(defensivo);
        robo.mover();
        robo.setComportamento(normal);
        robo.mover();
        robo.setComportamento(agressivo);
        robo.mover();

        // Testes Desing pattern Facade
        Facade facade = new Facade();
        facade.migrarCliente("nome sob", "1201212");
    }
}
