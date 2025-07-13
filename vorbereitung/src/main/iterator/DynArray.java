package main.iterator;

import java.util.Arrays;
import java.util.Iterator;


public class DynArray<T> implements Iterable<T> {

    /* Klassenvariablen */

    private static int startgroesse = 2;

    /* Instanzvariablen */

    private T[] array;
    private int size;

    /* Konstruktoren */

    @SuppressWarnings("unchecked")
    public DynArray() {
        this.array = (T[]) new Object[startgroesse];
        this.size = 0;
    }

    /* Instanzmethoden */

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int pos) {
        if (pos < 0 || pos > size) throw new IndexOutOfBoundsException();
        return array[pos];
    }

    public void set(int pos, T v) {
        if (pos < 0 || pos >= size) throw new IndexOutOfBoundsException();
        array[pos] = v;
    }

    public void add(T v) {
        if (size >= array.length) increase();
        array[size++] = v;
    }

    public void insert(int pos, T e) {
        if (size >= array.length) increase();

        for(int i = (size - 1); i >= pos; i--) {
            array[i + 1] = array[i];
        }
        size++;
        array[pos] = e;
    }

    @SuppressWarnings("unchecked")
    private void increase() {
        T[] neu = (T[]) new Object[2 * array.length];
        for (int i = 0; i < array.length; i++)
            neu[i] = array[i];
        this.array = neu;
    }

    public void remove(int pos) {
        if (pos < 0 || pos >= size) return;
        for (int i = pos; i < size - 1; i++)
            array[i] = array[i + 1];
        size--;
        if (size <= array.length / 4 && array.length / 2 >= startgroesse) decrease();
    }

    public void remove() {
        remove(0);
    }

    public void delete(T v) {
        remove(pos(v));
    }

    public boolean contains(T v) {
        return pos(v) != -1;
    }

    @Override
    public String toString() {
        return "DynArray{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new DynArrayIterator();
    }

    private int pos(T v) {
        for (int i = 0; i < size; i++)
            if (array[i].equals(v)) return i;
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void decrease() {
        T[] neu = (T[]) new Object[array.length / 2];
        for (int i = 0; i < size; i++)
            neu[i] = array[i];
        array = neu;
    }

    /* Innere Klassen */

    public class DynArrayIterator implements Iterator<T> {

        /* Instanzvariablen */

        private int i;

        /* Instanzmethoden */

        @Override
        public boolean hasNext() {
            return i < size();
        }

        @Override
        public T next() {
            return get(i++);
        }
    }
}
