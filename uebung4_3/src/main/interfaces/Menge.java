package main.interfaces;

/**
 *
 * @author sw
 *
 * @param <T>
 */

public interface Menge<T> {

	int size();
	boolean isEmpty();
	T get();
	void insert(T e);
	void delete(T e);
	boolean contains(T e);
}
