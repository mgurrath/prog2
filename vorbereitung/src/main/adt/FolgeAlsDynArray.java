package main.adt;

import main.adt.interfaces.Folge;
import main.iterator.DynArray;

import java.util.Iterator;

public class FolgeAlsDynArray<T> implements Folge<T> {

    private DynArray<T> da;

    private int size;

    public FolgeAlsDynArray() {
        da = new DynArray<>();
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(T e) {
        return da.contains(e);
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        return da.get(pos);
    }

    @Override
    public void set(int pos, T e) throws IndexOutOfBoundsException {
        da.set(pos,e);
    }

    @Override
    public void insert(int pos, T e) throws IndexOutOfBoundsException {
        da.insert(pos, e);
        size++;
    }

    @Override
    public void remove(int pos) throws IndexOutOfBoundsException {
        da.remove(pos);
        size--;
    }

    @Override
    public void delete(T e) {
        da.delete(e);
        size--;
    }

    @Override
    public Iterator<T> iterator() {
        return new DynArrayIterator();
    }

    class DynArrayIterator implements Iterator<T> {

        private int i;

        public DynArrayIterator() {
            i = 0;
        }

        @Override
        public boolean hasNext() {
            return (i < size());
        }

        @Override
        public T next() {
            return get(i++);
        }
    }
}
