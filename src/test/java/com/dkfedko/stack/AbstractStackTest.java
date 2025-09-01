package com.dkfedko.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStackTest {
    protected abstract Stack<Integer> createStack();

    Stack<Integer> stack = createStack();

    @Test
    public void shouldCheckIfEmptyAddAndRemoveValue() {

        //arrange
        assertTrue(stack.isEmpty());

        //act
        stack.push(1);
        stack.push(2);

        //assert
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        assertEquals(1, stack.size());
    }

    @Test
    public void shouldAddAndPeek() {

        //arrange
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        //act
        stack.push(1);
        stack.push(2);
        stack.push(4);

        //assert
        assertEquals(4, stack.peek());
        stack.pop();
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());

    }

    @Test
    public void shouldCheckIfContainsAndClean() {


        //arrange
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        //act
        stack.push(1);
        stack.push(2);
        stack.push(4);

        //assert
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        assertFalse(stack.contains(3));
        assertTrue(stack.contains(4));
        stack.clean();
        assertTrue(stack.isEmpty());

    }

    @Test
    public void shouldThrowExceptions() {
        assertThrows(IllegalStateException.class, () -> {
            stack.peek();
        });

        assertThrows(IllegalStateException.class, () -> {
            stack.contains(0);
        });

        assertThrows(IllegalStateException.class, () -> {
            stack.pop();
        });
    }

}
