package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList<T> implements List<T>, Iterable {
    Node head;
    Node tail;
    int size;

    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        checkIndex(index, size + 1);
        Node newObj = new Node(value);
        if (size == 0) {
            head = tail = newObj;
        } else if (index == size) {
            tail.next = newObj;
            newObj.prev = tail;
            tail = newObj;
        } else if (index == 0) {
            head.prev = newObj;
            newObj.next = head;
            head = newObj;
        } else {
            Node previous = getNodeByIndex(index - 1);
            newObj.next = previous.next;
            previous.next = newObj;
        }
        size++;
    }

    private Node getNodeByIndex(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public T remove(int index) {
        checkIndex(index, size);
        Object result;
        if (index == 0) {
            result = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node prev = getNodeByIndex(index - 1);
            result = prev.next.value;
            prev.next = prev.next.next;
            if (index == size - 1) {
                tail = prev;
            }
        }
        size--;

        return (T) result;
    }

    @Override
    public T get(int index) {
        checkIndex(index, size);
        return (T) getNodeByIndex(index).value;
    }

    @Override
    public T set(T value, int index) {
        checkIndex(index, size);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Object result = current.value;
        current.value = value;
        return (T) result;
    }

    private void checkIndex(int index, int size) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Wrong index!");
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        Node current = head;
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(current.value, value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        Node current = tail;
        int i = size - 1;
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return i;
            }
            current = current.prev;
            i--;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        while (current != null) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }

        return stringJoiner.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return get(index++);
        }
    }
}
