package chapter5.recipe01.system_property;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SystemPropertyTest {
    private String fooProperty = System.getProperty("FOO", "not set");
    private String spacesProperty = System.getProperty("spaces.are.ok", "not set");

    @Test
    public void testFooSystemProperty() throws Exception {
        assertEquals("BAR", fooProperty);
    }

    @Test
    public void testSpacesAreOkProperty() throws Exception {
        assertEquals("string with spaces", spacesProperty);
    }

}
