package com.place4code.mythreads;

import static com.place4code.mythreads.ThreadsColors.ANSI_BLUE;
import static com.place4code.mythreads.ThreadsColors.ANSI_PURPLE;

public class AnotherThread extends Thread {

    @Override
    public void run() {

        System.out.println(ANSI_BLUE + "" + currentThread().getName());

        try {
            System.out.println("...> I'm going to sleep for 3 second");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_PURPLE + "...> Another thread woke me up");
        }

        System.out.println(ANSI_BLUE + "...> 3 second have passed, I'm awake!");

    }

}
