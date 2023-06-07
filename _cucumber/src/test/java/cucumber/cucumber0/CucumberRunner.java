package cucumber.cucumber0;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        features = {"testOutput/feature1.feature"},
        glue = {"cucumber/cucumber1/stepdefs"}
)

//@RunWith(Cucumber.class)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void beforeTest(){

    }

    @AfterTest
    public void afterTest(){

    }

}
