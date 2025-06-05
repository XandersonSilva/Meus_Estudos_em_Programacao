package xanderson.edu.gof.padrao_singleton;

public class SingletonEager {
    private static SingletonEager intancia = new SingletonEager();

    private SingletonEager(){
        super();
    }

    public static SingletonEager getInstance(){
        return intancia;
    }

}
