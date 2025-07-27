package com.dkfedko;

public class ArrayStack implements Stack {

    private Object[] stack = new Object[100];
    private int size;

    @Override
    public Object copyStack(Object value) {
        Object[] array = new Object[stack.length];
        for (int i = 0; i < stack.length; i++) {
            array[i] = stack[i];
        }
        return array;
    }

    @Override
    public Object reversCopy(Object value) {
        Object [] array = new Object[stack.length];
        for (int i = 0; i < size; i++) {
            array[i] = stack[size -1 - i];
        }
        return array;
    }

    @Override
    public void push(Object value) {
        stack[size] = value;
        size++;

    }

    @Override
    public Object pop() {
        Object result = stack[size-1];
        size--;
        return result;
    }

    @Override
    public Object peek() {
        return stack [size - 1];
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clean() {
        size = 0;

    }

}
