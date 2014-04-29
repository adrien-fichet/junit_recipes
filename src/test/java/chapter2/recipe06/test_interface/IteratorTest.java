package chapter2.recipe06.test_interface;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public abstract class IteratorTest {
    private Iterator<?> noMoreElementsIterator;

    public abstract Iterator<?> makeNoMoreElementsIterator();

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
        } catch (NoSuchElementException expected) {
        }
    }

    @Test
    public void testRemoveNoMoreElements() {
        try {
            noMoreElementsIterator.remove();
            fail("No exception with no elements remaining!");
        } catch (IllegalStateException expected) {
        }
    }
}
