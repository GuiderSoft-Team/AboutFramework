package authentication;

import driver.threadlocal.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static utils.Utils.sleep;

public class AuthenticationBaseClass {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void afterTest(){
        sleep(2000);
        driver.quit();
    }



    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeString(String str){
        for (int i = 0; i < str.length(); i++) {
            writeChar(str.charAt(i));
        }
    }

    public void writeSpecial(RobotKey key){
        switch (key){
            case TAB -> robot.keyPress(KeyEvent.VK_TAB);
            case ENTER -> robot.keyPress(KeyEvent.VK_ENTER);
            case CONTROL -> robot.keyPress(KeyEvent.VK_CONTROL);
            case SHIFT -> robot.keyPress(KeyEvent.VK_SHIFT);
        }
    }

    private void writeChar(char c){
        boolean upper = Character.isUpperCase(c);

        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
        if (upper) robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
        if (upper) robot.keyRelease(KeyEvent.VK_SHIFT);
    }


}
