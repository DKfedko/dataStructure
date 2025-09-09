package com.dkfedko.stack;

public class LinkedStack<T> implements Stack<T> {

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
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public T pop() {
        validateIndex();
        T result = head.value;
        head = head.next;
        size--;
        return result;
    }

    @Override
    public T peek() {
        validateIndex();
        return head.value;
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

    @Override
    public boolean contains(T value) {
        validateIndex();

        Node<T> current = head;
        while (current != null) {
            if (current.value == (value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    private void validateIndex() {
        if (isEmpty()) {
            throw new IllegalStateException("LinkedStack is empty, size = " + size);
        }
    }
}
