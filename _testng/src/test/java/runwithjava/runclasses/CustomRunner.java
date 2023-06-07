package runwithjava.runclasses;

import org.testng.ITestNGListener;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class CustomRunner {

    public static void main(String args[]) {

        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Example1.class, Example2.class });
        List<Class<? extends ITestNGListener>> listeners = new ArrayList<>();
        listeners.add(CustomListener.class);
        testng.setListenerClasses(listeners);
        testng.run();

    }
}
