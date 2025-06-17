package main;

import main.interfaces.Menge;

public class MengeDynArray<T> implements Menge<T> {

    /* Instanzvariablen */

    private DynArray<T> array;

    /* Konstruktoren */

    public MengeDynArray() {
        array = new DynArray<>();
    }

    /* Instanzmethoden */

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public T get() {
        return array.get(0);
    }

    @Override
    public void insert(T e) {
        if (contains(e)) return;
        array.add(e);
    }

    @Override
    public void delete(T e) {
        array.delete(e);
    }

    @Override
    public boolean contains(T e) {
        return array.contains(e);
    }

    @Override
    public String toString() {
        return "MengeDynArray{" +
                "array=" + array +
                '}';
    }
}
