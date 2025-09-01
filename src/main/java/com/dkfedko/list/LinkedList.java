package com.dkfedko.list;

public class LinkedList<T> implements List<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == size - 1) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            for (int i = 0; i < index; i++) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> newNode = head;
        for (int i = 0; i < index; i++) {
            newNode = newNode.next;
        }
        return newNode.value;
    }

    @Override
    public T set(T value, int index) {
        Node<T> newNode = head;
        for (int i = 0; i < index; i++) {
            newNode = newNode.next;
        }
        newNode.prev = newNode.next;
        newNode.next =

            return
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {
       size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value){
        Node<T> newNode = new Node<>(value);
        while (newNode != null){
            if (newNode.value==value){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        return 0;
    }

    @Override
    public int lastIndexOf(T value) {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        return "";
    }

    public static class Node<T>{
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value){
            this.value = value;
        }
    }
}
