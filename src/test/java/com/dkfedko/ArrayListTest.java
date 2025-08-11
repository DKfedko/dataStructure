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
    void shouldAddValue() {

        //arrange
        assertTrue(arrayList.isEmpty());

        //act
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        //assert
        assertEquals(3, arrayList.size());

    }
    @Test

    void shouldCheckIfContains(){

        assertTrue(arrayList.isEmpty());

        arrayList.add("Cat");

        assertTrue(arrayList.contains("Cat"));

        assertFalse(arrayList.contains(1));

    }

    @Test
    void shouldGetValue(){

        assertTrue(arrayList.isEmpty());

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals("A", arrayList.get(0));
        assertEquals("B", arrayList.get(1));
        assertEquals("C", arrayList.get(2));

        assertFalse(arrayList.isEmpty());


    }

    @Test
    void shouldSetNewElements() {
        assertTrue(arrayList.isEmpty());

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        arrayList.set("Cat", 1);

        assertEquals("Cat", arrayList.get(1));

        arrayList.set("B", 1);

        assertEquals("B", arrayList.get(1));

    }
}