package utils;

import org.testng.Assert;

public class AssertUtils {

    public static void assertTrue(boolean condition, String message){
        Assert.assertTrue(condition, message);
    }

    public static void assertEquals(String actual,String expected, String message){
        Assert.assertEquals(actual, expected, message);
    }
}
