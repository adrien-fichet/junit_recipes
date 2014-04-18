package chapter2.recipe10.test_big_objects_equality;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ValueObjectEqualsTestFivePropertiesTest extends ValueObjectEqualsTest {

    @Override
    protected List keyPropertyNames() {
        return Arrays.asList(new String[]{"key1", "key2", "key3", "key4", "key5"});
    }

    @Override
    protected Object createControlInstance() {
        return new FiveKeys(1, 2, 3, 4, 5);
    }

    @Override
    protected Object createInstanceDiffersIn(String keyPropertyName) throws Exception {
        if (keyPropertyName.equals("key1")) {
            return new FiveKeys(6, 2, 3, 4, 5);
        } else if (keyPropertyName.equals("key2")) {
            return new FiveKeys(1, 6, 3, 4, 5);
        } else if (keyPropertyName.equals("key3")) {
            return new FiveKeys(1, 2, 6, 4, 5);
        } else if (keyPropertyName.equals("key4")) {
            return new FiveKeys(1, 2, 3, 6, 5);
        } else if (keyPropertyName.equals("key5")) {
            return new FiveKeys(1, 2, 3, 4, 6);
        } else {
            return null;
        }
    }

}
