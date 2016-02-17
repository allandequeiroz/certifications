package java4.fun.jsr344;

public class RethrowingExceptions {
    
    public static void processOrder() throws IllegalArgumentException, NumberFormatException{
        try{
            throw new IllegalArgumentException("Excecoes sao legais :D");
        }catch(Exception e){
            throw e;
        }
    }
    
    public static void main(String...args){
        RethrowingExceptions.processOrder();
    }
}
