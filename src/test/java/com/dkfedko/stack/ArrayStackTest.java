package com.dkfedko.stack;

class ArrayStackTest extends AbstractStackTest {
    @Override
    protected Stack<Integer> createStack() {
        return new ArrayStack();
    }

    /**
     *  @Override
     *     protected Stack<Integer> createStack() {
     *         Stack<Integer> stack = new ArrayStack<>();
     *         return stack;
     *     }
     */
}
