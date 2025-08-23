package com.dkfedko.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {
    private LinkedStack<Integer> lStack = new LinkedStack<>();

    @Test
    void shouldCheckIfEmptyPushAndPop() {

    //arrange
    assertTrue(lStack.isEmpty());

    //act
    lStack.push(1);
    lStack.push(2);

    //assert
    assertEquals(2, lStack.size());
    lStack.pop();
    assertEquals(1, lStack.size());

    }

    @Test
    void shouldPushAndPeek(){

        //arrange
        assertTrue(lStack.isEmpty());
        assertEquals(0, lStack.size());

        //act
        lStack.push(1);
        lStack.push(2);
        lStack.push(4);

        //assert
        assertEquals(4, lStack.peek());
        lStack.pop();
        assertEquals(2, lStack.size());
        assertFalse(lStack.isEmpty());

    }
    @Test
    void shouldCheckIfContainsAndClean(){
        //arrange
        assertTrue(lStack.isEmpty());
        assertEquals(0, lStack.size());

        //act
        lStack.push(1);
        lStack.push(2);
        lStack.push(4);

        //assert
        assertFalse(lStack.isEmpty());
        assertEquals(3, lStack.size());
        assertFalse(lStack.contains(3));
        assertTrue(lStack.contains(4));
        lStack.clean();
        assertTrue(lStack.isEmpty());

    }
@Test
        void shouldThrowExceptions() {
    assertThrows(IllegalStateException.class, () -> {
        lStack.peek();
    });

    assertThrows(IllegalStateException.class, () -> {
        lStack.contains(0);
    });

    assertThrows(IllegalStateException.class, () -> {
        lStack.pop();
    });

}
}

