package authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

public class UsingAutoIt extends AuthenticationBaseClass {

    /*
        AutoIt uygulamasi ile olusturulan exe dosyadi consolda run edilir.
        Robot class'in yaptigi islemi yapmaktadir.
     */
    String url = "https://the-internet.herokuapp.com/basic_auth";

    By authSuccess = By.xpath("//h3[text()='Basic Auth']");

    @Test
    public void authenticationWithAutoIt() throws IOException {
        String url = "https://the-internet.herokuapp.com/basic_auth";
        driver.get(url);
        Runtime.getRuntime().exec(new String[]{"src/main/resources/login.exe"});
        wait.until(ExpectedConditions.visibilityOfElementLocated(authSuccess));

    }

}
