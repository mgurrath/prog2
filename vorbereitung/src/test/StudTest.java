package test;

import main.comparator.Stud;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class StudTest {

    /* Instanzmethoden */

    @Test
    public void test() {

        Stud john = new Stud("John");
        Stud jane = new Stud("Jane");
        Stud jake = new Stud("Jake");

        assertTrue(john.compareTo(john) == 0);
        assertTrue(john.compareTo(jane) < 0);
        assertTrue(john.compareTo(jake) < 0);

        assertTrue(jane.compareTo(john) > 0);
        assertTrue(jane.compareTo(jane) == 0);
        assertTrue(jane.compareTo(jake) < 0);

        assertTrue(jake.compareTo(john) > 0);
        assertTrue(jake.compareTo(jane) > 0);
        assertTrue(jake.compareTo(jake) == 0);
    }
}
