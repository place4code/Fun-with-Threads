package com.place4code.producerconsumer;

import com.place4code.mythreads.ThreadsColors;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> buffer = new ArrayList<>();
        Producer  producer = new Producer(buffer, ThreadsColors.ANSI_BLUE);
        Consumer consumer = new Consumer(buffer, ThreadsColors.ANSI_RED);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
