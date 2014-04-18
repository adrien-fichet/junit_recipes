package chapter2.recipe9.compare_collections;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CompareCollections {

    @Test
    public void testCompareLists() throws Exception {
        List<Integer> a1 = new ArrayList<Integer>();
        List<Integer> a2 = new ArrayList<Integer>();
        a1.addAll(Arrays.asList(1, 2, 3));
        a2.addAll(Arrays.asList(1, 2, 3));
        assertEquals(a1, a2);

        a2.clear();
        a2.addAll(Arrays.asList(3, 2, 1));
        assertEquals(new HashSet<Integer>(a1), new HashSet<Integer>(a2));
    }

    public void assertCollectionsEqual(final Collection a, final Collection b) {
        final Collection copyOfB = new LinkedList(b);
        final Iterator iterator = a.iterator();

        while (iterator.hasNext()) {
            final Object object = iterator.next();

            if (copyOfB.contains(object) == false) {
                fail("Expected: " + a + " but got: " + b);
            }

            copyOfB.remove(object);
        }

        if (copyOfB.isEmpty() == false) {
            fail("Second collection has elements that aren't in the first collection: " + copyOfB);
        }
    }

    @Test
    public void testCollectionsEqual() throws Exception {
        List<Integer> a1 = new ArrayList<Integer>();
        a1.addAll(Arrays.asList(1, 2, 3, 1, 3));
        List<Integer> a2 = new ArrayList<Integer>();
        a2.addAll(Arrays.asList(1, 1, 2, 3, 3));
        assertCollectionsEqual(a1, a2);
    }

}
