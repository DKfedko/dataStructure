package com.dkfedko;
import com.dkfedko.list.List;
import com.dkfedko.stack.LinkedStack;
import com.dkfedko.stack.Stack;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractBaseTest<T> {
    protected abstract LinkedStack<Integer> createList();
    Stack stack = new LinkedStack();
    //LinkedStack stack = new LinkedStack();
    @Test
    public void shouldCheckIfEmptyAddAndRemoveValue(){
        LinkedStack<Integer> list = createList();

        //arrange
        assertTrue(list.isEmpty());

        //act
        list.push(1);
        list.push(2);

        //assert
        assertEquals(2, list.size());
        list.pop();
        assertEquals(1, list.size());
        assertEquals(1, list.size());
    }
    @Test
    public void shouldAddAndPeek(){

        //arrange
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        //act
        list.push(1);
        list.push(2);
        list.push(4);

        //assert
        assertEquals(4, list.peek());
        list.pop();
        assertEquals(2, list.size());
        assertFalse(list.isEmpty());

    }

    @Test
    public void shouldCheckIfContainsAndClean(){

        List<T> list = createList();

        //arrange
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        //act
        list.push(1);
        list.push(2);
        list.push(4);

        //assert
        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
        assertFalse(list.contains(3));
        assertTrue(list.contains(4));
        list.clean();
        assertTrue(list.isEmpty());

    }

    @Test
    public void shouldThrowExceptions() {

        List<T> list = createList();

        assertThrows(IllegalStateException.class, () -> {
            list.peek();
        });

        assertThrows(IllegalStateException.class, () -> {
            list.contains(0);
        });

        assertThrows(IllegalStateException.class, () -> {
            list.pop();
        });
    }

}
