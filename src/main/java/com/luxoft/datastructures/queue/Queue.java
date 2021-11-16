package com.luxoft.datastructures.queue;

public interface Queue <T> {
    void enqueue(T value);

    T dequeue();

    T peek();

    int size();

    boolean isEmpty();

    boolean contains(T value);

    void clear();

    String toString();
}
