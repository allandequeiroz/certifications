package java4.fun.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureAndCallableExample implements Callable<Long> {
    
    private static final int TOTAL_THREADS = 10;

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for(long i = 0 ; i < 200 ; i++){
            sum += 1;
        }
        return sum;
    }

    public static void main(String...args){
        ExecutorService executor = Executors.newFixedThreadPool(TOTAL_THREADS);
        
        List<Future<Long>> list = new ArrayList<>();
        for(int i = 0 ; i < 1000 ; i++){
            Callable worker = new FutureAndCallableExample();
            Future submit = executor.submit(worker);
            list.add(submit);
        }
        
        long sum = 0;
        System.out.println(list.size());
        
        for(Future future : list){
            try{
                sum += ((Long)future.get()).longValue();
            }catch(InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }
        
        System.out.println(sum);
        executor.shutdown();
    }
    
}
