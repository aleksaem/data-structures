package com.luxoft.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {
    @Test
    public void testEnqueueAndDequeueWorksCorrectlyAndChangeSize() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        assertEquals(2, linkedQueue.size());
        assertEquals("A", linkedQueue.dequeue());
        assertEquals("B", linkedQueue.dequeue());
        assertEquals(0, linkedQueue.size());
        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    public void testQueueIsEmpty() {
        LinkedQueue linkedQueue = new LinkedQueue();
        assertTrue(linkedQueue.isEmpty());
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");

        assertFalse(linkedQueue.isEmpty());
        assertEquals("A", linkedQueue.dequeue());
        assertEquals("B", linkedQueue.dequeue());
        assertEquals("C", linkedQueue.dequeue());
        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    public void testEnqueueAndPeek() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");


        assertEquals(2, linkedQueue.size());
        assertEquals("A", linkedQueue.peek());
        assertEquals("A", linkedQueue.peek());
        assertEquals(2, linkedQueue.size());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewQueue() {
        LinkedQueue linkedQueue = new LinkedQueue();

        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnQueueWithData() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");

        assertFalse(linkedQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        linkedQueue.clear();

        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        assertTrue(linkedQueue.contains("A"));
    }

    @Test
    public void testContainsReturnFalse() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        assertFalse(linkedQueue.contains("C"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyQueue() {
        LinkedQueue linkedQueue = new LinkedQueue();

        assertFalse(linkedQueue.contains("C"));
    }

    @Test
    public void testThrowIllegalStateExceptionWhenDequeOnEmptyQueue() {
        LinkedQueue linkedQueue = new LinkedQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedQueue.dequeue();
        });
    }

    @Test
    public void testConvertQueueArrayToString() {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");

        assertEquals("[A, B, C]", linkedQueue.toString());
    }
}
