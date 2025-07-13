package main.adt;

import main.adt.interfaces.Stapel;
import main.lists.EVL;

import java.util.NoSuchElementException;

public class StapelEVL<T> implements Stapel<T> {

    private EVL<T> evl;

    private int size;

    public StapelEVL() {
        evl = new EVL<>();
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T top() {
        if(isEmpty()) throw new NoSuchElementException("Stapel leer");
        return evl.get();
    }

    @Override
    public void push(T v) {
        evl.insert(v);
        size++;
    }

    @Override
    public void pop() {
        if(isEmpty()) throw new NoSuchElementException("Stapel leer");
        evl.remove();
        size--;
    }
}
