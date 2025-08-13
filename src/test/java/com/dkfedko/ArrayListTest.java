package com.dkfedko;

import com.dkfedko.list.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    private ArrayList list = new ArrayList(100);

    @Test
    void shouldCheckIfEmpty() {

        assertTrue(list.isEmpty());

    }

    @Test
    void shouldAddValue() {

        //arrange
        assertTrue(list.isEmpty());

        //act
        list.add("A");
        list.add("B");
        list.add("C");

        //assert
        assertEquals(3, list.size());

    }
        @Test
        void shouldAddElementByIndex() {

            assertTrue(list.isEmpty());
            assertFalse(list.contains("Cat"));
            list.add("Cat", 0);
            list.add("Dog", 1);
            assertEquals("Cat", list.get(0));

    }
    @Test

    void shouldCheckIfContains(){

        assertTrue(list.isEmpty());

        list.add("Cat");

        assertTrue(list.contains("Cat"));

        assertFalse(list.contains("Dog"));

    }

    @Test
    void shouldGetValue(){

        assertTrue(list.isEmpty());

        list.add('A');
        list.add('B');
        list.add('C');

        assertEquals('A', list.get(0));
        assertEquals('B', list.get(1));
        assertEquals('C', list.get(2));

        assertFalse(list.isEmpty());

    }

    @Test
    void shouldSetNewElements() {
        assertTrue(list.isEmpty());

        list.add('A');
        list.add('B');
        list.add('C');

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("cat", 3);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("Cat", -1);
        });

        list.set("Cat", 1);

        assertEquals("Cat", list.get(1));

        list.set("B", 1);

        assertEquals("B", list.get(1));

    }

    @Test
    void shouldClearList() {
        assertTrue(list.isEmpty());

        list.add("A");
        list.add("B");
        list.add("C");

        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("A"));

    }
    @Test
    void shouldGetIndexOf() {

        //arrange
        list.add("A");
        list.add("B");
        list.add("C");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(13);
        });

        list.indexOf("B");

        assertEquals(1, list.indexOf("B"));

        list.set("Cat", 1);
        list.indexOf("Cat");

        assertEquals(1, list.indexOf("Cat"));

        list.clear();
        assertEquals(0, list.size());

    }

    @Test
    void shouldGetLastIndexOf() {

        //arrange
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("B");
        list.add("B");

        //act
        list.lastIndexOf("B");

        //assert
        assertEquals(5, list.lastIndexOf("B"));

    }

    @Test

    void shouldRemoveElement(){

        //arrange
        list.add(5);
        list.add("cat");
        list.add(3.14);
        list.add('L');

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(5);
        });

        //act
        list.remove(0);
        list.remove(0);

        //arrange
        assertEquals(3.14, list.get(0));
    }
    @Test

    void shouldAddGetSetRemoveCheckIfContains(){

        //arrange
        list.add(1);
        list.add("B");
        list.add("Cat");

        assertEquals("Cat", list.get(2));

        list.set("Dog",2);
        list.remove(2);
        assertFalse(list.contains("Cat"));
        assertTrue(list.contains("Dog"));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(3);
        });

    }
    @Test
    void shouldThrowExceptions(){

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("Cat", 1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("Cat", -1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("Cat", 100);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(100);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(100);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("cat", 100);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("cat", -1);
        });
    }
    @Test

    void testToString(){

        list.add("A", 0);
        list.add("B", 1);
        list.add("C", 2);
        list.add("D", 3);

        String arrayListString = list.toString();
        assertEquals("[A, B, C, D]", arrayListString);

    }

}