package com.dkfedko.queue;

public class LinkedQueue<T> implements Queue<T> {

    Node<T> head;
    int size;

    public static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    @Override
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()){
            head = newNode;
        }else {
            Node<T> current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next  = newNode;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()){
            throw new IllegalStateException("LinkedQueue is empty, size = " + size);
        };
       Object result = head.value;
       head = head.next;
       size --;
       return result;
    }

    @Override
    public Object peek() {
        if (isEmpty()){
            throw new IllegalStateException("LinkedQueue is empty, size = " + size);
        };
        return head.value;
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
    public boolean contains(T value) {
        if (isEmpty()){
            throw new IllegalStateException("LinkedQueue is empty, size = " + size);
        };
        Node<T> current  = head;
        while (current != null){
            if (current.value == (value)){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    @Override
    public void clean() {
        size =0;
    }
}
