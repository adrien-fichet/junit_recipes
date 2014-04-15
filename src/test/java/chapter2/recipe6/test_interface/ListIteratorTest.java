package chapter2.recipe6.test_interface;

import java.util.ArrayList;
import java.util.Iterator;

public class ListIteratorTest extends IteratorTest {

    @Override
    public Iterator<?> makeNoMoreElementsIterator() {
        return new ArrayList<Object>().iterator();
    }


}
