package java4.fun.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    public void checkEmailsForAnHour(){
        
        final Runnable beeper = new Runnable() {
            @Override
            public void run() {
                System.out.println("Check new emails and auto reply");
            }
        };
        
        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 1, 5, TimeUnit.SECONDS);
        
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                beeperHandle.cancel(true);
            }
        }, 60 * 60, TimeUnit.SECONDS);
    }
    
    public static void main(String...args){
        ScheduledExecutorServiceExample s = new ScheduledExecutorServiceExample();
        s.checkEmailsForAnHour();
    }
}
