package main.comparator;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int i = o1.name().compareTo(o2.name());
        if(i == 0) {
            return o1.gebJahr() - o2.gebJahr();
        }
        return i;
    }
}
