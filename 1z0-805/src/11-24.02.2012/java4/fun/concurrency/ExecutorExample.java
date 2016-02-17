package java4.fun.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String...args){
        
        CountDownLatch cdl1 = new CountDownLatch(10);
        CountDownLatch cdl2 = new CountDownLatch(10);
        CountDownLatch cdl3 = new CountDownLatch(10);
        CountDownLatch cdl4 = new CountDownLatch(10);
        ExecutorService es = Executors.newFixedThreadPool(5);
        
        es.execute(new MyThread(cdl1, "A"));
        es.execute(new MyThread(cdl2, "B"));
        es.execute(new MyThread(cdl3, "C"));
        es.execute(new MyThread(cdl4, "D"));
        
        try{
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        }catch(InterruptedException e){
            System.out.println(e);
        }
        
        es.shutdown();
    }
}

class MyThread implements Runnable {
    
    String name;
    CountDownLatch latch;
    
    public MyThread(CountDownLatch cdl, String a) {
        this.latch = cdl;
        this.name = a;
        new Thread(this);
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 10 ; i++){
            latch.countDown();
        }
    }

}