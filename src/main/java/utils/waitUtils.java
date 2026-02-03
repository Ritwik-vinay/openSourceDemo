package utils;

import driver.DriverManager;
import org.apache.commons.lang3.math.Fraction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class waitUtils {
    private static final int DEFAULT_TIMEOUT=10;

    public static WebDriverWait getWait(){
        return new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(DEFAULT_TIMEOUT)
        );
    }
    public static WebElement visibilityOfElementLocated(By locator){
        return getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public static WebElement elementToBeClickable(By locator){
        return getWait().until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }
    public static boolean waitForUrlContains(String fraction){
        return getWait().until(
                        ExpectedConditions.urlContains(fraction));
    }

    public static void waitForPageLoadComplete(){
        getWait().until((Function<WebDriver,Boolean>)driver->
                ((JavascriptExecutor)driver).
                        executeScript("return document.readyState").
                        equals("complete"));
    }
    public static WebElement waitForStaleElement (By locator){
        return getWait().until(
                driver->{
                        try{
                            WebElement element = DriverManager.getDriver().findElement(locator);
                                    return element.isDisplayed()? element: null;
        }catch (StaleElementReferenceException e){
                            return null;
        }
    });
}
}


