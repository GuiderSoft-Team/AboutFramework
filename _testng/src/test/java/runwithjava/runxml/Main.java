package runwithjava.runxml;

import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        //suites.add("src/_testng/src/test/java/runwithjava/runxml/testng.xml");
        suites.add("D:\\Users\\IdeaProjects\\GuiderSoft\\AboutFramework\\_testng\\src\\test\\java\\runwithjava\\runxml\\testng.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}
