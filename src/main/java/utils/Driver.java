package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return getDriver("chrome");
    }

    public static WebDriver getDriver(Browser browser){
        return getDriver(browser.toString());
    }

    public static WebDriver getDriver(String browser){
        if (drivers.get() == null) {
            switch (browser.toLowerCase()){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    drivers.set(new SafariDriver());
                    break;
                default:
                    ChromeOptions options = new ChromeOptions();
                    if (BrowserConfig.headless)
                        options.addArguments("--headless");
                    if (BrowserConfig.startMaximize)
                        options.addArguments("--start-maximized");

                    WebDriverManager.chromedriver().setup();
                    drivers.set(new ChromeDriver(options));
            }
        }
        return drivers.get();
    }


    public static void quitDriver(){
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }


}
