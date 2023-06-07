package cucumber.cucumber2.pages;

import driver.threadlocal.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public static boolean takeScreenShot = false;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("chrome") String browser){
        driver = Driver.getDriver(browser);
        // implicitlyWait element precence/exist oluncaya kadar her bir elment icin bekler
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // belirtilen elementin isteninilen sarti bekleme süresi
        // a elementi clickable oluncaya kadar bekle
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void afterTest(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


    public void sendKeys(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public void sendKeys(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }


    public void pressEnter(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(Keys.ENTER);
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void scrollIntoView(By locator){
            scrollIntoView(locator, true);
    }

    public void scrollIntoView(By locator, boolean TF){
        String trueFalse = TF ? "true" : "false";
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(" + trueFalse + ");", element);
    }

    public void scroll(int y){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0, " + y + ");");
    }

    public void scrollBottom(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0, document.body.scrollHeight);");
    }


    public void scrollUntil(By locator){
        int i = 0;
        while (true){
            try {
                if ( i>20 || driver.findElement(locator).isDisplayed())
                    break;
                scroll(100);
                i++;
            }catch (Exception e){
                scroll(100);
               i++;
            }
        }
    }


    public void scrollUntil1(By locator){
        wait.until((driver)->{
            try {
                if (driver.findElement(locator).isDisplayed())
                    return true;
                throw new Exception("");
            }catch (Exception e){
                scroll(100);
                return false;
            }
        });
    }

    public void scrollUntil1(By locator, By locator2) {
        wait.until((driver) -> {
            try {
                if (driver.findElement(locator).isDisplayed() || driver.findElement(locator2).isDisplayed())
                    return true;
                throw new Exception("");
            } catch (Exception e) {
                scroll(100);
                return false;
            }
        });
    }



}
