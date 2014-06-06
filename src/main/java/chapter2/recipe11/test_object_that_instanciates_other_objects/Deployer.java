package chapter2.recipe11.test_object_that_instanciates_other_objects;

import java.io.File;
import java.io.FileNotFoundException;

public class Deployer {
    private static Deployer deployer = new Deployer();

    public static Deployer getInstance() {
        return deployer;
    }

    public boolean deploy(Deployment deployment, File targetFile) throws FileNotFoundException {
        return true;
    }
}
