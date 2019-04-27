package com.place4code.messages;

import java.util.Random;

public class Writer implements Runnable {

    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {

        String msgs[] = {
                "wpis 1",
                "wpis 2",
                "wpis 3",
                "wpis 4",
                "wpis 5"
        };

        for (int i = 0; i < msgs.length; i++) {
            message.write(msgs[i]);
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        message.write("Finished");

    }
}
