package main.adt;

import main.adt.interfaces.Menge;
import main.lists.EVL;

import java.util.Iterator;
import java.util.List;

public class MengeEVL<T> implements Menge<T> {

    private EVL<T> evl;

    private int size;

    public MengeEVL() {
        evl = new EVL<>();
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
    public T get() {
        return evl.get();
    }

    public T get(int pos) {return evl.get(pos);}

    @Override
    public void insert(T e) {
        if(evl.contains(e)) return;
        evl.insert(e);
        size++;
    }

    @Override
    public void delete(T e) {
        if(!evl.contains(e)) return;
        evl.delete(e);
        size--;
    }

    @Override
    public boolean contains(T e) {
        return evl.contains(e);
    }

    @Override
    public Iterator<T> iterator() {
        return new MengeIterator();
    }

    class MengeIterator<T> implements Iterator<T>{

        private int index;

        public MengeIterator() {
            index = 0;
        }

        public boolean hasNext() {
            return index < size;
        }

        public T next() {
            return (T) get(index++);
        }

    }
}
