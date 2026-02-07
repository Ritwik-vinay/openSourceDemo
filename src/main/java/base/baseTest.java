package base;

import driver.BrowserFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import utils.LoggerUtil;
import utils.configReader;
import org.slf4j.Logger;


public class baseTest {
    protected Logger log = LoggerUtil.getLogger(this.getClass());

    //    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        log.info("Initializing Test SetUp");

        browser = configReader.get("browser");
        log.info("Browser selected: {} ",  browser);
        WebDriver driver = BrowserFactory.createDriver(
                configReader.get("browser")
        );
//        String browser=  configReader.get("browser");


        DriverManager.setDriver(BrowserFactory.createDriver(browser));
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver.DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
