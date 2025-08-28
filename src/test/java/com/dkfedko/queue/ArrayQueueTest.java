package com.dkfedko.queue;

public class ArrayQueueTest extends AbstractQueueTest{
    @Override
    protected Queue<Integer> createQueue() {
        return new ArrayQueue<>();
    }
}

