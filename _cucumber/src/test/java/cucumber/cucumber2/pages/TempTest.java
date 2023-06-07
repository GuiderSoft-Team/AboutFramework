package cucumber.cucumber2.pages;

import org.testng.annotations.Test;

public class TempTest extends BaseTest {

    @Test
    public void test1(){

        ButtonAction buttonAction = ButtonAction.ButtonAction();
        buttonAction.findByText("Home");
        buttonAction.click();
    }


    @Test
    public void test2(){
        ButtonAction.ButtonAction().findByText("Home").click();
        //buttonAction().findByText("Desktop", false).click();
        ButtonAction.ButtonAction().findByText("Download").click();
        ButtonAction.ButtonAction().findByText("Excel", false).click();
        ButtonAction.ButtonAction().findByText("Documents").click();

    }

    @Test
    public void testClickButton(){
        String url = "https://demoqa.com/checkbox";
        driver.get(url);
        driver.manage().window().maximize();
        test2();
    }


    @Test
    public void test3(){
        String url = "https://demoqa.com/text-box";
        driver.get(url);
        driver.manage().window().maximize();
        TextboxAction.TextboxAction().findByText("Full Name").sendKeys("Full name - 1");
        TextboxAction.TextboxAction().findByText("Email").sendKeys("Email - 2");
        TextboxAction.TextboxAction().findByText("Current Address").sendKeys("Current Address - 3");
        TextboxAction.TextboxAction().findByText("Permanent Address").sendKeys("Permanent Address - 4");

    }



}
