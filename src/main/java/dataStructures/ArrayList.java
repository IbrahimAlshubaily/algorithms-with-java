package dataStructures;

import java.util.*;

public class ArrayList <T> implements List {
    private int length;
    private int capacity;
    private T[] data;
    public ArrayList() {
        this(32);
    }
    public ArrayList(int capacity) {
        length = 0;
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }
    @Override
    public boolean add(Object o) {
        insureCapacity();
        data[length++] = (T)o;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        int idx = indexOf(o);
        if (idx == -1)
            return false;

        shiftLeft(idx);
        length--;
        return true;
    }

    private void shiftLeft(int idx) {
        for (int i = length - 2; i >= idx; i--) {
            data[i] = data[i+1];
        }
    }

    private void shiftRight(int idx) {
        for (int i = length; i > idx; i--) {
            data[i] = data[i - 1];
        }
    }


    @Override
    public void add(int index, Object element) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        shiftRight(index);
        data[index] = (T) element;
        length++;
    }

    @Override
    public Object remove(int index) {
        if (isOutOfBounds(index)) {
            return null;
        }
        Object item = data[index];
        shiftLeft(index);
        length--;
        return item;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Object set(int index, Object element) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        Object out = data[index];
        data[index] = (T) element;
        return out;
    }

    @Override
    public Object get(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }
    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= length;

    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++){
            if (data[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    private void insureCapacity() {
        if (length < capacity - 1)
            return;
        capacity *= 2;
        T[] data = (T[]) new Object[capacity];
        for (int i = 0; i < size(); i++) {
            data[i] = this.data[i];
        }
        this.data = data;
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
}