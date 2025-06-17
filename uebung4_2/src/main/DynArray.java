package main;

public class DynArray<T> {

    // Klassenattribute
    private static int startgroesse = 2;

    // Instanzattribute
    private T[] array;
    private int size;

    // Konstruktoren

    @SuppressWarnings("unchecked")
    public DynArray() {
        this.array = (T[]) new Object[startgroesse];
        this.size = 0;
    }

    // Klassenmethoden

    // Instanzmethoden

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public T get(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException("ungueltige Position");
        return array[pos];
    }

    public void set(int pos, T v) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException("ungueltige Position");
        array[pos] = v;
    }

    public void add(T v) {
        if (size >= array.length)
            increase();
        // Falls Array noch nicht voll bzw nach increase
        array[size++] = v;
    }

    @SuppressWarnings("unchecked")
    private void increase() {
        T[] neu = (T[]) new Object[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            neu[i] = array[i];
        }
        this.array = neu;
    }

    // zusaetzlich
    public int capacity() {
        return array.length;
    }

	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++)
			s = s+ array[i] + "\n";
		return s;
	}

    /* added methods by akless: */

    public void remove(int pos) {
        if (pos < 0 || pos >= size) return;

        for (int i = pos; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;

        if (size <= array.length / 4 && array.length / 2 >= startgroesse)
            decrease();
    }

    public void remove() {
        remove(0);
    }

    public void delete(T e) {
        remove(pos(e));
    }

    public boolean contains(T e) {
        return pos(e) != -1;
    }

    private int pos(T e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e))
                return i;
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void decrease() {
        T[] neu = (T[]) new Object[array.length / 2];
        for (int i = 0; i < size; i++)
            neu[i] = array[i];
        array = neu;
    }
}
