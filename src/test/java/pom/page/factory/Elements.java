package pom.page.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.threadlocal.Driver;

public class Elements {

    public Elements(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#search input")
    private WebElement searchInput;

    @FindBy(css = "#search button")
    private WebElement searchButton;




    public By getXPathOf(String text){
        return By.xpath("//a[contains(text(),\"" + text + "\"]");
    }

}
