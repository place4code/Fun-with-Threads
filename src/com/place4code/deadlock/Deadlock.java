package com.place4code.deadlock;

public class Deadlock {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {

        new Thread1().start();
        new Thread2().start();

    }


    /*
    Kiedy   wątek   wywołuje   na   rzecz   jakiegoś   obiektu   metodę   synchronizowaną,
    automatycznie  zamykany  jest  monitor  (obiekt  jest  zajmowany  przez  wątek).
    Inne  wątki usiłujące  wywołać  na  rzecz  tego  obiektu  metodę  synchronizowaną  (niekoniecznie  tąsamą)
    lub   usiłujące   wykonać   instrukcjęsynchronized   z   podaną   referencją
    do zajętego  obiektu  są  blokowane  i  czekają  na  zakończenie  wykonywania  metody
    lub instrukcji synchronized przez wątek, który zajął obiekt (zamknął monitor).
    Dowole    zakończenie    wykonywania    metody    synchronizowanej    lub
    instrukcji synchronized  zwalnia  monitor,  dając  czekającym  wątkom  możliwość  dostępu  do obiektu.
    */

    // ##################################################################
    // DEADLOCK:

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1 has lock 1");
                try {
                    Thread.sleep(2000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 waiting for lock 2 ");
                synchronized (lock2) {
                    System.out.println("Thread 1: has lock 1 and lock 2");
                }
                System.out.println("Thread 1 released lock 2");
            }
            System.out.println("Thread 1 released lock 1, exiting...");
        }
    }


    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2 has lock 2");
                try {
                    Thread.sleep(2000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2 waiting for lock 1 ");
                synchronized (lock1) {
                    System.out.println("Thread 2: has lock 2 and lock 1");
                }
                System.out.println("Thread 2 released lock1");
            }
            System.out.println("Thread 2 released lock 2, exiting...");
        }
    }


}



