package com.dkfedko.queue;

import java.util.StringJoiner;

public class ArrayQueue<T> implements Queue<T> {

    private Object[] arrayQueue = new Object[5];
    private int size;

    @Override
    public void enqueue(Object value) {
        grow();
        arrayQueue[size] = value;
        size++;

    }
    @Override
    public T dequeue() {
        validateIndex();
        T result = (T) arrayQueue[0];
        for (int i = 1; i< size; i++){
            arrayQueue [i-1] =arrayQueue [i];
        }
        size--;
        return result;
    }

    @Override
    public T peek() {
        validateIndex();
        return (T) arrayQueue[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clean() {
        size = 0;
    }

    @Override
    public boolean contains(Object value) {
        validateIndex();
        for (int i = 0; i< size; i++) {
            if (arrayQueue[i].equals(value)) {
                return true;
            }
        }
            return false;
    }
    public void grow(){
        if (size == arrayQueue.length){
            int newLength = arrayQueue.length * 2;
                    Object [] newQueue = new Object[newLength];
            System.arraycopy(arrayQueue, 0, newQueue, 0, size);
            arrayQueue = newQueue;
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(arrayQueue[i].toString());
        }
        return joiner.toString();
    }
    private void validateIndex() {
        if (size == 0) {
            throw new IllegalStateException("Array Queue is empty, size = " +size);
        }
    }
}
