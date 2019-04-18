package com.place4code.mythreads;

import static com.place4code.mythreads.ThreadsColors.ANSI_CYAN;
import static com.place4code.mythreads.ThreadsColors.ANSI_GREEN;
import static com.place4code.mythreads.ThreadsColors.ANSI_RED;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(ANSI_GREEN + "MainThread");

        AnotherThread at = new AnotherThread();
        //set thread name
        at.setName("-> Another Thread");
        at.start();

        //thread with anonymous class
        new Thread() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "AnonymousThread");
            }
        }.start();

        //new Thread  with runnable interface
        //Thread myRunnableThread = new Thread(new MyRunnable());
        //myRunnableThread.start();
        new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "-> Runnable Thread from main");
            }
        }).start();

        System.out.println(ANSI_GREEN + "MainThread");
    }
}
