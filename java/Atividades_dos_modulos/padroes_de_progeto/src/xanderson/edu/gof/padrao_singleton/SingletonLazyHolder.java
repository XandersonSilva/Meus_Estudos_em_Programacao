package xanderson.edu.gof.padrao_singleton;
/**
 * Singleton Lazy holder
 */



public class SingletonLazyHolder {

    private static class Holder{
        public static SingletonLazyHolder intancia = new SingletonLazyHolder();

    }

    private SingletonLazyHolder(){
        super();
    }

    public static SingletonLazyHolder getInstance(){
        return Holder.intancia;
    }

}
