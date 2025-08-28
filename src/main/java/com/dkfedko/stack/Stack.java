package com.dkfedko.stack;

public interface Stack<T> {

    boolean contains(T value);

    void push (T value);

    T pop ();

    T peek();

    boolean isEmpty();

    int size();

    void clean();
}
