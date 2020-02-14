package com.learning;

public class BlockingQueueWMonitor<T> {

    final Object lock = new Object();

    T[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;

    @SuppressWarnings("unchecked")
    public BlockingQueueWMonitor(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void enqueue(T item) throws InterruptedException {
        synchronized (lock) {
            // wait for the queue to have space
            while (size == capacity) {
                lock.wait();
            }

            // reset tail to the beginning if the tail is already
            // at the end of the backing array
            if (tail == capacity) {
                tail = 0;
            }

            // place the item in the tail
            array[tail] = item;
            size++;
            tail++;

            // don't forget to notify any other threads waiting on
            // a change in value of size. There might be consumers
            // waiting for the queue to have at least one element
            lock.notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        T item = null;

        synchronized (lock) {
            // wait for at least one item to be enqueued
            while (size == 0) {
                lock.wait();
            }

            // reset head to start of array if its past the array
            if (head == capacity) {
                head = 0;
            }

            // store the reference to the object being dequeued
            // and overwrite with null
            item = array[head];
            array[head] = null;
            head++;
            size--;

            // don't forget to call notify, there might be another thread
            // blocked in the enqueue method.
            lock.notifyAll();
        }

        return item;
    }
}
