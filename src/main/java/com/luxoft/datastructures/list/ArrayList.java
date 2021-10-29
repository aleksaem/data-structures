package com.luxoft.datastructures.list;

public class ArrayList implements List {
    private int size;
    private Object[] array;

    public ArrayList() {
        array = new Object[10];
    }

    public ArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    @Override
    public void add(Object value) {
        ensureCapacity();

        array[size] = value;
        size++;
    }

    private void ensureCapacity() {
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 3 / 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public void add(Object value, int index) {
        ensureCapacity();
        if (index > size) {
            throw new IndexOutOfBoundsException("Wrong index!");
        }

        for (int i = size + 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        Object result;
        checkIndex(index);
        result = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;

        return result;
    }

    @Override
    public Object get(int index) {
        Object result = null;
        checkIndex(index);

        for (int i = 0; i < size; i++) {
            if (array[i].equals(array[index])) {
                result = array[index];
            }
        }
        return result;
    }

    @Override
    public Object set(Object value, int index) {
        checkIndex(index);
        Object oldObject = array[index];

        array[index] = value;
        return oldObject;
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
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            Object valueInList = array[i];
            if ((valueInList == null && value == null) || valueInList.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += array[i];
            if (i < size - 1) {
                result += ", ";
            }
        }
        return "[" + result + "]";
    }
}
