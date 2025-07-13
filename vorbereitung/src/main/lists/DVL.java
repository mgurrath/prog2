package main.lists;

import java.util.NoSuchElementException;


public class DVL<T> {

    /* Instanzvariablen */

    private ListenElem first;
    private ListenElem last;
    private int size;

    /* Instanzmethoden */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T v) {
        return getElem(v) != null;
    }

    public T get(int pos) {
        return getElem(pos).value;
    }

    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.value;
    }

    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return last.value;
    }

    public void set(int pos, T v) {
        getElem(pos).value = v;
    }

    public void insert(T v) {
        ListenElem e = new ListenElem(first, v, null);
        if (isEmpty())
            last = e;
        else
            first.prev = e;
        first = e;
        size++;
    }

    public void append(T v) {
        ListenElem e = new ListenElem(null, v, last);
        if (isEmpty())
            first = e;
        else
            last.next = e;
        last = e;
        size++;
    }

    public void insert(int pos, T v) {
        if (pos == 0)
            insert(v);
        else if (pos == size)
            append(v);
        else {
            ListenElem cursor = getElem(pos);
            cursor.prev = new ListenElem(cursor, v, cursor.prev);
            cursor.prev.prev.next = cursor.prev;
            size++;
        }
    }

    public void remove(int pos) {
        delete(getElem(pos));
    }

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        if (size == 1) {
            first = last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if(size == 1) {
            first = last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }

    public void delete(T v) {
        ListenElem e = getElem(v);
        if (e == null) throw new NoSuchElementException();
        delete(e);
    }

    @Override
    public String toString() {
        String s = "{";
        ListenElem cursor = first;
        while (cursor != null) {
            s += cursor.value;
            if (cursor != last) s += ",";
            cursor = cursor.next;
        }
        return s + "}";
    }

    private ListenElem getElem(T v) {
        ListenElem cursor = first;
        while (cursor != null) {
            if (cursor.value.equals(v)) return cursor;
            cursor = cursor.next;
        }
        return null;
    }

    private ListenElem getElem(int pos) {
        if (pos < 0 || pos >= size) throw new IndexOutOfBoundsException();
        ListenElem cursor = first;
        for (int i = 0; i < pos; i++) cursor = cursor.next;
        return cursor;
    }

    private void delete(ListenElem e) {
        if (e == null) throw new IllegalArgumentException();
        if (e == first)
            removeFirst();
        else if (e == last)
            removeLast();
        else {
            e.prev.next = e.next;
            e.next.prev = e.prev;
            size--;
        }
    }

    /* Innere Klassen */

    class ListenElem {

        /* Instanzvariablen */

        ListenElem next;
        T value;
        ListenElem prev;

        /* Konstruktoren */

        public ListenElem(ListenElem next, T value, ListenElem prev) {
            this.next = next;
            this.value = value;
            this.prev = prev;
        }
    }
}
