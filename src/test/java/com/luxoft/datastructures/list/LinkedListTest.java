package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    @Test
    public void testAddAndRemoveWorksCorrectlyAndChangeSize() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");

        assertEquals(2, linkedList.size());
        assertEquals("A", linkedList.remove(0));
        assertEquals("B", linkedList.remove(0));
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testAddByIndexWorksCorrectly() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D", 1);

        assertEquals("[A, D, B, C]", linkedList.toString());

    }

    @Test
    public void testAddOverInitialCapacityWorksCorrectly() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");


        assertEquals(3, linkedList.size());

    }

    @Test
    public void testRemoveWorksCorrectly() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");


        assertEquals(4, linkedList.size());
        assertEquals("B", linkedList.remove(1));
        assertEquals("[A, C, D]", linkedList.toString());
        assertEquals(3, linkedList.size());
    }

    @Test
    public void testAddAndGetByIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");


        assertEquals(4, linkedList.size());
        assertEquals("B", linkedList.get(1));
        assertEquals("D", linkedList.get(3));
        assertEquals(4, linkedList.size());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        LinkedList linkedList = new LinkedList();

        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnListWithData() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");

        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnListAfterClear() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");

        linkedList.clear();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add(null);

        assertTrue(linkedList.contains(null));
        assertTrue(linkedList.contains("B"));
    }

    @Test
    public void testContainsReturnFalse() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");

        assertFalse(linkedList.contains("C"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyList() {
        LinkedList linkedList = new LinkedList();

        assertFalse(linkedList.contains("C"));
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenGetOnEmptyList() {
        LinkedList linkedList = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(3);
        });
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenGetWithWrongIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(2);
        });
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenRemoveWithWrongIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(2);
        });
    }

    @Test
    public void testIndexOf() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("B");
        linkedList.add("A");
        linkedList.add("C");
        linkedList.add("A");
        linkedList.add("D");

        assertEquals(1, linkedList.indexOf("A"));
        assertEquals(-1, linkedList.indexOf("E"));
    }

    @Test
    public void testLastIndexOf() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("B");
        linkedList.add("A");
        linkedList.add("C");
        linkedList.add("A");
        linkedList.add("D");

        assertEquals(3, linkedList.lastIndexOf("A"));
        assertEquals(-1, linkedList.lastIndexOf("E"));
    }
}
