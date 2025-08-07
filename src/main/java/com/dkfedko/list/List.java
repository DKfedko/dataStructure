package com.dkfedko.list;

public interface List {
    void add (Object value);
    Object get (int index);
    Object set(Object value, int index);
    Object remove(int index);
    void clear();
    int size();
    boolean isEmpty();
    boolean contains(Object value);
    int index (Object value);
    int lastIndexOf(Object value);
    String toString();

}
