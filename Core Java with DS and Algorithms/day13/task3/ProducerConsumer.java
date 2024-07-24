package assignments.day13.task3;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private Queue<Integer> q;
    private int capacity;
    public ProducerConsumer(int cap) {
        q=new LinkedList<>();
        capacity=cap;
    }

    public boolean add(int item) {
        synchronized(q) {
            while(q.size()==capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            q.add(item);
            q.notify();
            System.out.println("Produced: "+item);
            return true;
        }
    }

    public int remove() {
        synchronized(q) {
            while(q.size()==0) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int element=q.poll();
            q.notify();
            System.out.println("Consumed: "+element);
            return element;
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer(5);

        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100); // Simulate time taken to produce an item
                    pc.add(i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(150); // Simulate time taken to consume an item
                    pc.remove();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();

    }
}