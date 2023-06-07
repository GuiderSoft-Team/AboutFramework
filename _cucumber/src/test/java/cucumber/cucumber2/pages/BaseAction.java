package cucumber.cucumber2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.threadlocal.Driver;

import java.time.Duration;

public class BaseAction {
    protected By locator;
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    protected WebElement element(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void hover(){
        new Actions(Driver.getDriver())
                .moveToElement(element(locator))
                .build()
                .perform();
    }

}
