package runwithjava.example1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGTest1 extends BaseTest{




    @Test(priority = 1)
    public void test_1(){
        driver.get(LocatorsClass.url);
        sendKeys(LocatorsClass.searchInput, "mac");
        click(LocatorsClass.searchButton);
    }



    @Test(priority = 2)
    public void test_2(){
        driver.get(LocatorsClass.url);

        LocatorsPom locators = new LocatorsPom();

        sendKeys(locators.getSearchInput(), "mac");
        click(locators.getSearchButton());
    }


    @Test(invocationCount = 10)
    public void testInvocationCount(){
        System.out.println("Java");
    }

    @Test(dataProvider = "data")
    public void testDataProvider(int a, int b, int c){
        System.out.println(a + b + c);
    }

    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {1,2,3},
                {11,12,13}
        };
    }

    @Test(dataProvider = "data2")
    public void testDataProvider2(Object[] obj){
        for (Object o : obj) {
            System.out.print(o + "\t");
        }
        System.out.println();
    }



    @DataProvider
    public Object[][] data2(){
        return new Object[][]{
                {1,2,3},
                {11,12,13},
                {"a", "b", "c"}
        };
    }

    @DataProvider
    public Object[][] data3(){
        Object[][] retObj = new Object[1][10];

        retObj[0][0] = new Object[]{1,2,3};

        return retObj;
    }
}
