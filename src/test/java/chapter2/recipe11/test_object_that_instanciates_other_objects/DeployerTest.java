package chapter2.recipe11.test_object_that_instanciates_other_objects;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DeployerTest {

    @Test
    public void testGetInstance() throws Exception {
        assertNotNull(Deployer.getInstance());
    }

    @Test
    public void testDeploy() throws Exception {
        assertTrue(new Deployer().deploy(new Deployment(), new File("hello")));
    }
}
