package com.dkfedko.stack;

public interface Stack {

    void push (Object value);

    Object pop ();

    Object peek();

    boolean isEmpty();

    int size();

    void clean();


    boolean contains(Object value);

    void removeTopValue();

}
