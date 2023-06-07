package cucumber.cucumber2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.MessageFormat;

public class ButtonAction extends BaseAction{

    private static final String BUTTON_XPATH = "//span[@class=\"rct-text\" and .//span[contains(text(), \"{0}\")]]//button";
    private static final String CHECKBOX_XPATH = "//span[@class=\"rct-text\" and .//span[contains(text(), \"{0}\")]]//input/parent::label";


    private String text;

    public static ButtonAction ButtonAction(){
        return new ButtonAction();
    }

    private ButtonAction(){

    }

    public ButtonAction findByText(String text){
        return findByText(text, true);
    }

    public ButtonAction findByText(String text, boolean isButton){
        String xpathText;
        if (isButton)
            xpathText = MessageFormat.format(BUTTON_XPATH, text);
        else
            xpathText = MessageFormat.format(CHECKBOX_XPATH, text);

        this.locator = By.xpath(xpathText);
        return this;
    }


    public void click(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }catch (Exception e){
            try {
                clickByAction();
            }catch (Exception ee){
                clickByJS();
            }
        }

    }

    private void clickByAction(){
        new Actions(driver).moveToElement(element(locator)).click().build().perform();
    }

    private void clickByJS(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element(locator));
    }




}
