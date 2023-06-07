package runwithjava.example1;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LocatorsPom {

    public LocatorsPom(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#search input")
    private WebElement searchInput;

    @FindBy(css = "#search button")
    private WebElement searchButton;


    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

}
