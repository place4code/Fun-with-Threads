package com.place4code.producerconsumer;

import com.place4code.mythreads.ThreadsColors;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {

    private List<String> buffer;
    private String color;
    protected ReentrantLock lock;

    public Consumer(List<String> buffer, String color, ReentrantLock lock) {
        this.buffer = buffer;
        this.color = color;
        this.lock = lock;
    }

    @Override
    public void run() {

        int counter = 0;
        while (true) {
            //Here ONLY for example for critical sections:
            if (lock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(ThreadsColors.ANSI_GREEN + "Counter: " + counter);
                    counter = 0;
                    if (buffer.get(0).equals("END")) {
                        System.out.println("Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                counter++;
            }
        }

    }
}
