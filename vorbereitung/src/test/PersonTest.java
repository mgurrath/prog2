package test;

import main.comparator.Person;
import main.comparator.PersonComparator;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    /* Instanzmethoden */

    @Test
    public void test() {

        Person john = new Person("John", 1984);
        Person jane1 = new Person("Jane", 1980);
        Person jane2 = new Person("Jane", 2000);

        Comparator<Person> c = new PersonComparator();

        assertTrue(c.compare(john, john) == 0);
        assertTrue(c.compare(john, jane1) > 0);
        assertTrue(c.compare(john, jane2) > 0);

        assertTrue(c.compare(jane1, john) < 0);
        assertTrue(c.compare(jane1, jane1) == 0);
        assertTrue(c.compare(jane1, jane2) < 0);

        assertTrue(c.compare(jane2, john) < 0);
        assertTrue(c.compare(jane2, jane1) > 0);
        assertTrue(c.compare(jane2, jane2) == 0);
    }
}
