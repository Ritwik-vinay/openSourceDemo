package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class elementActions {
    private WebDriver driver;
    private waitUtils waitutil;
//    WebDriver driver= DriverManager.getDriver();


    public elementActions( WebDriver driver){
        this.driver= driver;
        this.waitutil= new waitUtils();
    }

    public void type(By locator, String text){
        WebElement element= waitutil.visibilityOfElementLocated(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator){
        WebElement element= waitutil.elementToBeClickable(locator);
        element.click();
    }
    public String getText(By locator){
        return waitutil.visibilityOfElementLocated(locator).getText();
    }


}
