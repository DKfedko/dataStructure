package com.dkfedko.list;

public class ArrayListTest extends AbstractListTest{
    @Override
    protected List<Integer> createList() {
        return new ArrayList<>();
    }
}