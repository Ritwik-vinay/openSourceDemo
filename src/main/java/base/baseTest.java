package base;

import driver.BrowserFactory;
import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.configReader;

import java.time.Duration;

public class baseTest {

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser){
        WebDriver driver = BrowserFactory.createDriver(
                configReader.get("browser")
        );

        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if (driver.DriverManager.getDriver() !=null){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
