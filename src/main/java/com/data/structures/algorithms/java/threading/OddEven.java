package com.data.structures.algorithms.java.threading;

public class OddEven {

    public static void main(String[] args) throws InterruptedException {
        new OddEven().printOddEvent();
    }


    private void printOddEvent() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (this) {
                for (int i = 1; i < 100;) {
                    System.out.println(i);
                    notifyAll();
                    try {
                        wait();
                    } catch (InterruptedException e) {}
                    i+=2;
                    notifyAll();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (this) {
                for (int i = 2; i <= 100;) {
                    System.out.println(i);
                    notifyAll();
                    try {
                        wait();
                    } catch (InterruptedException e) {}
                    i+=2;
                    notifyAll();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }


}
