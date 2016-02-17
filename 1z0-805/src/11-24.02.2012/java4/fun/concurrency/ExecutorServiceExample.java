package java4.fun.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample implements Runnable{
    
    private int sleepTime;
    private String threadName;
    private static Random generator = new Random();
    
    public ExecutorServiceExample(String name){
        this.threadName = name;
        this.sleepTime = generator.nextInt(5000);
    }

    @Override
    public void run() {
        try{
            System.out.printf("%s going to sleep for %d miliseconds.\n", threadName, sleepTime);
            Thread.sleep(sleepTime);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.printf("%s done sleeping\n", threadName);
    }
    
    public static void main(String...args){
        ExecutorServiceExample task1 = new ExecutorServiceExample("thread1");
        ExecutorServiceExample task2 = new ExecutorServiceExample("thread2");
        ExecutorServiceExample task3 = new ExecutorServiceExample("thread3");
        
        System.out.println("Starting threads");
        
        ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
        
        threadExecutor.execute(task1);
        threadExecutor.execute(task2);
        threadExecutor.execute(task3);
        
        threadExecutor.shutdown();
        
        System.out.println("Thread started, main ends\n");
    }
}
