package main.adt.interfaces;


public interface Stapel<T> {

    /* Instanzmethoden */

    boolean isEmpty();
    int size();
    T top();
    void push(T v);
    void pop();
}
