package com.learning;

public class MonitorDemo {

    public static void main(String[] args) throws InterruptedException {
        final BlockingQueueWMonitor<Integer> queue = new BlockingQueueWMonitor<>(5);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
                    queue.enqueue(i);
                    System.out.println("Enqueued " + i);
                }
            } catch (InterruptedException ignored) {
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
                    System.out.println("Thread 2 dequeued: " + queue.dequeue());
                }
            } catch (InterruptedException ignored) {
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
                    System.out.println("Thread 3 dequeued: " + queue.dequeue());
                }
            } catch (InterruptedException ignored) {
            }
        });

        t1.start();
        Thread.sleep(4000);
        t2.start();

        t2.join();

        t3.start();
        t1.join();
        t3.join();
    }
}
