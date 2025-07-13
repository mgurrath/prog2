package main.comparator;

import main.adt.interfaces.Menge;
import main.iterator.DynArray;

import java.util.Iterator;


public class MengeDynArray<T> implements Menge<T> {

    /* Instanzvariablen */

    private DynArray<T> dynarr;

    /* Konstruktoren */

    public MengeDynArray() {
        dynarr = new DynArray<>();
    }

    /* Instanzmethoden */

    @Override
    public int size() {
        return dynarr.size();
    }

    @Override
    public boolean isEmpty() {
        return dynarr.isEmpty();
    }

    @Override
    public T get() {
        return dynarr.get(0);
    }

    @Override
    public void insert(T e) {
        if (contains(e)) return;
        dynarr.add(e);
    }

    @Override
    public void delete(T e) {
        dynarr.delete(e);
    }

    @Override
    public boolean contains(T e) {
        return dynarr.contains(e);
    }

    @Override
    public String toString() {
        return "MengeDynArray{" +
                "array=" + dynarr +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return dynarr.iterator();
    }
}
