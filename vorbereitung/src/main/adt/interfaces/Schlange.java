package main.adt.interfaces;


public interface Schlange<T> {

    /* Instanzmethoden */

    int size();
    boolean isEmpty();
    T front();
    void enqueue(T e);
    void dequeue();
}
