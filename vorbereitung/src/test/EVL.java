import java.util.NoSuchElementException;

/**
 * @author akless
 * @licence MIT
 */

public class EVL<T> {

    /* Instanzvariablen */

    private ListenElem first;
    private int size;

    /* Instanzmethoden */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.value;
    }

    public void insert(T value) {
        ListenElem elem = new ListenElem(value, first);
        first = elem;
        size++;
    }

    public void remove() {
        if (isEmpty()) return;
        first = first.next;
        size--;
    }

    public void delete(T v) {
        if (isEmpty()) return;
        if (first.value.equals(v)) {
            remove();
            return;
        }
        ListenElem cursor = first;
        while (cursor.next != null) {
            if (cursor.next.value.equals(v)) {
                cursor.next = cursor.next.next;
                size--;
                return;
            }
            cursor = cursor.next;
        }
    }

    public boolean contains(T e) {
        ListenElem cursor = first;
        while (cursor != null) {
            if (cursor.value.equals(e)) return true;
            cursor = cursor.next;
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "";
        ListenElem cursor = first;
        while (cursor != null) {
            str += cursor.value;
            cursor = cursor.next;
        }
        return str;
    }

    /* Innere Klassen */

    class ListenElem {

        /* Instanzvariablen */

        T value;
        ListenElem next;

        /* Konstruktoren */

        public ListenElem(T value, ListenElem next) {
            this.value = value;
            this.next = next;
        }
    }
}
