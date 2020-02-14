package com.learning;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueWMutex<T> {

    Lock lock = new ReentrantLock();

    T[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;

    @SuppressWarnings("unchecked")
    public BlockingQueueWMutex(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void enqueue(T item) throws InterruptedException {

    }

    public T dequeue() throws InterruptedException {
        T item = null;

        lock.lock();
        while (size == 0) {
            lock.unlock();
            lock.lock();
        }

        if (head == capacity) {
            head = 0;
        }

        item = array[head];
        array[head] = null;
        head++;
        size--;

        lock.unlock();
        return item;
    }
}
