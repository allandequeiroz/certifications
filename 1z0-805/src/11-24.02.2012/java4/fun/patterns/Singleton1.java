package java4.fun.patterns;

public class Singleton1 {

    private static Singleton1 _instance = new Singleton1();
    
    private Singleton1(){}
    
    public static Singleton1 getInstance(){
        return _instance;
    }
}
