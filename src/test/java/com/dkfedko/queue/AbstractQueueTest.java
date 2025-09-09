package com.dkfedko.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractQueueTest {
    protected abstract Queue<Integer> createQueue();

    Queue<Integer> queue = createQueue();

    @Test
    void shouldCheckIfEmpty() {

        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldEnqueue() {

        assertTrue(queue.isEmpty());

        queue.enqueue(2);

        assertEquals(1, queue.size());

        queue.enqueue(3);

        assertEquals(2, queue.size());
    }

    @Test
    void shouldCheckIfContains() {

        //assert
        assertTrue(queue.isEmpty());

        //act
        queue.enqueue(1);

        //assert
        assertEquals(1, queue.size());

        //act
        queue.enqueue(2);

        //assert
        assertEquals(2, queue.size());

        assertTrue(queue.contains(1));
        assertFalse(queue.contains(3));

    }

    @Test
    void shouldPeek() {

        assertTrue(queue.isEmpty());

        queue.enqueue(1);

        assertEquals(1, queue.size());

        queue.enqueue(2);

        assertEquals(2, queue.size());

        assertFalse(queue.contains(3));

        queue.peek();

        assertEquals(2, queue.size());

    }

    @Test
    void shouldGrow() {

        assertTrue(queue.isEmpty());

        queue.enqueue(10);

        assertEquals(1, queue.size());

        queue.enqueue(20);

        assertEquals(2, queue.size());

        assertFalse(queue.contains(15));

        queue.peek();

        assertEquals(2, queue.size());

        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(25);

    }
    @Test
    void shouldCheckTheSize () {

        assertEquals(0, queue.size());
        queue.enqueue(10);
        queue.enqueue(15);
        assertEquals(2, queue.size());

    }

    @Test
    void shouldDequeue(){

        assertEquals(0, queue.size());
        queue.enqueue(11);
        queue.enqueue(12);
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldTrowExceptions(){

        assertThrows(IllegalStateException.class, () -> {
            queue.peek();
        });

        assertThrows(IllegalStateException.class, () -> {
            queue.dequeue();
        });

        assertThrows(IllegalStateException.class, () -> {
            queue.contains(0);
        });
    }

    @Test
    void testToString() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        String queueToString = queue.toString();
        assertEquals("[10, 20, 30, 40, 50]", queueToString);
    }
}

