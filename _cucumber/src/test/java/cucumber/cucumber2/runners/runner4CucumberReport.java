package cucumber.cucumber2.runners;


import driver.threadlocal.Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


@CucumberOptions(
        features = {"src/test/java/cucumber/cucumber2/features"},
        glue = {"cucumber/cucumber2/stepdefs"},
        plugin= {"pretty",
                "html:testOutput/cucumber-report/cucumberReporting.html",
                "json:testOutput/cucumber-report/cucumber.json"},
        monochrome = true
)

//@RunWith(Cucumber.class)
public class runner4CucumberReport extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void beforeTest(){

    }

    @AfterTest
    public void afterTest() {

        Driver.quitDriver();
    }

}
