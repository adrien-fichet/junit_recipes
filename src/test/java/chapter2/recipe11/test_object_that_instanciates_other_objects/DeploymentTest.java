package chapter2.recipe11.test_object_that_instanciates_other_objects;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class DeploymentTest {

    @Test
    public void testTargetFileNotFound() throws Exception {
        Deployer fileNotFoundDeployer = new FileNotFoundDeployer();
        Deployment deployment = new Deployment(fileNotFoundDeployer);

        try {
            deployment.deploy(new File("hello"));
            fail("Did not expect to find 'hello' target file");
        } catch (FileNotFoundException e) {
            assertEquals("hello", e.getMessage());
        }
    }

    @Test
    public void testDeploy() throws Exception {
        assertTrue(new Deployment(Deployer.getInstance()).deploy(new File("hello")));
    }

}