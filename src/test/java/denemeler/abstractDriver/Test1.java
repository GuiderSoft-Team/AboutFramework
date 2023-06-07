package denemeler.abstractDriver;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class Test1 {

    WebDriver driver;

    public Test1(WebDriver driver){
        this.driver = driver;
    }


    @Test
    public void test1(){


    }


    public Test2 toTest2(){
        return new Test2(driver);
    }




}
