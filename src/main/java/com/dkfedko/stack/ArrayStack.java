package com.dkfedko.stack;

public class ArrayStack<T> implements Stack<T> {

    private T[] stack = (T []) new Object  [5];
    private int size;

    @Override
    public boolean contains(T value) {
        if (isEmpty()) {
            throw new IllegalStateException("LinkedStack is empty, size = " + size);
        }
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
            T[] newStack = (T[]) new Object[newLength];
            for (int i = 0; i < size; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
    }
    @Override
    public void push(T value) {
        grow();
        stack[size] = value;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty, nothing to pop ");
        }

        T result = stack[size - 1];
        size--;
        return result;
    }

    @Override
    public T peek() {
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

