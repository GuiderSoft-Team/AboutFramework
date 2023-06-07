package cucumber.cucumber1.runners;


import cucumber.cucumber1.pages.BaseRunner;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/java/cucumber1/features/feature1.feature"},
        glue = {"cucumber/cucumber1/stepdefs"}
)


public class runner2 extends BaseRunner {


    @Test(dataProvider = "scenarios")
    public void runScenarios(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper){
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios(){
        return testNGCucumberRunner.provideScenarios();
    }


}
