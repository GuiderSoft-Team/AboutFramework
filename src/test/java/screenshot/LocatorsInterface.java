package screenshot;

import org.openqa.selenium.By;

public interface LocatorsInterface {

    String url = "http://opencart.abstracta.us/";
    By searchInput = By.cssSelector("#search input");
    By searchButton = By.cssSelector("#search button");

}
