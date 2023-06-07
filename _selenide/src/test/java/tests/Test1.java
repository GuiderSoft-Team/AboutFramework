package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Test1 {

    @Test
    public void test1(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        open("http://opencart.abstracta.us/");
        $("input[name='search']").setValue("mac").pressEnter();
        $$("div.product-layout").shouldHave(CollectionCondition.sizeGreaterThan(3));
    }
}
