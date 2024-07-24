package assignments.day13.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor=Executors.newFixedThreadPool(4);
        List<Future<String>> futures=new ArrayList<>();
        for(int i=0; i<10; i++) {
            int taskId=i;
            Callable<String> task=()->{
                performComplexOperation(taskId);
                return "Task "+taskId+" completed";
            };
            Future<String> future = executor.submit(task);
            futures.add(future);
        }
        for(Future<String> future:futures) {
                try {
                    System.out.println(future.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        executor.shutdown();
        try {
            if(!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void performComplexOperation(int taskId) {
        System.out.println("Task "+taskId+" is executing.");
        try {
            Thread.sleep((long)(Math.random()*3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } 
}
