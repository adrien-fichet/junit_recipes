package chapter7.recipe02.using_log4unit;

import junit.log4j.LoggedTestCase;
import org.junit.Before;
import org.junit.Test;

public class Log4UnitTest extends LoggedTestCase {

    @Before
    public void setUp() {
        debug("Entered setup");
    }

    @Test
    public void testConnection() throws Exception {
        info("> entered " + this);
        boolean connected = false;
        info("Initiating connection to server now");
        // Create connection and set 'connected' to true if successful
        connected = true;
        assertTrue(connected);
    }
}
