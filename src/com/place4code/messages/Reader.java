package com.place4code.messages;

import java.util.Random;

public class Reader implements Runnable {

    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (String latestMessage = message.read(); !latestMessage.equals("Finished");
        latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
