package com.dkfedko.queue;

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
    public Object dequeue() {
        if (size == 0) {
            throw new IllegalStateException("ArrayQueue is empty");
        }
        Object result = arrayQueue[0];
        for (int i = 1; i< size; i++){
            arrayQueue [i-1] =arrayQueue [i];
        }
        size--;
        return result;
    }

    @Override
    public Object peek() {
        if (size  ==0) {
            throw new IllegalStateException("there is no one in queue");
        }
        return arrayQueue[0];
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
        String start = "[";
        for (int i = 0; i < size; i++){
        start = start + arrayQueue[i];
        start = start + ",";
        start = start + " ";
        }
        start +="]";
        return start;
    }
}
