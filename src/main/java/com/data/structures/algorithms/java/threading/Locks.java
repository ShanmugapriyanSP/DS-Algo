package com.data.structures.algorithms.java.threading;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Task sharedTask = new Task();
        BarrierTask barrierTask = new BarrierTask();
        for (int i = 0; i < 5; i++) {
            executorService.submit(sharedTask);
            executorService.submit(barrierTask);
        }
        Phaser phaser = new Phaser();
        executorService.submit(new PhaserTask(phaser, false));
        executorService.submit(new PhaserTask(phaser, true));
        executorService.submit(new PhaserTask(phaser, true));
        executorService.submit(new PhaserTask(phaser, false));

        try {
            exchangerTask();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown(); // wait for submitted tasks to complete
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS); // wait max 10 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void exchangerTask() throws InterruptedException {
        Exchanger<Queue<String>> readerExchange = new Exchanger<>();
        Exchanger<Queue<String>> writerExchange = new Exchanger<>();

        Runnable readerTask = () -> {
            Queue<String> readerQueue = new ConcurrentLinkedQueue<>();
            int i = 0;
            while(i < 100) {
                System.out.println("Reader task -- " + i);
                readerQueue.add(UUID.randomUUID().toString());
                i++;
                if (i == 99) {
                    i = 0;

                    try {
                        readerQueue = readerExchange.exchange(readerQueue);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        };

        Runnable processorTask = () -> {
            Queue<String> processorBuffer = new ConcurrentLinkedQueue<>();
            Queue<String> writerBuffer = new ConcurrentLinkedQueue<>();
            try {
                processorBuffer = readerExchange.exchange(processorBuffer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            while(true) {
                System.out.println("processor task -- " + processorBuffer.size());
                writerBuffer.add(processorBuffer.poll());
                if (processorBuffer.isEmpty()) {
                    try {
                        processorBuffer = readerExchange.exchange(processorBuffer);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        writerBuffer = writerExchange.exchange(writerBuffer);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Runnable writerTask = () -> {
            Queue<String> writerBuffer = new ConcurrentLinkedQueue<>();
            try {
                writerBuffer = writerExchange.exchange(writerBuffer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                System.out.println("writer task -- " + writerBuffer.size());
                System.out.println(writerBuffer.poll());
                if (writerBuffer.isEmpty()) {
                    try {
                        writerBuffer = writerExchange.exchange(writerBuffer);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        CompletableFuture.allOf(
          CompletableFuture.runAsync(readerTask),
          CompletableFuture.runAsync(processorTask),
          CompletableFuture.runAsync(writerTask)
        ).join();
    }
}


class Task implements Runnable {
    static ReentrantLock lock = new ReentrantLock(true);
    public volatile int counter = 0;

    @Override
    public void run() {
        increment();
        System.out.println(Thread.currentThread().getName() +" -- " + counter);
    }

    public void increment() {
        boolean success = false;
        try {
            success = lock.tryLock();
            if (success)
                counter++;
        } finally {
            if (success)
                lock.unlock();
        }
    }
}

class BarrierTask implements Runnable {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
        System.out.println(Thread.currentThread().getName() + " Reached barrier");
    });
    public volatile int counter = 0;
    @Override
    public void run() {
        increment();
    }

    public void increment() {
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " Before barrier");
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " After barrier");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            counter++;

        } finally {

        }
    }
}

class PhaserTask implements Runnable {
    public volatile int counter = 0;
    public Phaser phaser;
    public boolean exitEarly;
    PhaserTask(Phaser phaser, boolean exitEarly) {
        this.phaser = phaser;
        this.exitEarly = exitEarly;
        this.phaser.register();
    }
    @Override
    public void run() {
        try {
            // Phase 1: Load
            phase("Loading data");
            phaser.arriveAndAwaitAdvance();

            if (exitEarly) {
                System.out.println("Leaving early");
                phaser.arriveAndDeregister();
            }

            // Phase 2: Parse
            phase("Parsing data");
            phaser.arriveAndAwaitAdvance();

            // Phase 3: Process
            phase("Processing data");
            phaser.arriveAndAwaitAdvance();
            phaser.arriveAndDeregister();

            System.out.println("All phases complete");
        } catch (Exception e) {
            System.out.println("encountered an error: " + e.getMessage());
        }
    }

    public void phase(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep((long)(Math.random() * 1000));
    }
}
