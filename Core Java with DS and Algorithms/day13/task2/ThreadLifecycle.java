package assignments.day13.task2;

public class ThreadLifecycle {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Task());
        //NEW state: Thread is created but not yet started.
        System.out.println(thread.getName()+" State: "+thread.getState());
        //Starting the thread: It moves to the RUNNABLE state
        thread.start();
        System.out.println(thread.getName()+" State: "+thread.getState());
        thread.join();
        System.out.println(thread.getName()+" State: "+thread.getState());
    }
}

class Task implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName()+" State in run(): "+Thread.currentThread().getState());
        //Simulating TIMED_WAITING state using sleep().
        try {
            Thread.sleep(1000);
            //Creating another thread to demostrate BLOCKED and WAITING states.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Creating another thread to demonstrate BLOCKED and WAITING states.
        final Object lock=new Object();

        Thread otherThread= new Thread(()->{
            synchronized(lock) {
               
                try {
                    System.out.println(Thread.currentThread().getName()+" is waiting for lock.");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" acquired lock and finished waiting.");
            }
        },"OtherThread");
        otherThread.start();

        //Ensuring otherThread attempts to acquire the lock.
        try {
            Thread.sleep(100); //Brief sleep to ensure otherThread runs and waits for lock.
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        synchronized(lock) {
            //TIMED_WAITING state using sleed().
            try {
                System.out.println(Thread.currentThread().getName()+" acquired lock and will notify.");
                lock.notify();
                Thread.sleep(1000);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            try {
                otherThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}