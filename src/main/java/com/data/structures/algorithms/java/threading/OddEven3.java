package com.data.structures.algorithms.java.threading;

public class OddEven3 {
    static volatile int i = 1;
    static int max= 100;
    private static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while(i <= max) {
                    while(i % 2 == 0)
                        waitSafely();
                    if (i > max) {
                        lock.notify();
                        break;
                    }
                    System.out.println(i++);
                    lock.notify();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                while(i <= max) {
                    while(i % 2 != 0)
                        waitSafely();
                    if (i > max) {
                        lock.notify();
                        break;
                    }
                    System.out.println(i++);
                    lock.notify();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private static void waitSafely() {
        try {
            lock.wait();
        } catch (Exception e) {

        }
    }
}
