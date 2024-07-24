package assignments.day13.task7;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private final AtomicInteger value=new AtomicInteger(0);

    public void increment() {
        value.incrementAndGet();
    }

    public void decrement() {
        value.decrementAndGet();
    }

    public int getValue() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();

        Runnable incrementTask=()->{
            for(int i=0; i<1000; i++) {
                counter.increment();
            }
        };

        Runnable decrementTask=()->{
            for(int i=0; i<500; i++) {
                counter.decrement();
            }
        };

        Thread thread1=new Thread(incrementTask);
        Thread thread2=new Thread(decrementTask);
        Thread thread3=new Thread(incrementTask);
        Thread thread4=new Thread(decrementTask);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println("Final Counter Value: "+counter.getValue());
    }
}
