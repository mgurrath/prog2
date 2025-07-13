import main.adt.FolgeAlsDynArray;
import main.adt.interfaces.Folge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author akless
 * @licence MIT
 */

public class FolgeDynArrayTest {

    /* Instanzvariablen */

    private Folge<String> uut;

    /* Instanzmethoden */

    @BeforeEach
    public void init() {
        uut = new FolgeAlsDynArray<>();
    }

    @Test
    public void test() {
        uut.insert(0, "A");
        assertEquals("A", uut.get(0));
        uut.insert(0, "A");
        uut.insert(1, "B");
        uut.insert(1, "B");
        assertEquals(4, uut.size());
        uut.delete("B");
        uut.remove(0);
        uut.delete("B");
        assertEquals(1, uut.size());
    }
}
