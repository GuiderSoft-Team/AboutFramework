package cucumber.cucumber1.stepdefs;

import cucumber.cucumber1.pages.Homepage;
import cucumber.cucumber1.pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyStepdefs {
    Homepage homepage;
    SearchPage searchPage;
    @Given("user on homepage")
    public void userOnHomepage() {
        homepage = new Homepage();
        homepage.gotoUrl();
    }

    @When("user search for {string}")
    public void userSearchFor(String searchedText) {
        searchPage = homepage.search(searchedText);
    }

    @Then("listed product count should be {int}")
    public void listedProductCountShouldBe(int num) {
        //searchPage = new SearchPage();
        Assert.assertEquals(searchPage.getProductNumber(), num);
        userOnHomepage();
    }

}
