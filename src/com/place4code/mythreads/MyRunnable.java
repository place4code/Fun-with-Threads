package com.place4code.mythreads;

import static com.place4code.mythreads.ThreadsColors.ANSI_CYAN;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_CYAN + "RunnableThread");
    }

}
