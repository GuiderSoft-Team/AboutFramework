package screenshot;

import utils.BrowserConfig;
import org.testng.annotations.Test;

import static screenshot.LocatorsInterface.*;

public class ScreenShotTest extends BaseTest {

    // bu degiskenler browser yapilandirmasi icin kullanilacagi icin
    // browser create edilmeden initialize edilmelidir.
    {
        BrowserConfig.headless = true;
        BrowserConfig.takeScreenShot = true;
    }

    public static void main(String[] args) {
        System.out.println((int)Character.MAX_VALUE);

    }

    @Test
    public void test_Screenshot1(){

        driver.get(url);
        sendKeys(searchInput, "mac");
        click(searchButton);
        String title = driver.getTitle();
        /*
        try {
            Assert.assertEquals(title, "mac");
        }catch (AssertionError e){
            Utils.takeScreenShot();
            //Assert.fail();
        }

         */
    }


}
