package test;

import main.lists.EVLL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TestEVLL {

	static EVLL<Integer> list;

	@BeforeEach
	void init() {
		list = new EVLL<>();
	}
	
	@Test
	void testInit() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		assertThrows(NoSuchElementException.class, ()->{list.getFirst();});
		assertThrows(NoSuchElementException.class, ()->{list.getLast();});
	}
	
	@Test
	void testInsert() {
		// einfuegen in leere Liste
		list.insert(1);
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
		assertEquals(1, list.getFirst());
		assertEquals(1, list.getLast());
		
		// einfuegen in nicht-leere Liste
		list.insert(2);
		assertEquals(2, list.size());
		assertEquals(2, list.getFirst());
		assertEquals(1, list.getLast());
	}
	
	@Test
	void testAppend() {
		// anhaengen an leere Liste
		list.append(1);
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
		assertEquals(1, list.getFirst());
		assertEquals(1, list.getLast());
		
		// anhaengen an nicht-leere Liste
		list.append(2);
		assertEquals(2, list.size());
		assertEquals(1, list.getFirst());
		assertEquals(2, list.getLast());
	}
	
	@Test 
	void fuellen() {
		list.insert(1);
		list.append(2);
		list.insert(3);
		list.append(4);
		list.insert(5);
		assertEquals("5 3 1 2 4 ", list.toString());
	}
	
	@Test
	void testRemoveFirst() {
		// Sonderfall: Liste leer
		list.removeFirst();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		
		// Sonderfall: 1-elementige Liste (nach append)
		list.append(1);
		list.removeFirst();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		assertThrows(NoSuchElementException.class, ()->{list.getFirst();});
		assertThrows(NoSuchElementException.class, ()->{list.getLast();});
		
		// Sonderfall: 1-elementige Liste (nach insert)
		list.insert(1);
		list.removeFirst();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		assertThrows(NoSuchElementException.class, ()->{list.getFirst();});
		assertThrows(NoSuchElementException.class, ()->{list.getLast();});
		
		// Normalfall
		list.insert(1);
		list.append(2);
		list.removeFirst();
		assertEquals(1, list.size());
		assertEquals(2, list.getFirst());
		assertEquals(2, list.getLast());
	}

	@Test
	void testContains() {
		// Sonderfall: leere Liste
		assertFalse(list.contains(5));
		
		fuellen();
		
		// Normalfall: (list = (5 3 1 2 4 ))
		assertTrue(list.contains(1));
		assertTrue(list.contains(5));
		assertTrue(list.contains(4));
		assertFalse(list.contains(29));
	}
	
	@Test
	void testDelete() {
		// Sonderfall: Liste leer
		list.delete(5);
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		
		// Liste fuellen (list = (5 3 1 2 4 ))
		fuellen();
		
		// Normalfall:
		list.delete(1);
		assertFalse(list.contains(1));
		assertEquals(4, list.size());
		assertEquals(5, list.getFirst());
		assertEquals(4, list.getLast());
		assertEquals("5 3 2 4 ", list.toString());
	
		// Sonderfall: e = erstes Elem
		list.delete(5);
		assertFalse(list.contains(5));
		assertEquals(3, list.size());
		assertEquals(3, list.getFirst());
		assertEquals(4, list.getLast());
		assertEquals("3 2 4 ", list.toString());
		
		// Sonderfall: e = letztes Elem
		list.delete(4);
		assertFalse(list.contains(4));
		assertEquals(2, list.size());
		assertEquals(3, list.getFirst());
		assertEquals(2, list.getLast());
		assertEquals("3 2 ", list.toString());
	}
	

}
