package listeners;

import base.baseTest;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v143.page.model.Screenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListeners implements ITestListener {
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
       if (driver!=null){
           ScreenshotUtils.takeScreenshot(
                   driver,
                   result.getName()
           );
       }
    }
}