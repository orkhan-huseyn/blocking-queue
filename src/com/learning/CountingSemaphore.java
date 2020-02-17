package com.learning;

/**
 * a semaphore is a construct that allows some threads to access a fixed set of
 * resources in parallel. Always think of a semaphore as having a fixed number
 * of permits to give out. Once all the permits are given out, requesting
 * threads, need to wait for a permit to be returned before proceeding forward.
 */
public class CountingSemaphore {
    int usedPermits = 0;
    int maxPermits;

    public CountingSemaphore(int maxPermits) {
        this.maxPermits = maxPermits;
    }

    public CountingSemaphore(int maxPermits, int initialPermits) {
        this.maxPermits = maxPermits;
        this.usedPermits = this.maxPermits - initialPermits;
    }

    public synchronized void acquire() throws InterruptedException {
        while (usedPermits == maxPermits) {
            wait();
        }
        usedPermits++;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while (usedPermits == 0) {
            wait();
        }
        usedPermits--;
        notify();
    }
}
