package cucumber.cucumber2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.MessageFormat;

public class TextboxAction extends BaseAction{

    //private static final String INPUT_CHECKBOX_XPATH = "(//label[contains(text(), \"{0}\")]/ancestor::div[@id][1]//input) | (//label[contains(text(), \"{0}\")]/ancestor::div[@id][1]//textarea)[1]";
    private static final String INPUT_XPATH = "(//label[contains(text(), \"{0}\")]/ancestor::div[@id][1]//input)";
    private static final String TEXTAREA_XPATH = "(//label[contains(text(), \"{0}\")]/ancestor::div[@id][1]//textarea)";
    private static final String INPUT_XPATH1 = "(//span[contains(text(), \"{0}\")]/ancestor::div[@id][1]//input)";

    private static final String XPATH =  INPUT_XPATH +
                                        "|" + INPUT_XPATH1 +
                                        "|" + TEXTAREA_XPATH +
                                        "[1]";

    private String text;



    public static TextboxAction TextboxAction(){
        return new TextboxAction();
    }

    private TextboxAction(){

    }


    public TextboxAction findByText(String text){
        String xpathText;
        xpathText = MessageFormat.format(XPATH, text);
        this.locator = By.xpath(xpathText);
        return this;
    }


    public void click(){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendKeys(String text){
        wait.until((driver)->{
            try {
                System.out.println(locator);
                driver.findElement(locator).sendKeys(text);
                return true;
            }catch (Exception e){
                return false;
            }
        });


    }







}
