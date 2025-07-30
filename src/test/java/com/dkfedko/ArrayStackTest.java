package com.dkfedko;

import com.dkfedko.ArrayStack;
import com.dkfedko.Stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayStackTest {
    private ArrayStack stack = new ArrayStack();

    @Test
    void shouldCopyStack() {

        //arrange
        stack.push(1);
        stack.push('b');
        stack.push(3.56);
        stack.push("hors");
        Object[] expected = new Object[]{1, 'b', 3.56, "hors"};

        //act
        Object[] actual = (Object[]) stack.copyStack(expected);

        //assert
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldReversCopyStack() {

        //arrange
        stack.push(1);
        stack.push('b');
        stack.push(3.56);
        stack.push("hors");
        Object[] expected = new Object[]{"hors", 3.56, 'b', 1};

        //act
        Object[] actual = (Object[]) stack.reversCopy(expected);

        //assert
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPushValue() {

        //arrange
        stack.push("cat");
        assertEquals(1, stack.size());
    }

    @Test
    void shouldPushAndPopValue() {

        //arrange
        stack.push("cat");
        stack.push("dog");
        stack.pop();

        //act and assert
        assertEquals(1, stack.size());

    }

    @Test
    void shouldPushAndPeekValue() {

        //arrange
        stack.push("cat");
        stack.push("dog");
        stack.peek();

        //act and assert
        assertEquals(2, stack.size());

    }

    @Test
    void shouldPushPopAndPeekValue() {

        stack.push("cat");
        stack.push("dog");
        stack.push("hors");
        stack.pop();
        stack.peek();

        assertEquals(2, stack.size());
    }

    @Test
    void multitest() {

        stack.push("cat");
        stack.push(2);
        stack.push(14.32);

        assertEquals(3, stack.size());
        stack.remove();
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
        
    }
}
