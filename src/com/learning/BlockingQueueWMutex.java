package com.learning;

public class BlockingQueueWMutex<T> {

    final Object lock = new Object();

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

        return item;
    }
}
