package com.place4code.producerconsumer;

import java.util.List;

public class Consumer implements Runnable {

    private List<String> buffer;
    private String color;

    public Consumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {

        while (true) {
            if (buffer.isEmpty()) continue;
            if (buffer.get(0).equals("END")) {
                System.out.println("Exiting");
                break;
            } else {
                System.out.println(color + "Removed " + buffer.remove(0));
            }
        }
    }
}
