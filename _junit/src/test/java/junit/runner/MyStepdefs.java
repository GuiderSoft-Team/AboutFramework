package junit.runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("user test junit one")
    public void userTestOne() {
        System.out.println("user test junit one");
    }

    @When("user test junit two")
    public void userTestTwo() {
        System.out.println("user test junit two");
    }

    @Then("user test junit three")
    public void userTestThree() {
        System.out.println("user test junit three");
    }

}
