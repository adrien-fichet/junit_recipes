package chapter2.recipe8.test_throw_exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ThrowExceptionTest {

	public static void assertThrows(Class<?> expectedExceptionClass, ExceptionalClosure closure) {
		String expectedExceptionClassName = expectedExceptionClass.getName();
		
		try {
			closure.execute();
			fail("Block did not throw an exception of type " + expectedExceptionClassName);
		} catch (Exception e) {
			assertTrue("Caught exception of type <" + e.getClass().getName() +
				">, expected one of type <" + expectedExceptionClassName + ">",
				expectedExceptionClass.isInstance(e));
		}
	}
	
	@Test
	public void testConstructorDiesWithNull() throws Exception {
		try {
			Fraction oneOverZero = new Fraction(1, 0);
			oneOverZero.getResult();
			fail("Created fraction 1/0! That's undefined!");
		} catch (IllegalArgumentException expected) {
			assertEquals("denominator == 0", expected.getMessage());
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testExceptionThrow() throws Exception {
		Fraction oneOverZero = new Fraction(1, 0);
		oneOverZero.getResult();
	}
	
	@Test
	public void testExceptionThrowWithAssertThrows() {
		assertThrows(IllegalArgumentException.class, new ExceptionalClosure() {
			@Override
			public void execute() {
				Fraction oneOverZero = new Fraction(1, 0);
				oneOverZero.getResult();
			}
		});
	}
}
