package com.dkfedko.list;

import java.util.StringJoiner;

public class ArrayList<T> implements List<T> {
    private int size;
    private T[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T value) {
        grow();
        elements[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {

        validateIndex(index);
        grow();

        for (int i = 0; i < size; i++) {
            elements[i] = elements[i++];
        }
        elements[index] = value;
        size++;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return elements[index];
    }

    @Override
    public T set(T newValue, int index) {
        validateIndex(index);

        T oldValue = elements[index];
        elements[index] = newValue;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);

        T removed = elements[index];
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
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(elements[i].toString());
        }
        return joiner.toString();
    }
    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("list is empty " + "size = " + size);
        }
    }
    private void grow() {
        if (size == elements.length) {
            int extendedList = elements.length * 2;
            T[] newList = (T[]) new Object[extendedList];
            System.arraycopy(elements, 0, newList, 0, elements.length);
            elements = newList;
        }
    }
}