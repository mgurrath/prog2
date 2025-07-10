package test;

import main.dynamics.DynArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sw (modified by akless: added tests for "remove", "delete", "contains" and "decrease")
 */

class DynArrayTest {
	
	static DynArray<Integer> da;
	static DynArray<String> sa;
	
	
	@BeforeEach
	void init() {
		da = new DynArray<>();
		sa = new DynArray<>();

		for (int i = 0; i <= 4; i++) {
			da.add(i+10);
		}

		da.add(12);
	}
	
	@Test
	void testAdd() {
		int s = da.getSize();
		da.add(20);
		assertEquals(s+1, da.getSize());
		assertTrue(sa.isEmpty());
		sa.add("hey");
		assertEquals("hey", sa.get(0));
	}

	
	@Test
	void testBounds() {
		assertThrows(IndexOutOfBoundsException.class, ()->{da.get(10);});
		assertThrows(IndexOutOfBoundsException.class, ()->{da.get(-3);});
		assertThrows(IndexOutOfBoundsException.class, ()->{sa.set(1, "Hey");});
	}
	
	@Test
	void testGetSet() {
		assertEquals(12, da.get(2));
		int s = da.getSize();
		da.set(3,  20);
		assertEquals(s, da.getSize());
		assertEquals(20, da.get(3));
		assertEquals(s, da.getSize());
	}

	/* added tests by akless: */

	@Test
	public void testRemove() {
		assertEquals(6, da.getSize());
		assertEquals(8, da.capacity());
		assertEquals("10\n11\n12\n13\n14\n12\n", da.toString());

		// e ist das erste Element des Arrays
		da.remove();
		assertEquals(5, da.getSize());
		assertEquals(8, da.capacity());
		assertEquals("11\n12\n13\n14\n12\n", da.toString());

		// e kommt irgendwo "in der Mitte des Arrays" vor
		da.remove(2);
		assertEquals(4, da.getSize());
		assertEquals(8, da.capacity());
		assertEquals("11\n12\n14\n12\n", da.toString());

		// e kommt mehrmals vor
		da.delete(12);
		assertEquals(3, da.getSize());
		assertEquals(8, da.capacity());
		assertEquals("11\n14\n12\n", da.toString());

		// e ist das letzte Element des Arrays
		da.delete(12);
		assertEquals(2, da.getSize());
		assertEquals(4, da.capacity());
		assertEquals("11\n14\n", da.toString());

		// e kommt gar nicht vor
		da.delete(12);
		da.remove(3);
		assertEquals(2, da.getSize());
		assertEquals(4, da.capacity());
		assertEquals("11\n14\n", da.toString());
	}
}
