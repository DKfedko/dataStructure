package com.dkfedko.queue;

import com.dkfedko.stack.AbstractStackTest;

public class LinkedQueueTest extends AbstractQueueTest {
    @Override
    protected Queue<Integer> createQueue(){
        return new LinkedQueue<>();
    }
}