package main;

import main.interfaces.Menge;

public class MengeUtil {

    /* Klassenmethoden */

    public static <T> void merge(Menge<T> a, Menge<T> b) {
        while (!b.isEmpty()) {
            T item = b.get();
            b.delete(item);
            a.insert(item);
        }
    }
}
