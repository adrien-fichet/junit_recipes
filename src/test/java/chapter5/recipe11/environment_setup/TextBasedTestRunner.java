package chapter5.recipe11.environment_setup;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TextBasedTestRunner {

    public static Test suite() {
        TestSuite suite = new TestSuite();
        // Setup test suite
        return suite;
    }

    private static void environmentSetup() {
        System.out.println("Environment setup");
    }

    private static void environmentTeardown() {
        System.out.println("Environment teardown");
    }

    public static void main(String[] args) {
        environmentSetup();
        TestRunner.run(suite());
        environmentTeardown();
    }
}
