package main;

import main.interfaces.Menge;

public class MengeEVL<T> implements Menge<T> {

    private EVL<T> list;

    public MengeEVL () {
        list = new EVL<>();
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T get() {
        return list.getFirst();
    }

    @Override
    public void insert(T e) {
        list.insert(e);
    }

    @Override
    public void delete(T e) {
        list.delete(e);
    }

    @Override
    public boolean contains(T e) {
        return list.contains(e);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
