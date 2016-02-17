package java4.fun.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableExample {

}

class VisitorCounter{
    private int visitor = 0;
    
    public void incrementVisitor(){
        visitor++;
    }
    
    public void decrementVisitor(){
        visitor--;
    }
    
    public int currentVisitors(){
        return visitor;
    }
}

class SynchronizedVisitorCounter{
    private int visitor = 0;
    
    public synchronized void incrementVisitor(){
        visitor++;
    }
    
    public synchronized void decrementVisitor(){
        visitor--;
    }
    
    public synchronized int currentVisitors(){
        return visitor;
    }
}

class AtomicVisitorCounter{
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    
    public void incrementVisitor(){
        atomicInteger.incrementAndGet();
    }
    
    public void decrementVisitor(){
        atomicInteger.decrementAndGet();
    }
    
    public int currentVisitors(){
        return atomicInteger.get();
    }
}