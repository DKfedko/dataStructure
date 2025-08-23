package com.dkfedko.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedQueueTest {

    private LinkedQueue<Integer> currentNode = new LinkedQueue<>();

    @Test
    void shouldCheckIfEmptyEnqueueAndDequeue (){

    //arrange
    assertTrue(currentNode.isEmpty());

    //act
    currentNode.enqueue(1);
    currentNode.enqueue(2);
    currentNode.dequeue();

    //assert
    assertEquals(1, currentNode.size());

    }
    @Test
    void shouldPeekAndDequeue () {
        //arrange
        assertTrue(currentNode.isEmpty());

        //act
        currentNode.enqueue(1);
        currentNode.enqueue(2);
        currentNode.peek();

        //assert
        assertEquals(2, currentNode.size());
        currentNode.dequeue();
        assertEquals(1, currentNode.size());

    }
    @Test
    void shouldCheckIfContains(){

        //arrange
        assertTrue(currentNode.isEmpty());
        assertEquals(0, currentNode.size());

        //act
        currentNode.enqueue(1);
        currentNode.enqueue(2);
        currentNode.enqueue(3);

        //assert
        assertEquals(3, currentNode.size());
        assertTrue(currentNode.contains(3));
        assertFalse(currentNode.contains(4));
    }

    @Test
    void shouldThrowExceptions(){

        assertThrows(IllegalStateException.class, () -> {
            currentNode.peek();
        });

        assertThrows(IllegalStateException.class, () -> {
            currentNode.contains(0);
        });

        assertThrows(IllegalStateException.class, () -> {
            currentNode.dequeue();
        });

    }
}