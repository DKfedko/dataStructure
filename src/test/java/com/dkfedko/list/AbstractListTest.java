package com.dkfedko.list;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractListTest {
    protected abstract List<Integer> createList();

    List<Integer> list = createList();

        @Test
        void shouldCheckIfEmpty() {

            assertTrue(list.isEmpty());

            list.add(1);

            assertEquals(1, list.get(0));
        }

        @Test
        void shouldAddAndGetValue() {

            //arrange
            assertTrue(list.isEmpty());

            //act
            list.add(1);
            list.add(2);
            list.add(3);

            //assert
            assertEquals(3, list.size());
            assertEquals(1, list.get(0));
            assertEquals(2, list.get(1));
            assertEquals(3, list.get(2));
            assertFalse(list.isEmpty());

        }
        @Test
        void shouldAddElementByIndex() {

            //arrange
            assertTrue(list.isEmpty());
            assertFalse(list.contains(101));

            //act
            list.add(101, 0);
            list.add(102, 1);

            //assert
            assertEquals(101, list.get(0));
            assertEquals(102, list.get(1));
            assertEquals(2, list.size());

        }
        @Test
        void shouldCheckIfContains(){

            //arrange
           assertTrue(list.isEmpty());
           assertFalse(list.contains(5));

            //act
            list.add(8);
            list.add(10);
            list.add(100);

            //assert
            assertTrue(list.contains(8));
            assertTrue(list.contains(10));
            assertFalse(list.isEmpty());
        }

        @Test
        void shouldSetNewElements() {

            //arrange
            assertTrue(list.isEmpty());

            list.add(10);
            list.add(20);
            list.add(30);

            //act
            assertEquals(20, list.get(1));
            list.set(40, 1);

            //assert
            assertEquals(40, list.get(1));
            assertFalse(list.contains(20));
            assertEquals(3, list.size());

            //act
            list.set(50, 1);

            //assert
            assertEquals(50, list.get(1));
            assertEquals(3,list.size());

        }

        @Test
        void shouldClearList() {

            //arrange
            assertTrue(list.isEmpty());

            //act
            list.add(10);
            list.add(30);
            list.add(50);
            list.clear();

            //assert
            assertEquals(0, list.size());
            assertFalse(list.contains(50));

        }
        @Test
        void shouldGetIndexOfAndSetNewValue() {

            //arrange
            list.add(5);
            list.add(10);
            list.add(20);
            list.indexOf(10);

            //assert
            assertEquals(1, list.indexOf(10));

            //act
            list.set(20, 1);
            list.indexOf(20);

            //assert
            assertEquals(1, list.indexOf(20));
            list.clear();
            assertEquals(0, list.size());

        }

        @Test
        void shouldGetLastIndexOf() {

            //arrange
            list.add(1);
            list.add(2); // 2
            list.add(5);
            list.add(3);
            list.add(2);  //2
            list.add(2);  //2

            //act
            list.lastIndexOf(2);

            //assert
            assertEquals(5, list.lastIndexOf(2));
            assertEquals(6, list.size());

        }

        @Test
        void shouldRemoveElement(){

            //arrange
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);

            //act
            list.remove(0);
            list.remove(0);

            //arrange
            assertEquals(3, list.get(0));
        }

        @Test
        void shouldAddGetSetRemoveCheckIfContains(){

            //arrange
            assertTrue(list.isEmpty());
            list.add(5);
            list.add(10);
            list.add(15);
            assertTrue(list.contains(5));
            assertEquals(15, list.get(2));

            //act
            list.set(20, 2);
            assertEquals(20, list.get(2));

            list.remove(2);

            //assert
            assertEquals(2, list.size());
            assertFalse(list.contains(15));
            assertFalse(list.contains(20));
            assertEquals(2,list.size());

        }
        @Disabled
        @Test
        void shouldThrowExceptions(){

            assertThrows(IndexOutOfBoundsException.class, () -> {
                list.add(1, 1);
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                list.add(1, -1);
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                list.add(1, 101);
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
                list.set(1, 100);
            });
            assertThrows(IndexOutOfBoundsException.class, () -> {
                list.set(1, -1);
            });
        }
        @Test

        void testToString(){

            list.add(1, 0);
            list.add(2, 1);
            list.add(3, 2);
            list.add(4, 3);

            String arrayListString = list.toString();
            assertEquals("[1, 2, 3, 4]", arrayListString);

        }
        @Test
        void testArrayListGrowth() {
            ArrayList<Integer> newList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                newList.add(i);
                assertEquals(i+1, newList.size());
                assertEquals(Integer.valueOf(i), newList.get(i));
            }
        }
    }