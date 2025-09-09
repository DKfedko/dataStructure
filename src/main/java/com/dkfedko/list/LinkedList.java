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
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.prev = current.prev;  //Вставляюю між вузлів
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public T get (int index) {
        validateIndex();

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
        
        return newNode.value;
    }

    @Override
    public T remove(int index) {
        Node<T> currentNode = getCurrentNode(index);
        if (size == 1) {
            clear();
        } else if (index == 0) {
            head = currentNode.next;
            currentNode.next.prev = null;
        } else if (index == size - 1) {
            currentNode.prev = tail;
        }else{
            for (int i = 0; i < index; i++){
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                size --;
            }
        }
        return currentNode.value;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
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
        Node<T> currentNode = head;
        if (head.value.equals(value)) {
            return true;
        } else if (head !=value) {
            currentNode = currentNode.next;
            while (currentNode != null) {
                currentNode = currentNode.next;
                if (currentNode.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {

        Node<T> current = head;
            int index = 0;
            while (current != null) {
                if (current.value.equals(value)) {
                    return index;
                }else{
                    current = current.next;
                    index++;
                }
            }
        return -1;
        }

    @Override
    public int lastIndexOf(T value) {

        Node<T> current = tail;
        int index = size-1;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            } else {
                current = current.prev;
                index--;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        validateIndex();

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
    private Node<T> getCurrentNode(int index) {
        validateIndex();

        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < size; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    private void validateIndex() {
        if (size == 0) {
            throw new IllegalStateException("LinkedList is empty, size = " + size);
        }
    }

    public static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
        }
    }
}
