package java4.fun.concurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockObjectsExample {
    
    static class Person{
        private final String name;
        private final Lock lock = new ReentrantLock();
        
        public Person(String name){
            this.name = name;
        }
        
        public String getName(){
            return this.name;
        }
        
        public boolean impendingConsultation(Person person){
            boolean lock1 = false;
            boolean lock2 = false;
            
            try{
                lock1 = lock.tryLock();
                lock2 = person.lock.tryLock();
            }finally{
                if(!(lock1&&lock2)){
                    if(lock1){
                        lock.unlock();
                    }
                    if(lock2){
                        person.lock.unlock();
                    }
                }
            }
            
            return lock1 && lock2;
        }
        
        public void consult(Person person){
            if(impendingConsultation(person)){
                try{
                    System.out.format("%s: %s has consulted !%n", this.name, person.getName());
                }finally{
                    lock.unlock();
                    person.lock.unlock();
                }
            }else{
                System.out.format("%s: %s started to consult, but saw that I was alredy consulted. %n", this.name, person.getName());
            }
        }
        
        public void sayBye(Person person){
            System.out.format("%s: %s has said bye! %n", this.name, person.getName());
        }
    }
    
    static class MyThreadLoop implements Runnable{
        
        private Person doctor;
        private Person person;
        
        public MyThreadLoop(Person doctor, Person person){
            this.doctor = doctor;
            this.person = person;
        }

        @Override
        public void run() {
            Random random = new Random();
            for(;;){
                try{
                    Thread.sleep(random.nextInt(10));
                }catch(InterruptedException e){}
                
                doctor.consult(person);
            }
        } 
    }
    
    public static void main(String...args){
        final Person doctor = new Person("Joe");
        final Person person = new Person("Pop");
        new Thread(new MyThreadLoop(doctor, person)).start();
    }
}

