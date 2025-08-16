package com.dkfedko.list;

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
    void shouldAddAndGetValue() {

        //arrange
        assertTrue(list.isEmpty());

        //act
        list.add("A");
        list.add("B");
        list.add("C");

        //assert
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertFalse(list.isEmpty());

    }
        @Test
        void shouldAddElementByIndex() {

            //arrange
            assertTrue(list.isEmpty());
            assertFalse(list.contains("Cat"));

            //act
            list.add("Cat", 0);
            list.add("Dog", 1);

            //assert
            assertEquals("Cat", list.get(0));
            assertEquals("Dog", list.get(1));
            assertEquals(2, list.size());

    }
    @Test

    void shouldCheckIfContains(){

        //arrange
        assertTrue(list.isEmpty());

        //act
        list.add("Cat");

        //assert
        assertTrue(list.contains("Cat"));
        assertFalse(list.contains("Dog"));

    }
//CHECK TEST with SET AND ADD TEST FOR GROW
    @Test
    void shouldSetNewElements() {

        //arrange
        assertTrue(list.isEmpty());

        list.add('A');
        list.add('B');
        list.add('C');

        //act
        list.set("Cat", 1);


        //assert
        assertEquals("Cat", list.get(1));
        assertEquals(3, list.size());

        //act
        list.set("B", 1);

        //assert
        assertEquals("B", list.get(1));
        assertEquals(3,list.size());

    }

    @Test
    void shouldClearList() {

        //arrange
        assertTrue(list.isEmpty());

        //act
        list.add("A");
        list.add("B");
        list.add("C");
        list.clear();

        //assert
        assertEquals(0, list.size());
        assertFalse(list.contains("A"));

    }
    @Test
    void shouldGetIndexOfAndSetNewValue() {

        //arrange
        list.add("A");
        list.add("B");
        list.add("C");
        list.indexOf("B");

        //assert
        assertEquals(1, list.indexOf("B"));

        //act
        list.set("Cat", 1);
        list.indexOf("Cat");

        //assert
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
        assertEquals(6, list.size());

    }

    @Test

    void shouldRemoveElement(){

        //arrange
        list.add(5);
        list.add("cat");
        list.add(3.14);
        list.add('L');

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

        //act
        list.set("Dog",2);
        assertEquals("Dog", list.get(2));

        list.remove(2);

        //assert
        assertEquals(2, list.size());
        assertFalse(list.contains("Cat"));
        assertFalse(list.contains("Dog"));
        assertEquals(2,list.size());

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
            list.add("Cat", 101);
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