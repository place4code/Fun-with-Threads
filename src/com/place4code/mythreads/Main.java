package com.place4code.mythreads;

import static com.place4code.mythreads.ThreadsColors.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(ANSI_GREEN + "MainThread");

        final AnotherThread at = new AnotherThread();
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
                try {
                    System.out.println(ANSI_CYAN + "I'm waiting for end of another thread, but I will waiting max 8 second");
                    at.join(8000);
                    System.out.println(ANSI_CYAN + "Ok, I'm running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_PURPLE + "...> Another thread woke me up");
                }
            }
        }).start();

        //at.interrupt();

        System.out.println(ANSI_GREEN + "MainThread");
    }
}
