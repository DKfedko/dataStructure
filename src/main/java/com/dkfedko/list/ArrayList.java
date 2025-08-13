package com.dkfedko.list;

public class ArrayList implements List {
    private int size;
    private Object[] elements = new Object[DEFAULT_CAPACITY];
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        this.elements = new Object[capacity];
    }

    @Override
    public void add(Object value) {
        elements[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Add element to index 0 first");
        }
        for (int i = 0; i < size; i++) {
            elements[i] = elements[i++];
        }
        elements[index] = value;
        size++;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("ArrayList is out of bounds");
        }
        return elements[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("ArrayList is out of bounds");
        }
        return elements[index] = value;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("ArrayList is out of bounds");
        }
        Object list1 = elements[5];
        for (int i = 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return list1;
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
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i] == value) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String start = "[";
        for (int i = 0; i < size; i++) {
            start = start + elements[i];
            start = start + ",";
            start = start + " ";
        }
        start += "]";
        return start;
    }
}