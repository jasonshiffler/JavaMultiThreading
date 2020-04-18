package main.java;

import java.util.Scanner;

class Processor extends Thread {

    private volatile boolean running = true; // Prevents Threads from caching variables when
                                             // they aren't changed from that thread


    public void run() {

        while (running) {

            System.out.println("Hello!");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } //close while

    }//close method

    public void shutdown(){
        running = false;
    }

}

public class BasicThreadSynch {

    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press return to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        proc1.shutdown();

    }


}
