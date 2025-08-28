package com.dkfedko.stack;

public class LinkedStackTest extends AbstractStackTest {
    @Override
    protected Stack<Integer> createStack() {
        return new LinkedStack<>();
    }
}


/**
 * //    LinkedStack stack = new LinkedStack<>();
 * //    Stack stack = new LinkedStack();
 *
 * @Override protected Stack<Integer> createStack() {
 * Stack stack = new LinkedStack();
 * return stack ;
 * }
 * }
 */

