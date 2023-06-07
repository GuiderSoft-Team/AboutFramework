package denemeler.parent;

import driver.abstractdefine.ChromeDriverFactory;
import org.openqa.selenium.WebDriver;


public class ParentClass {

    WebDriver driver;

    // instance initializer
    {
        driver = new ChromeDriverFactory().getDriver();
    }

}
