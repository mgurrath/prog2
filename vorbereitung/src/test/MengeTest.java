package test;

import main.adt.MengeEVL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author akless
 * @licence MIT
 */

public class MengeTest {

    /* Instanzvariablen */

    private MengeEVL<String> uut;

    /* Instanzmethoden */

    @BeforeEach
    public void init() {
        uut = new MengeEVL();
    }

    @Test
    public void test() {
        uut.insert("A");
        assertEquals("A", uut.get());
        uut.insert("B");
        uut.insert("B");
        uut.insert("A");
        assertEquals(2, uut.size());
        uut.delete("B");
        uut.delete("B");
        uut.delete("B");
        assertEquals(1, uut.size());
    }
}
