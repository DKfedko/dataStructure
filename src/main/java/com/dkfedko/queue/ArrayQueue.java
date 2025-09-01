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
        if (size == 0) {
            throw new IllegalStateException("ArrayQueue is empty");
        }
        T result = (T) arrayQueue[0];
        for (int i = 1; i< size; i++){
            arrayQueue [i-1] =arrayQueue [i];
        }
        size--;
        return result;
    }

    @Override
    public T peek() {
        if (size  == 0) {
            throw new IllegalStateException("there is no one in queue");
        }
        return (T) arrayQueue[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size==0){
            return true;
        }
        return false;
    }

    @Override
    public void clean() {
        size = 0;

    }

    @Override
    public boolean contains(Object value) {
        if (size  == 0) {
            throw new IllegalStateException("No elements contains");
        }
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
            for (int i = 0; i < size; i++) {
                newQueue [i] = arrayQueue[i];
            }
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
}
