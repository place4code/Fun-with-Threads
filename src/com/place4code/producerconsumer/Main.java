package com.place4code.producerconsumer;

import com.place4code.mythreads.ThreadsColors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        List<String> buffer = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        Producer  producer = new Producer(buffer, ThreadsColors.ANSI_BLUE, lock);
        Consumer consumer = new Consumer(buffer, ThreadsColors.ANSI_RED, lock);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
