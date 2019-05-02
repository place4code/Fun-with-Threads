package com.place4code.producerconsumer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock lock;

    public Producer(List<String> buffer, String color, ReentrantLock lock) {
        this.buffer = buffer;
        this.color = color;
        this.lock = lock;
    }

    @Override
    public void run() {
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String value : nums) {
            try {
                System.out.println(color + "Adding > " + value  + " <");
                lock.lock();
                buffer.add(value);
                lock.unlock();
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
                e.printStackTrace();
            }
        }
        System.out.println(color + "Adding END and exiting");
        lock.lock();
        buffer.add("END");
        lock.unlock();

    }
}
