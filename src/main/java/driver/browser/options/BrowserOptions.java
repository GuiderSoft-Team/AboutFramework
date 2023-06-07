package driver.browser.options;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;

public class BrowserOptions {

    private static final ThreadLocal<ChromeOptions> chromeOptions = new ThreadLocal<>();
    private static ThreadLocal<FirefoxOptions> firefoxOptions = new ThreadLocal<>();
    private static ThreadLocal<SafariOptions> safariOptions = new ThreadLocal<>();

    public static ChromeOptions chromeOptions(){
        return chromeOptions.get() != null ? chromeOptions.get() : new ChromeOptions();
    }

    public static FirefoxOptions firefoxOptions(){
        return firefoxOptions.get() != null ? firefoxOptions.get() : new FirefoxOptions();
    }

    public static SafariOptions safariOptions(){
        return safariOptions.get() != null ? safariOptions.get() : new SafariOptions();
    }

    public class Chrome {

        static {
            chromeOptions.set(new ChromeOptions());
        }

        public static void headless() {
            chromeOptions.get().addArguments("--headless");
        }

        public static void startMaximized() {
            chromeOptions.get().addArguments("start-maximized");
        }

        public static void disableGPU() {
            chromeOptions.get().addArguments("--disable-gpu");
        }

        public static void disableInfobars() {
            chromeOptions.get().addArguments("disable-infobars");
        }
        public static void remoteAllowOrigins() {
            chromeOptions.get().addArguments("--remote-allow-origins=*");
        }

        public static void addExtention(String crxFilePath) {
            chromeOptions.get().addExtensions(new File(crxFilePath));
        }

        public static void acceptInsecureCert() {
            chromeOptions.get().setAcceptInsecureCerts(true);
        }

        public static void userProfile(String filePath){
            chromeOptions.get().addArguments("user-data-dir=" + filePath);
        }

        public static void automationEnabled() {
            chromeOptions.get().addArguments("--enable-automation");
            chromeOptions.get().addArguments("--enable-blink-features");
            chromeOptions.get().addArguments("--enable-blink-test-features");
        }

        public static void disableExtentions(){
            chromeOptions.get().addArguments("chrome.switches", "--disable-extensions");
        }

    }

    public class Firefox {
        static {
            firefoxOptions.set(new FirefoxOptions());
        }

        public static void headless() {
            firefoxOptions.get().addArguments("--headless");
        }

        public static void startMaximized() {
            firefoxOptions.get().addArguments("start-maximized");
        }

        public static void disableGPU() {
            firefoxOptions.get().addArguments("--disable-gpu");
        }

        public static void disableInfobars() {
            firefoxOptions.get().addArguments("disable-infobars");
        }

        public static void addExtention(String crxFilePath) {
            //firefoxOptions.addExtensions(new File(crxFilePath));
        }

        public static void acceptInsecureCert() {
            firefoxOptions.get().setAcceptInsecureCerts(true);
        }

        public static void automationEnabled() {
            firefoxOptions.get().addArguments("--enable-automation");
            firefoxOptions.get().addArguments("--enable-blink-features");
            firefoxOptions.get().addArguments("--enable-blink-test-features");
        }

    }
}
