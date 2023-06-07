package driver.threadlocal;

import driver.browser.options.BrowserOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Driver {
    /*
     * ThreadLocal her bir thread icin ayri ayri static driver tutmak icin kullanilir.
     * sadece .get, .set ve .remove methodlari vardir.
     * Bir islem baslatilir ve ThreadLocal'e chrome atanirsa, o islem icinde
     * herhangi bir zaman .get methodu ile olusturulan chrome driver'a ulasilabilir.
     */


    /**
     * ThreadLocal static drivers degiskeni
     */
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    /**
     * Default olarak chrome driver olusturur
     *
     * @return chrome webdriver
     */
    public static WebDriver getDriver() {
        return getDriver("chrome");
    }

    /**
     * Browser enum'nda aldigi browseri olusturur.
     *
     * @param browser browser name, Browser enum'indan alir
     * @return webdriver
     */
    public static WebDriver getDriver(Browser browser) {
        return getDriver(browser.toString());
    }

    /**
     * String olarak aldigi browser'i olusturur
     *
     * @param browser string olarak browser adi
     * @return webdriver
     */
    public static WebDriver getDriver(String browser) {
        if (drivers.get() == null) {
            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver(BrowserOptions.firefoxOptions()));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    drivers.set(new SafariDriver(BrowserOptions.safariOptions()));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    BrowserOptions.Chrome.remoteAllowOrigins();
                    drivers.set(new ChromeDriver(BrowserOptions.chromeOptions()));
            }
        }
        return drivers.get();
    }

    /**
     * driver'i kapatir ve null yapar
     */
    public static void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }


}
