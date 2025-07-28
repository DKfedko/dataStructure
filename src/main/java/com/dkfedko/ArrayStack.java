package com.dkfedko;

public class ArrayStack implements Stack {

    private Object[] stack = new Object[100];
    private int size;

    @Override
    public Object copyStack() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array [i] = stack[i];
        }
        return array;
    }

    @Override
    public Object reversCopy() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = stack [size - 1 - i];
        }
        return array;
    }

    @Override
    public Object removeHalf(Object value) {
        return stack[size / 2];
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++){
            if (stack[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void push(Object value) {
        stack[size] = value;
        size++;

    }

    @Override
    public Object pop() {
        Object result = stack[size - 1];
        size--;
        return result;
    }

    @Override
    public Object peek() {
        return stack[size - 1];
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

