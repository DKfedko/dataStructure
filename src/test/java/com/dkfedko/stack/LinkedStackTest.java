package com.dkfedko.stack;

public class LinkedStackTest extends AbstractStackTest {
    @Override
    protected Stack<Integer> createStack() {
        return new LinkedStack<>();
    }
}


