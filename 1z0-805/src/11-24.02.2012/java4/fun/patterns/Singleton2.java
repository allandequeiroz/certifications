package java4.fun.patterns;

public class Singleton2 {
    
    public static Singleton2 _instance;
    
    private Singleton2(){}
    
    public static synchronized Singleton2 getInstance(){
        if(_instance==null){
            _instance = new Singleton2();
        }
        
        return _instance;
    }
}
