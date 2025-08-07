package com.dkfedko;

public class ArrayStack implements Stack {

    private Object[] stack = new Object[5];
    private int size;

    @Override
    public Object copyStack(Object value) {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = stack[i];
        }
        return array;
    }

    @Override
    public Object reversCopy(Object value) {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = stack[size - 1 - i];
        }
        return array;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (stack[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    private void grow() {
        if (size == stack.length) {
            int newLength = stack.length * 2;
            Object[] newStack = new Object[newLength];
            for (int i = 0; i < size; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
    }

    @Override
    public void removeTopValue() {
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty, nothing to remove ");
        }
        size--;
    }

    @Override
    public void push(Object value) {
        grow();
        stack[size] = value;
        size++;
    }

    @Override
    public Object pop() {
        if (isEmpty()){
                throw new IllegalStateException("Stack is empty, nothing to pop ");
            }

        Object result = stack[size - 1];
        size--;
        return result;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty, nothing to peek ");
        }
            return stack[size - 1];
        }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
            return false;
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

