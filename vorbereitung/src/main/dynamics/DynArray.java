package main.dynamics;

public class DynArray<T> {

    private int size;
    private int start = 2;

    private T[] array;

    @SuppressWarnings("unchecked")
    public DynArray() {
        array = (T[]) new Object[start];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void increase() {
        T[] neu = (T[]) new Object[array.length * 2];
        for (int i =0; i < size; i++) {
            neu[i] = array[i];
        }

        array = neu;
    }

    @SuppressWarnings("unchecked")
    private void decrease() {
        if(size <= (array.length / 4) && (array.length / 2) >= start) {
            T[] neu = (T[]) new Object[array.length / 2];
            for (int i = 0; i < size; i ++) {
                neu[i] = array[i];
            }

            array = neu;
        }
    }

    public int capacity() {
        return array.length;
    }

    public void remove(int pos) {
        if (pos < 0 || pos >= size) return;

        for(int i = pos; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;

        decrease();
    }

    public void remove() {
        remove(0);
    }

    public void delete(T e) {
        remove(pos(e));
    }

    private int pos(T e) {
        for(int i = 0; i < size; i++) {
            if(array[i] == e) return i;
        }

        return - 1;
    }

    public boolean contains(T e) {
        return (pos(e) != - 1);
    }

    public void add(T e) {
        if (size >= array.length) increase();
        array[size++] = e;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public T get(int pos) {
        if (pos < 0 || pos >= size) throw new IndexOutOfBoundsException("ungueltige Position");
        return array[pos];
    }

    public void set(int pos, T e) {
        if (pos < 0 || pos >= size) throw new IndexOutOfBoundsException("ungueltige Position");
        array[pos] = e;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += array[i] + "\n";
        }
        return s;
    }
}
