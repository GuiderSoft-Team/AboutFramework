package runwithjava.runclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Example2 {
    @Test
    public void test4() {
        Assert.assertTrue(true);
        System.out.println("Pass Test case - test4");
    }

    @Test
    public void test5() {
        Assert.assertTrue(false);
        System.out.println("Pass Test case - test5");
    }

    @Test
    public void test6() {
        Assert.assertTrue(true);
        System.out.println("Pass Test case - test6");
    }
}
