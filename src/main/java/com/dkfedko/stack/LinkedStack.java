package com.dkfedko.stack;

import org.w3c.dom.Node;

public class LinkedStack<T> implements Stack<T>{
    Object value;
    Node next;


    @Override
    public void push(T value) {

    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clean() {

    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public void removeTopValue() {

    }
}
