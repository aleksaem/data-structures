package com.luxoft.datastructures.list;

import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList implements List{
    Node head;
    Node tail;
    int size;

    @Override
    public void add(Object value) {
        Node newObj = new Node(value);

        if(isEmpty()){
            head = tail = newObj;
        } else{
            tail.next = newObj;
            newObj.prev = tail;
            tail = newObj;
        }
        size++;
    }

    @Override
    public void add(Object value, int index) {
        checkIndex(index, size + 1);
        Node newObj = new Node(value);
        if(size == 0){
            head = tail = newObj;
        } else if(index == size){
            tail.next = newObj;
            newObj.prev = tail;
            tail = newObj;
        } else if(index == 0){
            head.prev = newObj;
            newObj.next = head;
            head = newObj;
        } else{
            Node previous = getNodeByIndex(index-1);
            newObj.next = previous.next;
            previous.next = newObj;
        }
        size++;
    }

    private Node getNodeByIndex(int index){
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index, size);
        Object result;
       if(index == 0){
           result = head.value;
           head = head.next;
           if(head == null){
               tail = null;
           }
       } else{
           Node prev = getNodeByIndex(index - 1);
           result = prev.next.value;
           prev.next = prev.next.next;
           if(index == size-1){
               tail = prev;
           }
       }
        size--;

        return result;
    }

    @Override
    public Object get(int index) {
        checkIndex(index, size);
        return getNodeByIndex(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        checkIndex(index, size);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Object result = current.value;
        current.value = value;
        return result;
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
    public boolean contains(Object value) {
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
    public int indexOf(Object value) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if(Objects.equals(current.value, value)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node current = tail;
        int i = size - 1;
        while(current != null) {
            if(Objects.equals(current.value, value)){
                return i;
            }
            current = current.prev;
            i--;
        }
        return -1;
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
