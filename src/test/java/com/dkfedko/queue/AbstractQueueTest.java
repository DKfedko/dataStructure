package com.dkfedko.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractQueueTest {
    protected abstract Queue<Integer> createQueue();

    Queue<Integer> arrayQueue = createQueue();

    @Test
    void shouldCheckIfEmpty() {

        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    void shouldEnqueue() {

        assertTrue(arrayQueue.isEmpty());

        arrayQueue.enqueue(2);

        assertEquals(1, arrayQueue.size());

        arrayQueue.enqueue(3);

        assertEquals(2, arrayQueue.size());
    }

    @Test
    void shouldCheckIfContains() {

        //assert
        assertTrue(arrayQueue.isEmpty());

        //act
        arrayQueue.enqueue(1);

        //assert
        assertEquals(1, arrayQueue.size());

        //act
        arrayQueue.enqueue(2);

        //assert
        assertEquals(2, arrayQueue.size());

        assertTrue(arrayQueue.contains(1));
        assertFalse(arrayQueue.contains(3));

    }

    @Test
    void shouldPeek() {

        assertTrue(arrayQueue.isEmpty());

        arrayQueue.enqueue(1);

        assertEquals(1, arrayQueue.size());

        arrayQueue.enqueue(2);

        assertEquals(2, arrayQueue.size());

        assertFalse(arrayQueue.contains(3));

        arrayQueue.peek();

        assertEquals(2, arrayQueue.size());

    }

    @Test
    void shouldGrow() {

        assertTrue(arrayQueue.isEmpty());

        arrayQueue.enqueue(10);

        assertEquals(1, arrayQueue.size());

        arrayQueue.enqueue(20);

        assertEquals(2, arrayQueue.size());

        assertFalse(arrayQueue.contains(15));

        arrayQueue.peek();

        assertEquals(2, arrayQueue.size());

        arrayQueue.enqueue(10);
        arrayQueue.enqueue(15);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(25);

    }
    @Test
    void shouldCheckTheSize () {

        assertEquals(0, arrayQueue.size());
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(15);
        assertEquals(2, arrayQueue.size());

    }

    @Test
    void shouldDequeue(){

        assertEquals(0, arrayQueue.size());
        arrayQueue.enqueue(11);
        arrayQueue.enqueue(12);
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

    @Test
    void testToString() {
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);

        String queueToString = arrayQueue.toString();
        assertEquals("[10, 20, 30, 40, 50]", queueToString);
    }
}

