package cucumber.datatables.runner;


import cucumber.cucumber1.pages.BaseRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/java/cucumber/datatables/features/Feature1.feature"},
        glue = {"cucumber/datatables/stepdefs"},
        tags = "@Test1"
)


public class runner4 extends AbstractTestNGCucumberTests {

}
