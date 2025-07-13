package main.adt;

import main.adt.interfaces.Schlange;
import main.iterator.DynArray;

import java.util.NoSuchElementException;

public class SchlangeAlsArray<T> implements Schlange<T> {

    private DynArray<T> da;

    private int size;

    public SchlangeAlsArray() {
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
    public T front() {
        if(isEmpty()) throw new NoSuchElementException("Schlange leer");
        return da.get(0);
    }

    @Override
    public void enqueue(T e) {
        da.insert(size,e);
        size++;
    }

    @Override
    public void dequeue() {
        if(isEmpty()) throw new NoSuchElementException("Schlange leer");
        da.remove();
        size--;
    }
}
