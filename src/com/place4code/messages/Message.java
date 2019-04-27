package com.place4code.messages;

public class Message {

    private String message;
    private boolean empty = true;

    public synchronized String read() {

        while(empty) {

            //nothing to read = sleep
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        empty = true;
        //threads are awake:
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {

        while (!empty) {

            //nothing to write = sleep
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        empty = false;
        this.message = message;
        //threads are awake:
        notifyAll();

    }

}
