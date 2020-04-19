package main.java;

/*
Demonstrates work with Thread Pools.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


//This defines a unit of work for the Thread Pool to run.
class Process implements Runnable {

    private int id;

    public Process (int id){
        this.id = id;
    }

    public void run(){

        System.out.println( "Starting: " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed: "  + id);

    }
}

public class ThreadPools {

    public static void main(String[] args) throws InterruptedException {

        //Creates a Thread Pool with two threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //Submits a new chunk of work to the Thread Pool
        for(int i =0; i< 5; i++){
            executorService.submit(new Process(i));
        }
        executorService.shutdown(); // The threadpool will shutdown once all submitted jobs are compelted.
        System.out.println("All tasks submitted");

        executorService.awaitTermination(1, TimeUnit.DAYS); // The Threadpool will stay open for either a day
                                                               // or when all the threads terminate. whatever comes first

        System.out.println("All tasks completed");
    }

}
