package com.dkfedko;

public interface Stack {

    void push (Object value);

    Object pop ();

    Object peek();

    boolean isEmpty();

    int size();

    void clean();

    Object copyStack(Object value);

    Object reversCopy(Object value);

    boolean contains(Object value);

    void removeTopValue();

}
