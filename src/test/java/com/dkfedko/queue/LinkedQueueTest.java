package com.dkfedko.queue;

import com.dkfedko.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedQueueTest extends BaseTest {

    private LinkedQueue<Integer> currentNode = new LinkedQueue<>();

    @Override
    @Test
    public void shouldCheckIfEmptyAddAndRemoveValue(){

    //arrange
    assertTrue(currentNode.isEmpty());

    //act
    currentNode.enqueue(1);
    currentNode.enqueue(2);
    currentNode.dequeue();

    //assert
    assertEquals(1, currentNode.size());

    }
    @Override
    @Test
    public void shouldAddAndPeek () {
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
    @Override
    @Test
    public void shouldCheckIfContainsAndClean(){

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
        currentNode.clean();
        assertTrue(currentNode.isEmpty());
    }
    @Override
    @Test
    public void shouldThrowExceptions(){

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