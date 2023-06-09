package cucumber.cucumber1.pages;

import driver.threadlocal.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    WebDriver driver;

    @FindBy(css = "div.product-layout")
    List<WebElement> products;

    public SearchPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }


    public int getProductNumber(){
        return products.size();
    }



}
