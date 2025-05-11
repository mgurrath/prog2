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
		if(size >= array.length)
			increase();
		// Falls Array noch nicht voll bzw nach increase
		array[size++] = v;
	}

	public void remove(int pos) {
		if (pos >= array.length || pos < 0) {
			return;
		}

		@SuppressWarnings("unchecked")
		T[] copy_array = (T[]) new Object[this.array.length];

		for(int i = 0; i < this.array.length; i++) {
			if (i != pos) {
				if(i > pos){
					copy_array[i-1] = this.array[i];
				} else {
					copy_array[i] = this.array[i];
				}
			}
		}

		if (this.array[pos] != null) {
			this.size--;
			decrease();
			for(int i=0;i<this.array.length;i++) {
				this.array[i] = copy_array[i];
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void remove() {
		if (this.array.length > 0) {

			T[] copy_array = (T[]) new Object[this.array.length];

			for(int i = 1; i < this.array.length; i++) {
				copy_array[i-1] = this.array[i];
			}

			if(this.array[0] != null) {
				this.size--;
				decrease();
				for(int i=0;i<this.array.length;i++) {
					this.array[i] = copy_array[i];
				}
			}

		}
	}

	@SuppressWarnings("unchecked")
	public void delete(T e) {
		T[] copy_array = (T[]) new Object[this.array.length];

		boolean isFirst = false;
        for (int i=0;i<this.array.length;i++) {
            if (this.array[i] == e && !isFirst) {
                isFirst = true;
            } else if(isFirst){
                copy_array[i - 1] = this.array[i];
            } else {
				copy_array[i] = this.array[i];
			}
        }

		if (isFirst){
			this.size--;
			decrease();
			for(int i=0;i<this.array.length;i++){
				this.array[i] = copy_array[i];
			}
		}
	}

	public boolean contains(T e) {
		boolean isFound = false;
        for (T t : this.array) {
            if (t == e) {
                isFound = true;
				break;
            }
        }

		return isFound;
	}

	@SuppressWarnings("unchecked")
	private void decrease() {
		if(this.array.length > 2 && this.size <= (this.array.length / 4)) {
			T[] neu = (T[]) new Object[this.array.length/2];
			int n_index = 0;
			for(int i=0;i < array.length;i++){
				if(this.array[i] != null){
					neu[n_index++] = this.array[i];
				}
			}

			this.array = neu;
		}
	}

	@SuppressWarnings("unchecked")
	private void increase() {
		T[] neu = (T[]) new Object[2*array.length];
		for(int i = 0; i < array.length; i++) {
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

}
