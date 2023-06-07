package cucumber.cucumber0;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("user test one")
    public void userTestOne() {
        System.out.println("user test one");
    }

    @When("user test two")
    public void userTestTwo() {
        System.out.println("user test two");
    }

    @Then("user test three")
    public void userTestThree() {
        System.out.println("user test three");
    }

    @Given("user test four")
    public void userTestFour() {
        System.out.println("user test four");
    }

    @When("user test five")
    public void userTestFive() {
        System.out.println("user test five");
    }

    @Then("user test six")
    public void userTestSix() {
        System.out.println("user test six");
    }
}
