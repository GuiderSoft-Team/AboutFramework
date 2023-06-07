package cucumber.cucumber1.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import driver.threadlocal.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        features = {"src/test/java/cucumber/cucumber1/features/feature1.feature"},
        glue = {"cucumber/cucumber1/stepdefs"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"}
)

//@RunWith(Cucumber.class)
public class runner1ExtentReport extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void beforeTest(){

    }

    @AfterTest
    public void afterTest(){
        Driver.quitDriver();
    }

}
