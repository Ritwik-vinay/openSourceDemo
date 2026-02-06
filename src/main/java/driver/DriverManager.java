package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    public  static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager(){

    }
    public static void setDriver(WebDriver webDriver){
        driver.set(webDriver);
    }
    protected WebDriver getDriver(){
        return driver.get();
    }
    public static void unload(){
        driver.remove();
    }
}
