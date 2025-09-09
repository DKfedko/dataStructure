package com.dkfedko.stack;

public class ArrayStackTest extends AbstractStackTest {
    @Override
    protected Stack<Integer> createStack() {
        return new ArrayStack<>();
    }
}