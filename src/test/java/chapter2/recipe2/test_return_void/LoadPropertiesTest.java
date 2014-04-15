package chapter2.recipe2.test_return_void;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class LoadPropertiesTest {

    @Test
    public void testLoadProperties() throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        File propertiesFile = new File(getClass().getResource("/application.properties").getPath());
        properties.load(new FileInputStream(propertiesFile));
        assertEquals("jbrains", properties.getProperty("username"));
        assertEquals("jbra1ns", properties.getProperty("password"));
    }
}
