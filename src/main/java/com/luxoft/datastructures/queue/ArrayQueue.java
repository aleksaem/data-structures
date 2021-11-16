package com.luxoft.datastructures.queue;

import java.util.StringJoiner;

public class ArrayQueue<T> implements Queue<T> {
    private int size;
    private int index;
    private T[] array;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void enqueue(T value) {
        ensureCapacity();

        array[size] = value;
        size++;
    }

    private void ensureCapacity() {
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = (T[]) newArray;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        Object result = array[index];
        index++;
        size--;
        return (T) result;
    }

    @Override
    public T peek() {
        return array[index];
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
        for (int i = 0; i < size; i++) {
            Object valueInQueue = array[i];
            if (value.equals(valueInQueue)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add((CharSequence) array[i]);
        }
        return stringJoiner.toString();
    }
}
