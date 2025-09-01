package com.dkfedko.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractListTest {
    protected abstract List<Integer> createList();

    List<Integer> list1 = createList();

        @Test
        void shouldCheckIfEmpty() {

            assertTrue(list1.isEmpty());

            list1.add(1);

            assertEquals(1, list1.get(0));
        }

        @Test
        void shouldAddAndGetValue() {

            //arrange
            assertTrue(list1.isEmpty());

            //act
            list1.add(1);
            list1.add(2);
            list1.add(3);

            //assert
            assertEquals(3, list1.size());
            assertEquals(1, list1.get(0));
            assertEquals(2, list1.get(1));
            assertEquals(3, list1.get(2));
            assertFalse(list1.isEmpty());

        }
        @Test
        void shouldAddElementByIndex() {

            //arrange
            assertTrue(list1.isEmpty());
            assertFalse(list1.contains(101));

            //act
            list1.add(101, 0);
            list1.add(102, 1);

            //assert
            assertEquals(101, list1.get(0));
            assertEquals(102, list1.get(1));
            assertEquals(2, list1.size());

        }
        @Test

        void shouldCheckIfContains(){

            //arrange
            assertTrue(list1.isEmpty());

            //act
            list1.add(5);

            //assert
            assertTrue(list1.contains(5));
            assertFalse(list1.contains(10));

        }
        //CHECK TEST with SET AND ADD TEST FOR GROW
        @Test
        void shouldSetNewElements() {

            //arrange
            assertTrue(list1.isEmpty());

            list1.add(10);
            list1.add(20);
            list1.add(30);

            //act
            assertEquals(20, list1.get(1));
            list1.set(40, 1);

            //assert
            assertEquals(40, list1.get(1));
            assertFalse(list1.contains(20));
            assertEquals(3, list1.size());

            //act
            list1.set(20, 1);

            //assert
            assertEquals(20, list1.get(1));
            assertEquals(3,list1.size());

        }

        @Test
        void shouldClearList() {

            //arrange
            assertTrue(list1.isEmpty());

            //act
            list1.add(10);
            list1.add(30);
            list1.add(50);
            list1.clear();

            //assert
            assertEquals(0, list1.size());
            assertFalse(list1.contains(50));

        }
        @Test
        void shouldGetIndexOfAndSetNewValue() {

            //arrange
            list1.add(5);
            list1.add(10);
            list1.add(20);
            list1.indexOf(10);

            //assert
            assertEquals(1, list1.indexOf(10));

            //act
            list1.set(20, 1);
            list1.indexOf(20);

            //assert
            assertEquals(1, list1.indexOf(20));
            list1.clear();
            assertEquals(0, list1.size());

        }

        @Test
        void shouldGetLastIndexOf() {

            //arrange
            list1.add(1);
            list1.add(2); // 2
            list1.add(5);
            list1.add(3);
            list1.add(2);  //2
            list1.add(2);  //2

            //act
            list1.lastIndexOf(2);

            //assert
            assertEquals(5, list1.lastIndexOf(2));
            assertEquals(6, list1.size());

        }

        @Test
        void shouldRemoveElement(){

            //arrange
            list1.add(1);
            list1.add(2);
            list1.add(3);
            list1.add(4);

            //act
            list1.remove(0);
            list1.remove(0);

            //arrange
            assertEquals(3, list1.get(0));
        }

        @Test
        void shouldAddGetSetRemoveCheckIfContains(){

            //arrange
            list1.add(5);
            list1.add(10);
            list1.add(15);

            assertEquals(15, list1.get(2));

            //act
            list1.set(20,2);
            assertEquals(20, list1.get(2));

            list1.remove(2);

            //assert
            assertEquals(2, list1.size());
            assertFalse(list1.contains(15));
            assertFalse(list1.contains(20));
            assertEquals(2,list1.size());

        }
        @Test
        void shouldThrowExceptions(){

            assertThrows(IndexOutOfBoundsException.class, () -> {
                list1.add(1, 1);
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                list1.add(1, -1);
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                list1.add(1, 101);
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                list1.get(-1);
            });
            assertThrows(IndexOutOfBoundsException.class, () -> {
                list1.get(100);
            });

            assertThrows(IndexOutOfBoundsException.class, () -> {
                list1.remove(100);
            });
            assertThrows(IndexOutOfBoundsException.class, () -> {
                list1.remove(-1);
            });
            assertThrows(IndexOutOfBoundsException.class, () -> {
                list1.set(1, 100);
            });
            assertThrows(IndexOutOfBoundsException.class, () -> {
                list1.set(1, -1);
            });
        }
        @Test

        void testToString(){

            list1.add(1, 0);
            list1.add(2, 1);
            list1.add(3, 2);
            list1.add(4, 3);

            String arrayListString = list1.toString();
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