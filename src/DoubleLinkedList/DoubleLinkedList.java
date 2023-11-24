package DoubleLinkedList;

import java.util.Iterator;

public class DoubleLinkedList<T> implements MyList<T> {
    protected Node<T> head;
    protected Node<T> tail;
    protected int size;

    public DoubleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T element){
        Node<T> newNode = new Node<>(element);

        if(size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }

        tail = newNode;
        size++;
    }

    protected boolean ifIndexIllegal(int index){
        return index < 0 || index >= size;
    }

    public T get(int index){
        if (ifIndexIllegal(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public T getFromTail(int index){
        if (ifIndexIllegal(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = tail;
        for (int i = 0; i < size-index-1; i++) {
            current = current.prev;
        }
        return current.data;
    }

    public void addBefore(int index, T value){
        if (ifIndexIllegal(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<>(value);
        size++;
        if(index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
    }

    public void remove(int index){
        if (ifIndexIllegal(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if(current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if(current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        size--;
    }

    public int getSize(){
        return size;
    }


    protected static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data){
            this.data = data;
            prev = null;
            next = null;
        }
    }

    public Iterator<T> iterator(){
        return new Iterator<T>() {
            private Node<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.data;
                current = current.next;
                return value;
            }
        };
    }
}
