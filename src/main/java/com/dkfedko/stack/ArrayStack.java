package com.dkfedko.stack;

public class ArrayStack<T> implements Stack<T> {

    private T[] stack = (T []) new Object  [5];
    private int size;

    @Override
    public boolean contains(T value) {
        validateIndex();
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
            System.arraycopy(stack, 0, newStack, 0, size);
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
        validateIndex();

        T result = stack[size - 1];
        size--;
        return result;
    }

    @Override
    public T peek() {
        validateIndex();
        return stack[size - 1];
    }

    @Override
    public boolean isEmpty() {
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
    private void validateIndex() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty, size = " + size);
        }
    }
}

