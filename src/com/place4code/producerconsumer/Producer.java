package com.place4code.producerconsumer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public Producer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String value : nums) {
            try {
                System.out.println(color + "Adding > " + value  + " <");
                buffer.put(value);
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
                e.printStackTrace();
            }
        }
        System.out.println(color + "Adding END and exiting");
        try {
            buffer.put("END");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
