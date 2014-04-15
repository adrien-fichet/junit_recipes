package chapter2.recipe3.test_constructor;

import static org.junit.Assert.*;
import org.junit.Test;

public class IntegerTest {

	@Test
	public void testInitialization() {
		Integer i = new Integer(12);
		assertEquals(12, i.intValue());
	}
}
