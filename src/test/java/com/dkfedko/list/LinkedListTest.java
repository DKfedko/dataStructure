package com.dkfedko.list;

public class LinkedListTest extends AbstractListTest{
    @Override
    protected List<Integer> createList() {
        return new LinkedList<>();
    }
}
