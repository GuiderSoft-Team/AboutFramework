package relativeLocation;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativLoc1 {

    WebDriver driver;
    WebDriverWait wait;



    @BeforeTest
    public void beforeTest(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void relativeLocation1(){
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        By lUsername = By.cssSelector("[name='username']");
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lUsername)).sendKeys("Admin");
        driver.findElement(with(By.tagName("input")).below(lUsername)).sendKeys("admin123");
        driver.findElement(with(By.tagName("button")).below(lUsername)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
    }


    @Test
    public void relativeLocation2(){
        driver.get("http://opencart.abstracta.us/");
        By lSearchBox = By.cssSelector("input[name='search']");

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(lSearchBox));
        searchBox.sendKeys("iPhone");

        By button = with(By.tagName("button")).toRightOf(searchBox);

        driver.findElement(button).click();
        /*
        driver.findElement(with(By.tagName("button"))
                .toRightOf(searchBox)
                .toLeftOf(By.cssSelector("#cart"))).click();

         */
    }
}
