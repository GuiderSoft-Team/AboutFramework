package junit;

import driver.Driver;
import org.junit.*;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class JUnitExample {

    public static void main(String[] args) {
        JUnitCore jUnitCore = new JUnitCore();
        Result result = jUnitCore.run(ParallelComputer.methods(), JUnitExample.class);
        System.out.println(result.getRunCount() + ", " + result.getFailureCount());
    }

    protected WebDriver driver;
    protected WebDriverWait wait;


    public void waitClose(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }



    @Test
    public void test1_clickBySelenium(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://opencart.abstracta.us/");
        WebElement button = driver.findElement(By.cssSelector("#search button"));
        WebElement input = driver.findElement(By.cssSelector("#search input"));
        input.clear();
        input.sendKeys("mac");
        clickBySelenium(button);
        waitClose(3000);
    }

    @Test
    public void test2_clickByActions(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://opencart.abstracta.us/");
        WebElement button = driver.findElement(By.cssSelector("#search button"));
        WebElement input = driver.findElement(By.cssSelector("#search input"));
        input.clear();
        input.sendKeys("mac");
        clickByActions(button);
        waitClose(3000);
    }

    @Test
    public void test3_clickByJS(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://opencart.abstracta.us/");
        WebElement button = driver.findElement(By.cssSelector("#search button"));
        WebElement input = driver.findElement(By.cssSelector("#search input"));
        input.clear();
        input.sendKeys("mac");
        clickByJS(button);
        waitClose(3000);
    }


    public void clickBySelenium(WebElement element){
        element.click();
    }

    public void clickByActions(WebElement element) {
        new Actions(driver).moveToElement(element).click().build().perform();
    }

    public void clickByJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void click(WebElement element){
        wait.until((driver) -> {
           try {
               element.click();
               return true;
           }catch (Exception e1){
               try {
                   new Actions(driver).moveToElement(element).click().build().perform();
                   return  true;
               }catch (Exception e2){
                   try {
                       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                       return true;
                   }catch (Exception e3){
                       return false;
                   }
               }
           }
        });
    }

}
