package cucumber.cucumber2.stepdefs;

import cucumber.cucumber2.pages.TextboxAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import driver.threadlocal.Driver;

import java.util.Map;

public class MyStepdefs {

    WebDriver driver = Driver.getDriver();

    @Given("user on page {string}")
    public void userOnPage(String url) {
        driver.get(url);
    }

    @When("user sendkeys {string} to {string}")
    public void userSendkeysTo(String text, String label) {
        TextboxAction.TextboxAction().findByText(label).sendKeys(text);
    }

    public void fillTheForm(Map<String, String> map) {
        map.forEach((k,v) -> TextboxAction.TextboxAction().findByText(k).sendKeys(v));

        /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            TextboxAction.TextboxAction().findByText(entry.getKey()).sendKeys(entry.getValue());
        }
         */
    }
}
