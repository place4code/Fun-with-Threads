package com.place4code.producerconsumer;

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

        while (true) {
            lock.lock();
                if (buffer.isEmpty()) {
                    lock.unlock();
                    continue;
                }
                if (buffer.get(0).equals("END")) {
                    System.out.println("Exiting");
                    lock.unlock();
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            lock.unlock();
        }
    }
}
