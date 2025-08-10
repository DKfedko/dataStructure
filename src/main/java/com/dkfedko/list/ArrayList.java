package com.dkfedko.list;

public class ArrayList implements List {
    private int size;
    private Object[] elements = new Object[DEFAULT_CAPACITY];
    private static final int DEFAULT_CAPACITY = 10;

    @Override
    public void add(Object value) {
        elements[size]=value;
        size++;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(Object value, int index) {
        return null;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
      return size;
    }

    @Override
    public boolean isEmpty() {
        if (size ==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i<size; i++) {
            if (elements[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }


    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }
}
