package main.java;

/*
Two Basic ways to create threads. Implement the Runnable interface or extend the Thread class.
 */

class RunThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 10; i++){
            System.out.println("Hello Thread! " + i);

            try {
                Thread.sleep(50);
            } catch (Exception e){
                e.printStackTrace();
            }
        }// close for

    }
}

class Runner extends Thread{

    @Override
    public void run(){
        for (int i = 1; i < 10; i++){
            System.out.println("Hello Thread! " + i);

            try {
            Thread.sleep(50);
            } catch (Exception e){
                e.printStackTrace();
            }
        }// close for
    }//close method
}//close class


public class CreatingThreadsWithThread {

    public static void main(String[] args) {

        Runner runner1 = new Runner();
        Runner runner2 = new Runner();

        //The start method looks for a method called run
        runner1.start();
        runner2.start();

        Thread t1 = new Thread(new RunThread());
        Thread t2 = new Thread(new RunThread());

        t1.start();
        t2.start();

        // This is a short cut to using an anonymous class
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 11; i < 20; i++){
                    System.out.println("Hello Thread! " + i);

                    try {
                        Thread.sleep(50);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }// close
            }
        });

        t3.start();


    }



}
