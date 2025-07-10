package main.lists;

import java.util.List;
import java.util.NoSuchElementException;

public class EVLL<T> {
    private ListEl first;

    private ListEl last;

    private int size;

    class ListEl {
        ListEl next;
        T value;

        public ListEl(T v) {
            value = v;
            next = null;
        }
    }

    public EVLL() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public T getFirst() throws NoSuchElementException {
        if(first == null) throw new NoSuchElementException("Liste leer");
        return first.value;
    }

    public T getLast() throws NoSuchElementException {
        if (last == null) throw new NoSuchElementException("Liste leer");
        return last.value;
    }

    public void insert(T e) {
        ListEl newEl = new ListEl(e);
        newEl.next = first;
        first = newEl;
        if(last == null) last = newEl;
        size++;
    }

    public void delete(T e) {
        ListEl currEl = first;
        ListEl prevEl = first;
        while (currEl != null) {
            if(currEl.value == e) {
                if(currEl == first) {
                    first = currEl.next;
                }

                if (currEl == last) {
                    last = prevEl;
                }

                prevEl.next = currEl.next;
            }

            prevEl = currEl;
            currEl = currEl.next;
        }
    }

    public void removeFirst() {
        if(first == null) return;
        if (first == last) {
            last = null;
        }
        first = first.next;
        size--;
    }

    public void append(T e) {
        ListEl newEl = new ListEl(e);
        if(first == null) {
            first = newEl;
        }

        if (last != null) {
            last.next = newEl;
        }
        last = newEl;

        size++;
    }

    public boolean contains(T e) {
        ListEl currEl = first;

        while (currEl != null) {
            if(currEl.value == e) {
                return true;
            }

            currEl = currEl.next;
        }

        return false;
    }
}
