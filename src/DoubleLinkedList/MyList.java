package DoubleLinkedList;

import java.util.Iterator;

public interface MyList<T> {
    void add(T element);
    T get(int index);
    T getFromTail(int index);
    void addBefore(int index, T value);
    void remove(int index);
    int getSize();
    Iterator<T> iterator();
}
