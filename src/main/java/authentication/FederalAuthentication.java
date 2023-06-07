package authentication;

import driver.threadlocal.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static utils.Utils.sleep;

public class FederalAuthentication extends AuthenticationBaseClass {

    String url = "https://the-internet.herokuapp.com/federal_auth";

    By authSuccess = By.xpath("//h3[text()='Federal Auth']");

    @Test
    public void federalAuthentication1(){
        String username = "admin";
        String password = "admin";

        driver.get(url);
        driver.get(driver.getCurrentUrl().replace("://", "://" + username + ":" + password + "@"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(authSuccess));
    }

}
