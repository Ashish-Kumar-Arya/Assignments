package assignments.day13.task6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class PrimeNumberCalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int numThreads=4;
        ExecutorService executor=Executors.newFixedThreadPool(numThreads);
        List<Future<List<Integer>>> futures=new ArrayList<>();
        //Dividing the task into smaller ranges and submitting tasks
        int rangeSize=number/numThreads;
        for(int i=0; i<numThreads; i++) {
            int start = i*rangeSize+1;
            int end=(i==numThreads-1)?number:(i+1)*rangeSize;
            Callable<List<Integer>> task=()->calculatePrimesInRange(start, end);
            futures.add(executor.submit(task));
        }

        //Collecting results from the future
        List<Integer> allPrimes=new ArrayList<>();
            for(Future<List<Integer>> future:futures) {
                try {
                    allPrimes.addAll(future.get());
                }
                catch(Exception e) {
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
        //Using CompletableFuture to write results to a file asynchronously
        CompletableFuture<Void> writeFuture=CompletableFuture.runAsync(()->
        {
            try {
                writePrimeToFile(allPrimes, "/home/ashish/Desktop/primes.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        writeFuture.join();
        System.out.println("Prime numbers written to primes.txt");
    }


    public static List<Integer> calculatePrimesInRange(int start, int end) {
        List<Integer> primes=new ArrayList<>();
        for(int i=start; i<=end; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean isPrime(int n) {
        for(int i=2; i<n; i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }

    public static void writePrimeToFile(List<Integer> primes, String filename) throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter(filename));
            for(Integer prime:primes) {
                writer.write(prime.toString());
                writer.newLine();
            }
            writer.close();     
        
    }
}