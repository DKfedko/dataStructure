package com.dkfedko;

import com.dkfedko.stack.ArrayStack;
import com.dkfedko.stack.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayStackTest {
    private ArrayStack stack = new ArrayStack();

    @Test
    void shouldPushValue() {

        //arrange
        stack.push("cat");

        //act and assert
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

        //act and assert
        assertEquals(2, stack.size());
    }

    @Test
    void shouldRemoveTopValue() {

        //arrange
        stack.push("cat");
        stack.push(2);
        stack.push(14.32);

        //act and assert
        assertEquals(3, stack.size());
        stack.removeTopValue();
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
        stack.clean();
        assertTrue(stack.isEmpty());

    }

    @Test
    void shouldGrow() {

        //arrange

        Object[] stack = new Stack[2];

        this.stack.push("cat");
        this.stack.push(2);
        this.stack.push(14.32);
        this.stack.push('c');
        this.stack.push("horse");

        //act and assert
        assertEquals(5, this.stack.size());

    }

    @Test
    void checkIfContains() {

        //arrange

        stack.push("cat");
        stack.push(2);
        stack.push(2);

        //assert
        assertFalse(stack.contains(3));
    }

    @Test
    void shouldReversCleanPushAndCheckIfContains() {

        //arrange

        stack.push(1);
        stack.push('b');
        stack.push(3.56);
        stack.push("hors");

        //act
        assertEquals(4, stack.size());
        stack.clean();
        assertEquals(0, stack.size());
        stack.push(4);
        assertEquals(1, stack.size());
        assertFalse(stack.contains(1));
    }
    @Test
    void shouldThrowExceptionWhenEmpty(){

        assertThrows(IllegalStateException.class, () -> {
            stack.pop();
        });

        assertThrows(IllegalStateException.class, () -> {
            stack.peek();
        });

        assertThrows(IllegalStateException.class, () -> {
            stack.removeTopValue();
        });

    }
}
