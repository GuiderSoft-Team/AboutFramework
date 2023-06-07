package junit.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/java/runwithjava/junit/runner/JUnitFeature.feature"},
        glue = {"junit/runner"}
)

@RunWith(Cucumber.class)
public class JunitRunner {
}
