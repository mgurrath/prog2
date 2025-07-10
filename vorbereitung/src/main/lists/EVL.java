package main.lists;

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
        return first.value;
    }

    public void insert(T e) {
        ListEl newEl = new ListEl(e);
        newEl.next = first;
        first = newEl;
        size++;
    }

    public void remove() {
        if(first == null) return;
        first = first.next;
        size--;
    }
}
