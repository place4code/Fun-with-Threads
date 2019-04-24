package com.place4code.multiple;

public class Main {
    public static void main(String[] args) {

        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        t1.start();

        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");
        t2.start();

    }
}
