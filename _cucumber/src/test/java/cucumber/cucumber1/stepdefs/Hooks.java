package cucumber.cucumber1.stepdefs;

import cucumber.cucumber1.pages.BaseRunner;
import io.cucumber.java.*;
import driver.threadlocal.Driver;

public class Hooks {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("before All");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after All");
    }

    @Before()
    public void before(){
        System.out.println("before");
    }

    @After
    public void after(){
        if (!BaseRunner.runsWithRunner)
            Driver.quitDriver();
        System.out.println("after");
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("beforeStep");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("afterStep");
    }
}
