package runwithjava.runclasses2;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class TestNgXmlUsingCode {
    public void testNgXmlSuite() {

        List<XmlSuite> suites = new ArrayList<>();
        List<XmlClass> classes = new ArrayList<>();
        List<Class<? extends ITestNGListener>> listenerClasses = new ArrayList<>();

        XmlSuite suite = new XmlSuite();
        suite.setName("ProgramSuite");

        XmlTest test = new XmlTest(suite);
        test.setName("ProgramTest");

        XmlClass clss1 = new XmlClass(SampleProgramOne.class);
        classes.add(clss1);

        XmlClass clss2 = new XmlClass(SampleProgramTwo.class);
        classes.add(clss2);

        listenerClasses.add(ListenerTest.class);

        test.setXmlClasses(classes);

        suites.add(suite);

        TestNG testNG = new TestNG();

        testNG.setXmlSuites(suites);
        testNG.setListenerClasses(listenerClasses);
        testNG.run();
    }

    public static void main(String[] args) {
        TestNgXmlUsingCode tnxuc = new TestNgXmlUsingCode();
        tnxuc.testNgXmlSuite();
    }
}
