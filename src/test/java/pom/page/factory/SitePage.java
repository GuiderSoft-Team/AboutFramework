package pom.page.factory;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.threadlocal.Driver;

import java.time.Duration;

public class SitePage{

    protected WebDriver driver;
    protected WebDriverWait wait;
    String url = "http://opencart.abstracta.us/";


    @Test
    public void test1(){
        driver.get(url);
        By rowLocator = By.cssSelector("div#content");
        By macLocator = By.xpath(".//h4[contains(.,'Mac')]");

        WebElement row = driver.findElement(rowLocator);
        WebElement mac = row.findElement(macLocator);
        mac.click();

        driver.quit();

        // (//button[.//ancestor::div[contains(@class,'product-thumb') and .//*[.='iPhone']]])[3]
    }



    @Test
    public void test2(){
        WebElement dialog1 = driver.findElement(By.xpath("//dialog1"));
        WebElement dialog2 = driver.findElement(By.xpath("//dialog2"));
        driver.findElement(By.xpath("//button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button"))).click();

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(dialog1),
                ExpectedConditions.visibilityOf(dialog2))
        );


        new WebDriverWait(driver, Duration.ofSeconds(60)).until(
                (driver) -> {
                   try {
                       if (dialog1.isDisplayed() || dialog2.isDisplayed())
                           return true;
                       return false;
                   }catch (Exception e){
                       return false;
                   }
        });

    }

    @Test
    public void testWait(){
        wait.until(
                (driver) -> {
                    return false;
                }
        );
    }


    @Test
    public void testWait2(){
        while (true){
            if (!getFalse()) break;
        }
    }

    public boolean getFalse(){
        return false;
    }




    @Before
    public void beforeTest(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void afterTest(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
