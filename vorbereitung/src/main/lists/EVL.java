package main.lists;

import java.util.NoSuchElementException;

public class EVL<T> {
    private ListEl first;

    private int size;

    class ListEl {
        ListEl next;
        T value;

        public ListEl(T v) {
            value = v;
            next = null;
        }
    }

    public EVL() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public T get() {
        if (isEmpty()) throw new NoSuchElementException("Liste leer");
        return first.value;
    }

    public T get(int pos) {
        if(pos < 0 || pos > size) throw new IndexOutOfBoundsException();
        ListEl cursor = first;
        while (cursor != null) {
            for(int i = 0; i < pos; i++) {
                cursor = cursor.next;
            }
            return cursor.value;
        }
        return null;
    }

    public void insert(T e) {
        ListEl newEl = new ListEl(e);
        if (first == null) {
            first = newEl;
        } else {
            newEl.next = first;
            first = newEl;
        }
        size++;
    }

    public void remove() {
        if(first == null) return;
        first = first.next;
        size--;
    }

    public void delete(T e) {
        ListEl currEl = first;
        ListEl prevEl = first;
        while (currEl != null) {
            if(currEl.value.equals(e)) {
                if (currEl == first) {
                    remove();
                    return;
                }

                prevEl.next = currEl.next;
                size--;
                return;
            }

            prevEl = currEl;
            currEl = currEl.next;
        }
    }

    public boolean contains(T e) { return (getElem(e) != null);}

    private ListEl getElem(T e) {
        ListEl cursor = first;
        while(cursor != null) {
            for(int i =0;i < size; i++) {
                if(cursor.value.equals(e)) return cursor;
                cursor = cursor.next;
            }
        }
        return null;
    }


}
