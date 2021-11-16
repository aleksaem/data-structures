package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList<T> implements List<T>, Iterable {
    private int size;
    public static final int DEFAULT_CAPACITY = 10;
    private T[] array;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(T value) {
        ensureCapacity();

        add(value, size);
    }

    private void ensureCapacity() {
        if (array.length == size) {
            T[] newArray = (T[]) new Object[array.length * 3 / 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public void add(T value, int index) {
        ensureCapacity();
        if (index > size) {
            throw new IndexOutOfBoundsException("Wrong index!");
        }

        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = value;
        size++;
    }

    @Override
    public T remove(int index) {
        Object result;
        checkIndex(index);
        result = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;

        return (T) result;
    }

    @Override
    public T get(int index) {
        Object result = null;
        checkIndex(index);

        for (int i = 0; i < size; i++) {
            if (array[i].equals(array[index])) {
                result = array[index];
            }
        }
        return (T) result;
    }

    @Override
    public T set(T value, int index) {
        checkIndex(index);
        Object oldObject = array[index];

        array[index] = value;
        return (T) oldObject;
    }

    private void checkIndex(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Wrong index!");
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            Object valueInList = array[i];
            if ((valueInList == null && value == null) || valueInList.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add((CharSequence) array[i]);
        }
        return stringJoiner.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
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
