package test;

import main.adt.SchlangeAlsArray;
import main.adt.interfaces.Schlange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SchlangeAlsArrayTest {

    /* Instanzvariablen */

    private Schlange<Integer> uut;

    /* Instanzmethoden */

    @BeforeEach
    public void init() {
        uut = new SchlangeAlsArray<>();

    }

    @Test
    public void testInit() {
        assertTrue(uut.isEmpty());
        assertEquals(0, uut.size());
        assertThrows(NoSuchElementException.class, () -> uut.front());
        assertThrows(NoSuchElementException.class, () -> uut.dequeue());
        assertTrue(uut.isEmpty());
    }

    @Test
    public void test() {
        uut.enqueue(1);
        assertEquals(1, uut.front());
        uut.enqueue(2);
        assertEquals(1, uut.front());
        uut.enqueue(3);
        assertEquals(1, uut.front());
        uut.dequeue();
        assertEquals(2, uut.front());
        uut.dequeue();
        assertEquals(3, uut.front());
        uut.dequeue();
        assertTrue(uut.isEmpty());
    }
}
