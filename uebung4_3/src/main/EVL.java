package main;

import java.util.NoSuchElementException;

public class EVL<T> {
    private ListEl first;
    private ListEl last;

    private boolean isFirst;

    private int size;

    class ListEl {
        T value;
        ListEl next;

        ListEl(T v) {
            this.value = v;
            next = null;
        }
    }

    public EVL() {
        this.first = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(T v) {
        if(contains(v)) {
            return;
        }

        ListEl newEl = new ListEl(v);
        if (isFirst) {
            isFirst = false;
            last = newEl;
        }
        newEl.next = first;
        first = newEl;
        size++;
    }

    public T getFirst() throws NoSuchElementException {
        if (first == null)
            throw new NoSuchElementException("Liste leer");
        return this.first.value;
    }

    public T getLast() throws NoSuchElementException {
        if (last == null)
            throw new NoSuchElementException("Liste leer");
        return this.last.value;
    }


    public void append(T v) {
        ListEl newEl = new ListEl(v);
        ListEl lastEl = last;
        lastEl.next = newEl;
        last = newEl;
    }

    public void removeFirst() {
        // wenn k. El, nichts tun
        if (first == null)
            return;

        // wenn letzt. el, last-pointer null setzen
        if (first == last) {
            last = null;
        }
        // Naechstes EL auf first setzen, ggf. null
        first = first.next;
        size--;

    }
    
    public void delete(T v){
        ListEl currentEl = first;
        ListEl prevEl = first;
        while(currentEl != null) {
            if (currentEl.value == v) {
                // sofern erstes element
                if (currentEl == first) {
                    removeFirst();
                    return;
                } else {
                    // prev. Element auf naechstes setzen
                    size--;
                    prevEl.next = currentEl.next;
                    // sofern letztes El. gel. wird, last-pointer neu setzen
                    if(currentEl == last) {
                        last = prevEl;
                    }
                    return;
                }
            }
            prevEl = currentEl;
            currentEl = currentEl.next;
        }
    }

    @Override
    public String toString() {

        ListEl currEl = first;
        String value = "";

        while (currEl != null) {
            value = value + currEl.value;
            currEl = currEl.next;
        }


        return "MengeEVL{" +
                "list="  + value +
                '}';
    }


    public boolean contains(T v) {

        ListEl currentEl = first;

        while (currentEl != null) {
            if(currentEl.value == v) {
                return true;
            }
            currentEl = currentEl.next;
        }

        return false;
    }
}
