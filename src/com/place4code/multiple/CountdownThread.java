package com.place4code.multiple;

public class CountdownThread extends Thread {

    private Countdown countdownClass;

    public CountdownThread(Countdown countdownClass) {
        this.countdownClass = countdownClass;
    }

    @Override
    public void run() {
        countdownClass.doCountdown();
    }
}
