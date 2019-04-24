package com.place4code.multiple;

import com.place4code.mythreads.ThreadsColors;

public class Countdown {

    public void doCountdown() {

        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadsColors.ANSI_PURPLE;
                break;
            case "Thread 2":
                color = ThreadsColors.ANSI_BLUE;
                break;
            default:
                color = ThreadsColors.ANSI_GREEN;
                break;
        }

        for (int i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + ", i: " + i);
        }

    }


}
