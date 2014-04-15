package chapter2.recipe2.test_return_void;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class AddToArrayListTest {

	@Test
	public void testAddToArrayList() {
		List<String> li = new ArrayList<String>();
		assertFalse(li.contains("hello"));
		li.add("hello");
		assertTrue(li.contains("hello"));
	}
}
