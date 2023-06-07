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

public class DigestAuthentication extends AuthenticationBaseClass {

    String url = "https://the-internet.herokuapp.com/digest_auth";
    String urlWithUsernamePassword = "https://admin:admin@the-internet.herokuapp.com/digest_auth";

    By authSuccess = By.xpath("//h3[text()='Digest Auth']");

    @Test
    public void digestAuthentication1(){
        driver.get(urlWithUsernamePassword);
        wait.until(ExpectedConditions.visibilityOfElementLocated(authSuccess));
    }

}
