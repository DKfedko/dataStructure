package com.dkfedko;

import com.dkfedko.list.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    private ArrayList arrayList = new ArrayList();

    @Test
    void shouldCheckIfEmpty() {

        assertTrue(arrayList.isEmpty());

    }

    @Test

    void shouldCheckIfContains(){

        assertTrue(arrayList.isEmpty());

        arrayList.add("Cat");
        assertFalse(arrayList.contains("Cat"));
        assertFalse(arrayList.contains(1));

    }

    @Test
    void shouldAddValue() {

        //arrange
        assertTrue(arrayList.isEmpty());

        //act
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        //assert
        assertEquals(3, arrayList.size());

        assertTrue(arrayList.contains("A"));

    }

}