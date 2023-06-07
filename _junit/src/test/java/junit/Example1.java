package junit;


import org.junit.Assert;
import org.junit.Test;

public class Example1 {
    @Test
    public void test1() {
        Assert.assertTrue(true);
        System.out.println("Pass Test case - test1");
    }

    @Test
    public void test2() {
        Assert.assertTrue(false);
        System.out.println("Fail Test case - test2");
    }

    @Test
    public void test3() {
        Assert.assertTrue(true);
        System.out.println("Pass Test case - test3");
    }

}
