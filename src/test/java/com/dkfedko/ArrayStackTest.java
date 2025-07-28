package com.dkfedko;

import com.dkfedko.ArrayStack;
import com.dkfedko.Stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
            Object[] actual = (Object[]) stack.copyStack();

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
            Object[] actual = (Object[]) stack.reversCopy();

            //assert
            assertArrayEquals(expected, actual);
        }
    }