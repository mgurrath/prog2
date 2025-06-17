package test;

import main.MengeEVL;
import main.interfaces.Menge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author akless
 * @licence MIT
 */

public class MengeTest {

    /* Instanzvariablen */

    private Menge<String> uut;

    /* Instanzmethoden */

    @BeforeEach
    public void init() {
        uut = new MengeEVL();
    }

    @Test
    public void test() {
        uut.insert("A");
        assertEquals("A", uut.get());
        assertEquals("MengeEVL{list=A}", uut.toString());
        uut.insert("B");
        assertEquals("MengeEVL{list=BA}", uut.toString());
        uut.insert("B");
        uut.insert("A");
        assertEquals("MengeEVL{list=BA}", uut.toString());
        assertEquals(2, uut.size());
        uut.delete("B");
        uut.delete("B");
        uut.delete("B");
        assertEquals("MengeEVL{list=A}", uut.toString());
        assertEquals(1, uut.size());
    }
}
