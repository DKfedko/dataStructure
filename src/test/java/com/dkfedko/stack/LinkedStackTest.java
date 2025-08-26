package com.dkfedko.stack;

public class LinkedStackTest extends AbstractStackTest<Integer> {

    @Override
    protected Stack<Integer> createStack() {
        return new LinkedStack<>();
    }
}


/**
 * //    LisnkedStack stack = new LinkedStack<>();
 * //    Stack stack = new LinkedStack();
 *
 * @Override protected Stack<Integer> createStack() {
 * Stack stack = new LinkedStack();
 * return stack ;
 * }
 * }
 */

