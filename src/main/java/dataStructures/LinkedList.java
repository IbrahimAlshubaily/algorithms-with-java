package dataStructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements List {

    private int length;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        length = 0;
        head = tail = null;
    }

    @Override
    public boolean add(Object o) {
        length++;
        Node<T> newNode = new Node<T>((T) o);
        if (head == null) {
            head = tail = newNode;
            return true;
        }
        tail.next = newNode;
        this.tail = newNode;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (length == 0)
            return false;

        boolean isRemoved = false;
        if (head.value.equals(o)) {
            if (head.equals(tail)) {
                head = tail = null;
            } else {
                head = head.next;
            }
            isRemoved = true;

        } else {

            Node<T> node = getPrevNode(o);
            if (node != null) {
                node.next = node.next.next;
                isRemoved = true;
            }
        }

        if(isRemoved)
            length--;

        return isRemoved;
    }


    private Node<T> getPrevNode(Object o) {
        Node<T> curr = head;
        while(curr != null && curr.next != null) {
            if(curr.next.value.equals(o))
                return curr;
            curr = curr.next;
        }
        return null;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> curr = head;
        while(curr != null) {
            if (curr.value.equals(o))
                return true;
            curr = curr.next;
        }
        return false;
    }

    @Override
    public void add(int index, Object element) {
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}
