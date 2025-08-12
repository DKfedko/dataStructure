package com.dkfedko;

import com.dkfedko.list.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    private ArrayList arrayList = new ArrayList();
    private ArrayList list = new ArrayList(100);

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
        void shouldAddElementByIndex() {

            assertTrue(list.isEmpty());
            assertFalse(list.contains("Cat"));

            assertThrows(IndexOutOfBoundsException.class, () -> {
                list.add("Cat", 1);
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                list.add("Dog", -1);
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                list.add("Dog", 100);
            });

            list.add("Cat", 0);
            list.add("Dog", 1);
            assertEquals("Cat", list.get(0));

    }
    @Test

    void shouldCheckIfContains(){

        assertTrue(arrayList.isEmpty());

        arrayList.add("Cat");

        assertTrue(arrayList.contains("Cat"));

        assertFalse(arrayList.contains("Dog"));

    }

    @Test
    void shouldGetValue(){

        assertTrue(arrayList.isEmpty());

        arrayList.add('A');
        arrayList.add('B');
        arrayList.add('C');

        assertEquals('A', arrayList.get(0));
        assertEquals('B', arrayList.get(1));
        assertEquals('C', arrayList.get(2));

        assertFalse(arrayList.isEmpty());


    }

    @Test
    void shouldSetNewElements() {
        assertTrue(arrayList.isEmpty());

        arrayList.add('A');
        arrayList.add('B');
        arrayList.add('C');

        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("cat", 3);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("Cat", -1);
        });

        arrayList.set("Cat", 1);

        assertEquals("Cat", arrayList.get(1));

        arrayList.set("B", 1);

        assertEquals("B", arrayList.get(1));

    }

    @Test
    void shouldClearList() {
        assertTrue(arrayList.isEmpty());

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        arrayList.clear();
        assertEquals(0, arrayList.size());
        assertFalse(arrayList.contains("A"));

    }
    @Test
    void shouldGetIndexOf() {

        //arrange
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(13);
        });

        arrayList.indexOf("B");

        assertEquals(1, arrayList.indexOf("B"));

        arrayList.set("Cat", 1);
        arrayList.indexOf("Cat");

        assertEquals(1, arrayList.indexOf("Cat"));

        arrayList.clear();
        assertEquals(0, arrayList.size());

    }

    @Test
    void shouldGetLastIndexOf() {

        //arrange
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("B");
        arrayList.add("B");

        //act
        arrayList.lastIndexOf("B");

        //assert
        assertEquals(5, arrayList.lastIndexOf("B"));

    }

    @Test

    void shouldRemoveElement(){

        //arrange
        arrayList.add(5);
        arrayList.add("cat");
        arrayList.add(3.14);
        arrayList.add('L');

        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(-1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(5);
        });

        //act
        arrayList.remove(0);
        arrayList.remove(0);

        //arrange
        assertEquals(3.14, arrayList.get(0));
    }
    @Test

    void shouldAddGetSetRemoveCheckIfContains(){

        //arrange
        arrayList.add(1);
        arrayList.add("B");
        arrayList.add("Cat");

        assertEquals("Cat", arrayList.get(2));

        arrayList.set("Dog",2);
        arrayList.remove(2);
        assertFalse(arrayList.contains("Cat"));
        assertTrue(arrayList.contains("Dog"));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(3);
        });

    }
    @Test
    void shouldThrowExceptions(){

        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("Cat", 1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("Cat", -1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(-1);
        });
    }

    @Test

    void testToString(){

        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C", 2);
        arrayList.add("D", 3);

        String arrayListString = arrayList.toString();
        assertEquals("[A, B, C, D, ]", arrayListString);


    }

}