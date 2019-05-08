package com.place4code.producerconsumer;

import com.place4code.mythreads.ThreadsColors;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public Consumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals("END")) {
                        System.out.println("Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
