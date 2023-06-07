package runwithjava.runclasses2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleProgramTwo {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I am in beforeMethod");
    }

    @Test
    public void testOne() {
        System.out.println("I am in Simple Test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I am in afterMethod");
    }
}
