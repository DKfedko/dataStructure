package com.dkfedko.queue;

public interface Queue {
    void enqueue(Object value);
    Object dequeue ();
    Object peek();
    int size();
    boolean isEmpty();
    boolean contains(Object value);
    String toString();
}
