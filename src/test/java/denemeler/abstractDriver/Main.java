package denemeler.abstractDriver;

import driver.abstractdefine.ChromeDriverFactory;
import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriverFactory().getDriver();
        Test1 test1 = new Test1(driver);


        //Test2 test2 = new Test2(driver);

        Test2 test2 = test1.toTest2(); // new Test2(driver)
    }
}
