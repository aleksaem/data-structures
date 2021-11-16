package com.luxoft.datastructures.queue;

import java.util.Objects;
import java.util.StringJoiner;

public class LinkedQueue<T> implements Queue<T>{
    private Node head;
    private int size;

    @Override
    public void enqueue(T value) {
        Node newObj = new Node(value);

        if(isEmpty()){
            head = newObj;
        } else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newObj;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        Object result = head.value;
        head = head.next;
        size--;
        return (T) result;
    }

    @Override
    public T peek() {
        Object result = head.value;
        return (T) result;
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
        while(current != null){
            if(Objects.equals(current.value, value)){
                return true;
            }

            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
       head = null;
       size = 0;
    }

    @Override
    public String toString(){
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        while(current != null){
            stringJoiner.add(current.value.toString());
            current = current.next;
        }

        return stringJoiner.toString();
    }
}
