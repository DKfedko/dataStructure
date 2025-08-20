package com.dkfedko.stack;

public interface Stack<T> {

    void push (T value);

    Object pop ();

    Object peek();

    boolean isEmpty();

    int size();

    void clean();

    boolean contains(T value);

    void removeTopValue();

}
