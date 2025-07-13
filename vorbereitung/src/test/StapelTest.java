package test;

import main.adt.StapelEVL;
import main.adt.interfaces.Stapel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StapelTest {

    /* Instanzvariablen */

    private Stapel<Integer> uut;

    /* Instanzmethoden */

    @BeforeEach
    public void init() {
        uut = new StapelEVL<>();
    }

    @Test
    public void testA() {
        uut.push(1);
        assertFalse(uut.isEmpty());
    }

    @Test
    public void testB() {
        uut.push(1);
        assertEquals(1, uut.top());
    }

    @Test
    public void testC1() {
        assertTrue(uut.isEmpty());

        uut.push(1);
        uut.pop();
        assertThrows(NoSuchElementException.class, () -> uut.top());
    }

    @Test
    public void testC2() {
        uut.push(1);
        assertFalse(uut.isEmpty());

        int top = uut.top();
        uut.push(2);
        uut.pop();
        assertEquals(top, uut.top());
    }
}
