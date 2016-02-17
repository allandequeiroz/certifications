package java4.fun.patterns;

public enum Singleton3 {
    
    INSTANCE;

    public void initConfigValues(){}
    
    public static void main(String...args){
        Singleton3 singleton = Singleton3.INSTANCE;
        singleton.initConfigValues();
    }
}
