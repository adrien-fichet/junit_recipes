package chapter2.recipe6.test_interface;

import java.util.ArrayList;
import java.util.Iterator;

public class MoreCompleteListIteratorTest extends MoreCompleteIteratorTest {

	@Override
	public Iterator<Object> makeNoMoreElementsIterator() {
		return new ArrayList<Object>().iterator();
	}

	@Override
	public boolean supportsRemove() {
		return true;
	}

}
