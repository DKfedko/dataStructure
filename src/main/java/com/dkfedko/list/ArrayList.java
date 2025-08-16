package com.dkfedko.list;

public class ArrayList implements List {
    private int size;
    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 10;


    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];

    }

    public ArrayList(int capacity) {
        this.elements = new Object[capacity];
    }

    @Override
    public void add(Object value) {
        grow();
        elements[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {

        validateIndex(index);
        grow();

        for (int i = 0; i < size; i++) {
            elements[i] = elements[i++];
        }
        elements[index] = value;
        size++;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        return elements[index];
    }

    @Override
    public Object set(Object newValue, int index) {
        validateIndex(index);

        Object oldValue = elements[index];
        elements[index] = newValue;
        return oldValue;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        if (size == 0) {
            throw new IllegalStateException("size is " + size + " nothing to remove");
        }
        Object removed = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removed;
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
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++){
            result = result + elements[i];
            if (i < size - 1){
                result = result + ", ";
            }
        }
        result += "]";
        return result;
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("list is empty " + "size = " + size);
        }
    }
    private void grow() {
        if (size == elements.length) {
            Object[] extendedList = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; size++) {
                extendedList[i] = elements[i];
            }
            elements = extendedList;
        }

    }
}