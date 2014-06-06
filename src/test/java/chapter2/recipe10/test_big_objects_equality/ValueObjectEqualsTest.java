package chapter2.recipe10.test_big_objects_equality;

import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public abstract class ValueObjectEqualsTest {
    private Object control;
    private Map differentObjects = new HashMap();

    private Object equalToControl;
    private Object equalToControl2;

    private static final int NUM_ITERATIONS = 20;

    protected abstract Object createControlInstance() throws Exception;
    protected abstract Object createInstanceDiffersIn(String keyPropertyName) throws Exception;
    protected abstract List keyPropertyNames();

    @Before
    public void setUp() throws Exception {
        control = createControlInstance();
        equalToControl = createControlInstance();
        equalToControl2 = createControlInstance();

        for (Object each : keyPropertyNames()) {
            String eachName = (String) each;
            differentObjects.put(each, createInstanceDiffersIn(eachName));
        }

        try {
            assertNotNull("createControlInstance() returned null", control);
            assertNotNull("2nd createControlInstance() returned null", equalToControl);
            assertNotNull("3rd createControlInstance() returned null", equalToControl2);

            for (Object key : differentObjects.keySet()) {
                assertNotNull(nameOf(key) + " returned null", differentObjects.get(key));
            }

            assertNotSame(control, equalToControl);
            assertNotSame(control, equalToControl2);

            for (Object key : differentObjects.keySet()) {
                assertNotSame(nameOf(key) + " same as control", control, differentObjects.get(key));
                assertNotSame(nameOf(key) + " same as equalToControl", equalToControl, differentObjects.get(key));
                assertNotSame(nameOf(key) + " same as equalToControl2", equalToControl2, differentObjects.get(key));
            }

            assertNotSame(equalToControl, equalToControl2);

            assertEquals("1st and 2nd equal instances of different classes",
                    control.getClass(), equalToControl.getClass());
            assertEquals("1st and 3rd equal instances of different classes",
                    control.getClass(), equalToControl2.getClass());

            for (Object key : differentObjects.keySet()) {
                assertEquals("control instance and " + nameOf(key) + " of different classes",
                        control.getClass(), differentObjects.get(key).getClass()
                );
            }
        } catch (AssertionFailedError ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Test
    public final void testEqualsAgainstNewObject() {
        final Object o = new Object();

        assertNotEquals(o, control);
        assertNotEquals(o, equalToControl);
        assertNotEquals(o, equalToControl2);

        for (Object key : differentObjects.keySet()) {
            assertNotEquals(o, differentObjects.get(key));
        }
    }

    @Test
    public final void testEqualsAgainstNull() {
        assertNotEquals("null vs. 1st", null, control);
        assertNotEquals("null vs. 2nd", null, equalToControl);
        assertNotEquals("null vs. 3rd", null, equalToControl2);

        for (Object key : differentObjects.keySet()) {
            assertNotEquals("null vs. " + nameOf(key), null, differentObjects.get(key));
        }
    }

    @Test
    public final void testEqualsAgainstUnequalObjects() {
         for (Object key : differentObjects.keySet()) {
             assertNotEquals("1st vs. " + nameOf(key), control, differentObjects.get(key));
             assertNotEquals("2nd vs. " + nameOf(key), equalToControl, differentObjects.get(key));
             assertNotEquals("3rd vs. " + nameOf(key), equalToControl2, differentObjects.get(key));
             assertNotEquals(nameOf(key) + " vs. 1st", differentObjects.get(key), control);
             assertNotEquals(nameOf(key) + " vs. 2nd", differentObjects.get(key), equalToControl);
             assertNotEquals(nameOf(key) + " vs. 3rd", differentObjects.get(key), equalToControl2);
        }
    }

    @Test
    public final void testEqualsIsConsistentAcrossInvocations() {
        for (int i = 0; i < NUM_ITERATIONS; ++i) {
            testEqualsAgainstNewObject();
            testEqualsAgainstNull();
            testEqualsAgainstUnequalObjects();
            testEqualsIsReflexive();
            testEqualsIsSymmetricAndTransitive();
        }
    }

    @Test
    public final void testEqualsIsReflexive() {
        assertEquals("1st equal instance", control, control);
        assertEquals("2nd equal instance", equalToControl, equalToControl);
        assertEquals("3rd equal instance", equalToControl2, equalToControl2);

        for (Object key : differentObjects.keySet()) {
            assertEquals(nameOf(key) + " instance", differentObjects.get(key), differentObjects.get(key));
        }
    }

    @Test
    public final void testEqualsIsSymmetricAndTransitive() {
        assertEquals("1st vs. 2nd", control, equalToControl);
        assertEquals("2nd vs. 1st", equalToControl, control);

        assertEquals("1st vs. 3rd", control, equalToControl2);
        assertEquals("3rd vs. 1st", equalToControl2, control);

        assertEquals("2nd vs. 3rd", equalToControl, equalToControl2);
        assertEquals("3rd vs. 2nd", equalToControl2, equalToControl);
    }

    @Test
    public final void testHashCodeContract() {
        assertEquals("1st vs. 2nd", control.hashCode(), equalToControl.hashCode());
        assertEquals("1st vs. 3rd", control.hashCode(), equalToControl2.hashCode());
        assertEquals("2nd vs. 3rd", equalToControl.hashCode(), equalToControl2.hashCode());
    }

    @Test
    public final void testHashCodeIsConsistentAcrossInvocations() {
        int eq1Hash = control.hashCode();
        int eq2Hash = equalToControl.hashCode();
        int eq3Hash = equalToControl2.hashCode();

        final Map differentObjectsHashes = new HashMap();

        for (Object key : differentObjects.keySet()) {
            differentObjectsHashes.put(key, new Integer(differentObjects.get(key).hashCode()));
        }

        for (int i = 0; i < NUM_ITERATIONS; ++i) {
            assertEquals("1st equal instance", eq1Hash, control.hashCode());
            assertEquals("2nd equal instance", eq2Hash, equalToControl.hashCode());
            assertEquals("3rd equal instance", eq3Hash, equalToControl2.hashCode());

            for (Object key : differentObjects.keySet()) {
                assertEquals(nameOf(key) + " instance", ((Integer) differentObjectsHashes.get(key)).intValue(),
                        differentObjects.get(key).hashCode());
            }
        }
    }

    protected static void assertNotEquals(Object lhs, Object rhs) {
        assertNotEquals(null, lhs, rhs);
    }

    protected static void assertNotEquals(String failureMessage, Object lhs, Object rhs) {
        if (lhs != null)
            assertFalse(failureMessage, lhs.equals(rhs));
    }

    private final String nameOf(Object key) {
        return "objectDiffersBy('" + key + "')";
    }
}