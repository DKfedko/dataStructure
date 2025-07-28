package com.dkfedko;

public interface Stack {
    void push (Object value);

    Object pop();

    Object peek();

    boolean empty();

    int size();

    void clean();

    Object copyStack();

    Object reversCopy();

    Object removeHalf (Object value);

    boolean contains(Object value);
}
