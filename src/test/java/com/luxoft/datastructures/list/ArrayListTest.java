package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void testAddAndRemoveWorksCorrectlyAndChangeSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertEquals(2, arrayList.size());
        assertEquals("A", arrayList.remove(0));
        assertEquals("B", arrayList.remove(0));
        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testAddByIndexWorksCorrectly() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D", 1);

        assertEquals("[A, D, B, C]", arrayList.toString());

    }

    @Test
    public void testAddOverInitialCapacityWorksCorrectly() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");


        assertEquals(3, arrayList.size());

    }

    @Test
    public void testRemoveWorksCorrectly() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");


        assertEquals(4, arrayList.size());
        assertEquals("B", arrayList.remove(1));
        assertEquals("[A, C, D]", arrayList.toString());
        assertEquals(3, arrayList.size());
    }

    @Test
    public void testAddAndGetByIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");


        assertEquals(4, arrayList.size());
        assertEquals("B", arrayList.get(1));
        assertEquals("D", arrayList.get(3));
        assertEquals(4, arrayList.size());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        ArrayList arrayList = new ArrayList();

        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnListWithData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnListAfterClear() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add(null);

        assertTrue(arrayList.contains(null));
        assertTrue(arrayList.contains("B"));
    }

    @Test
    public void testContainsReturnFalse() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertFalse(arrayList.contains("C"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyList() {
        ArrayList arrayList = new ArrayList();

        assertFalse(arrayList.contains("C"));
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenGetOnEmptyList() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(3);
        });
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenGetWithWrongIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(2);
        });
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenRemoveWithWrongIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(2);
        });
    }

    @Test
    public void testIndexOf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");
        arrayList.add("A");
        arrayList.add("D");

        assertEquals(1, arrayList.indexOf("A"));
        assertEquals(-1, arrayList.indexOf("E"));
    }

    @Test
    public void testLastIndexOf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");
        arrayList.add("A");
        arrayList.add("D");

        assertEquals(3, arrayList.lastIndexOf("A"));
        assertEquals(-1, arrayList.lastIndexOf("E"));
    }
}
