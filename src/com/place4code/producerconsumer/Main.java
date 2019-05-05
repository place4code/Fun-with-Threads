package com.place4code.producerconsumer;

import com.place4code.mythreads.ThreadsColors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        List<String> buffer = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();

        // my thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Producer  producer = new Producer(buffer, ThreadsColors.ANSI_BLUE, lock);
        Consumer consumer = new Consumer(buffer, ThreadsColors.ANSI_RED, lock);
        Consumer consumer2 = new Consumer(buffer, ThreadsColors.ANSI_PURPLE, lock);
        Consumer consumer3 = new Consumer(buffer, ThreadsColors.ANSI_CYAN, lock);

        // execute threads
        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.execute(consumer2);
        executorService.execute(consumer3);
        // shutdown threads pool !!! important
        executorService.shutdown();

//        new Thread(producer).start();
//        new Thread(consumer).start();
//        new Thread(consumer2).start();
//        new Thread(consumer3).start();

    }
}
