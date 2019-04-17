package com.place4code.mythreads;

import static com.place4code.mythreads.ThreadsColors.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "AnotherThread");
    }

}
