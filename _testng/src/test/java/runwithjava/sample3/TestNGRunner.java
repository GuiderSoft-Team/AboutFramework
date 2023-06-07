package runwithjava.sample3;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestNGRunner {
    private void testRunner(Map<String, String> testngParams) {

        // Running TestNG programmatically
        // http://testng.org/doc/documentation-main.html#running-testng-programmatically

        //Create an instance on TestNG
        TestNG testNG = new TestNG();

        //Create an instance of XML Suite and assign a name for it.
        XmlSuite suite = getXmlSuite();

        //Create an instance of XmlTest and assign a name for it.
        XmlTest test = getXmlTest(suite);

        //Add any parameters that you want to set to the Test.
        test.setParameters(testngParams);

        //Create a list which can contain the classes that you want to run.
        List<XmlClass> classes = getXmlClasses();

        //Assign that to the XmlTest Object created earlier.
        test.setXmlClasses(classes);

        //Create a list of XmlTests and add the Xmltest you created earlier to it.
        List<XmlTest> tests = new ArrayList<XmlTest>();
        tests.add(test);

        //add the list of tests to your Suite.
        suite.setTests(tests);

        //Add the suite to the list of suites.
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);

        //Set the list of Suites to the testNG object you created earlier.
        testNG.setXmlSuites(suites);

        //invoke run() - this will run your class.
        testNG.run();

    }

    private XmlSuite getXmlSuite() {
        XmlSuite suite = new XmlSuite();
        suite.setName("Test Suite");
        return suite;
    }

    private XmlTest getXmlTest(XmlSuite suite) {
        XmlTest test = new XmlTest(suite);
        test.setName("test_with_firefox");
        return test;
    }

    private List<XmlClass> getXmlClasses() {
        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("testng"));
        return classes;
    }

    public static void main(String args[]) {

        TestNGRunner runner = new TestNGRunner();
        Map<String,String> params = new HashMap<String,String>();
        params.put("browserName", "Firefox");
        params.put("remoteUrl", "");
        params.put("domain", "http://www.google.com");
        runner.testRunner(params);
    }
}
