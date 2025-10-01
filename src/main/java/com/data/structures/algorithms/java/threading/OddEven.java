package com.data.structures.algorithms.java.threading;

public class OddEven {

    static Object MUTEX = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread odd = new Thread(() -> {
            int i = 1;
            while (i <= 100) {
                synchronized (MUTEX) {
                    System.out.println(i);
                    i += 2;
                    MUTEX.notify();
                    try {
                        if (i < 100)
                            MUTEX.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });

        Thread even = new Thread(() -> {
            int i = 2;
            while (i <= 100) {
                synchronized (MUTEX) {
                    System.out.println(i);
                    i += 2;
                    MUTEX.notify();
                    try {
                        if (i < 100)
                            MUTEX.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });

        odd.start();
        even.start();
    }
}
