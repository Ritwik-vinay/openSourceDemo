package listeners;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.LoggerUtil;
import utils.ScreenshotUtils;


public class TestListeners implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Logger log = LoggerUtil.getLogger(result.getTestClass().getRealClass());
        log.error("Test Failed: {} ", result.getName());
        log.error("Reason: ", result.getThrowable());


        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            ScreenshotUtils.takeScreenshot(
                    driver,
                    result.getName()
            );
        }
    }
}