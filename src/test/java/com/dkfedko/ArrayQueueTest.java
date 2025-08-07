package com.dkfedko;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    private ArrayQueue arrayQueue = new ArrayQueue();

    @Test
    void shouldCheckIfEmpty() {

        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    void shouldEnqueue() {

        assertTrue(arrayQueue.isEmpty());

        arrayQueue.enqueue("A");

        assertEquals(1, arrayQueue.size());

        arrayQueue.enqueue("B");

        assertEquals(2, arrayQueue.size());
    }

    @Test
    void shouldCheckIfContains() {

        //arrange
        ArrayQueue[] array = new ArrayQueue[5];

        //assert
        assertTrue(arrayQueue.isEmpty());

        //act
        arrayQueue.enqueue("A");

        //assert
        assertEquals(1, arrayQueue.size());

        //act
        arrayQueue.enqueue("B");

        //assert
        assertEquals(2, arrayQueue.size());

        assertFalse(arrayQueue.contains(array));
    }

    @Test
    void shouldPeek() {

        ArrayQueue[] array = new ArrayQueue[5];

        assertTrue(arrayQueue.isEmpty());

        arrayQueue.enqueue("A");

        assertEquals(1, arrayQueue.size());

        arrayQueue.enqueue("B");

        assertEquals(2, arrayQueue.size());

        assertFalse(arrayQueue.contains(array));

        arrayQueue.peek();

        assertEquals(2, arrayQueue.size());

    }

    @Test
    void shouldGrow() {

        ArrayQueue[] array = new ArrayQueue[5];

        assertTrue(arrayQueue.isEmpty());

        arrayQueue.enqueue("A");

        assertEquals(1, arrayQueue.size());

        arrayQueue.enqueue("B");

        assertEquals(2, arrayQueue.size());

        assertFalse(arrayQueue.contains(array));

        arrayQueue.peek();

        assertEquals(2, arrayQueue.size());

        arrayQueue.enqueue("C");
        arrayQueue.enqueue("D");
        arrayQueue.enqueue("E");
        arrayQueue.enqueue("F");

        arrayQueue.grow();

        assertEquals(6, arrayQueue.size());

    }
    @Test
    void shouldCheckTheSize () {

        assertEquals(0, arrayQueue.size());
        arrayQueue.enqueue("C");
        arrayQueue.enqueue("D");
        assertEquals(2, arrayQueue.size());

    }

    @Test
    void shouldDequeue(){

        assertEquals(0, arrayQueue.size());
        arrayQueue.enqueue("C");
        arrayQueue.enqueue("D");
        assertEquals(2, arrayQueue.size());
        arrayQueue.dequeue();
        assertEquals(1, arrayQueue.size());
        arrayQueue.dequeue();
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());

    }

    @Test
    void shouldTrowExceptions(){

        assertThrows(IllegalStateException.class, () -> {
            arrayQueue.peek();
        });

        assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });

        assertThrows(IllegalStateException.class, () -> {
            arrayQueue.contains(0);
        });

    }
}
