package denemeler.staleelement;

import driver.threadlocal.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestStaleElement {

    WebDriver driver;
    String url = "https://opencart.abstracta.us/";
    By lSearchInput = By.xpath("//input[@name='search']");

    @BeforeTest
    public void beforeTest(){
        driver  = Driver.getDriver();
        driver.get(url);
    }

    @AfterTest
    public void AfterTest(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void test1_StaleElement(){
        WebElement searchInput = driver.findElement(lSearchInput);
        driver.navigate().refresh();
        searchInput.sendKeys("mac");
    }

    @Test
    public void test2_nonStaleElement(){
        WebElement searchInput = driver.findElement(lSearchInput);
        driver.navigate().refresh();
        searchInput = driver.findElement(lSearchInput);
        searchInput.sendKeys("mac");
    }
}
