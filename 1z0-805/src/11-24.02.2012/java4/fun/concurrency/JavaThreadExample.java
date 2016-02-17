package java4.fun.concurrency;

import java.util.ArrayList;
import java.util.List;


public class JavaThreadExample implements Runnable{
    
    private final long countLenght;

    public JavaThreadExample(long countLenght) {
        this.countLenght = countLenght;
    }

    @Override
    public void run() {
        long sum = 0;
        
        for(long i = 1 ; i < countLenght; i++){
            sum += i;
        }
        
        System.out.println(sum);
    }
    
    public static void main(String...args){
        List<Thread> threads = new ArrayList<>();
        
        for(int i = 0 ; i < 200 ; i++){
            Runnable task = new JavaThreadExample(10000000L+i);
            Thread worker = new Thread(task);
            
            worker.setName(String.valueOf(i));
            worker.start();
            
            threads.add(worker);
        }
        
        int running = 0;
        
        do{
            running = 0;
            for(Thread thread : threads){
                if(thread.isAlive()){
                    running++;
                }
            }
            
            System.out.println("There " + running + " thread running.");
        }while(running > 0);
    }
    
    
}
