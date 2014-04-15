package chapter2.recipe6.test_interface;

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class MoreCompleteIteratorTest {
	private Iterator<?> noMoreElementsIterator;
	
	public abstract Iterator<?> makeNoMoreElementsIterator();
	public abstract boolean supportsRemove();
	
	@Before
	public void setUp() {
		noMoreElementsIterator = makeNoMoreElementsIterator();
	}
	
	@Test
	public void testHasNextNoMoreElements() {
		assertFalse(noMoreElementsIterator.hasNext());
	}
	
	@Test
	public void testNextNoMoreElements() {
		try {
			noMoreElementsIterator.next();
			fail("No exception with no elements remaining!");
		} catch (NoSuchElementException expected) {}
	}
	
	@Test
	public void testRemoveNoMoreElements() {
		try {
			noMoreElementsIterator.remove();
			if (supportsRemove()) {
				fail("No exception with no elements remaining!");
			} else {
				fail("No exception when attempting to remove!");
			}
		} catch (IllegalStateException expected1) {
			if (!supportsRemove()) {
				fail("Expecting UnsupportedOperationException on attempt to remove!");
			}
		} catch (UnsupportedOperationException expected2) {
			if (supportsRemove()) {
				fail("Expecting IllegalStateException on attempt to remove!");
			}
		}
	}
}
