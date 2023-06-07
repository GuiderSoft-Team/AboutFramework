package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Wdm {

    @Test
    public void test_wdm1(){
        WebDriverManager wdm = WebDriverManager.chromedriver().watch();

        System.out.println(wdm.getBrowserPath());
        System.out.println(wdm.getDriverVersions());
        WebDriver driver = wdm.create();
    }

    @Test
    public void test_wdm2(){
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriver driver1 = WebDriverManager.chromedriver().create();
        driver1.get("https://google.com");
        driver1.quit();
        //driver.quit();
    }







}
