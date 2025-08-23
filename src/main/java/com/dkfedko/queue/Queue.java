package com.dkfedko.queue;

public interface Queue<T> {
    void enqueue(T value);
    Object dequeue ();
    Object peek();
    int size();
    boolean isEmpty();
    boolean contains(T value);
    String toString();
}
