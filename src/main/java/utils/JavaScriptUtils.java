package utils;

import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class JavaScriptUtils {

    public  static JavascriptExecutor js(){
        return (JavascriptExecutor) DriverManager.getDriver();
    }
    public static void click(WebElement element){
        js().executeScript("argument[0].click();", element);
    }
    public static void scrollToView(WebElement element){
        js().executeScript("argument[0].scrollIntoView(true);",element);
    }

    public static void scrollBy(int x, int y){
        js().executeScript("window.scrollBy(argyment[0], argument[1]);",x ,y);
    }

    public static String getTitle(){
        return js().executeScript("return document.title;").toString();
    }

}
