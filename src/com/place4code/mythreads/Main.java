package com.place4code.mythreads;

import static com.place4code.mythreads.ThreadsColors.ANSI_GREEN;
import static com.place4code.mythreads.ThreadsColors.ANSI_RED;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(ANSI_GREEN + "MainThread");

        AnotherThread at = new AnotherThread();
        at.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "AnonymousThread");
            }
        }.start();

        System.out.println(ANSI_GREEN + "MainThread");
    }
}
