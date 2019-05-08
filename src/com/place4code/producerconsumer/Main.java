package com.place4code.producerconsumer;

import com.place4code.mythreads.ThreadsColors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        // my thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(5); // how many active threats at time

        Producer  producer = new Producer(buffer, ThreadsColors.ANSI_BLUE);
        Consumer consumer = new Consumer(buffer, ThreadsColors.ANSI_RED);
        Consumer consumer2 = new Consumer(buffer, ThreadsColors.ANSI_PURPLE);
        Consumer consumer3 = new Consumer(buffer, ThreadsColors.ANSI_CYAN);

        // execute threads
        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.execute(consumer2);
        executorService.execute(consumer3);


//        new Thread(producer).start();
//        new Thread(consumer).start();
//        new Thread(consumer2).start();
//        new Thread(consumer3).start();

        //##############################################################
        // Future

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadsColors.ANSI_BLACK + "Callable Interface from Future");
                return "callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        // shutdown threads pool !!! important
        executorService.shutdown();
    }
}
