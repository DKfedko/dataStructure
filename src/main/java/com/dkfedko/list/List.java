package com.dkfedko.list;

public interface List <T> {

    void add(T value);

    // we can add value by index between [0, size]
    // otherwise throw new IndexOutOfBoundsException
    void add(T value, int index);

    // we can get value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException
    T get (int index);

    // we can set value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException
    T set(T value, int index);

    // we can remove value by index between [0, size - 1]
    // otherwise throw new IndexOutOfBoundsException
    T remove(int index);


    void clear();
    int size();
    boolean isEmpty();
    boolean contains(T value);
    int indexOf (T value);
    int lastIndexOf(T value);
    String toString();

}
