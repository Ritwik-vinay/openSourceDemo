package uiTest;

import base.baseTest;
import driver.DriverManager;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;

public class loginTest extends baseTest {

//    private static final Logger log = LoggerFactory.getLogger(loginTest.class);

    @Test(groups = "smoke" , retryAnalyzer = retry.RetryAnalyzer.class)
    @Description("Login with the valid username and Password")

    public void verifyValidLogin(){
        loginPage loginpage = new loginPage(DriverManager.getDriver());
        loginpage.open();
        loginpage.login("Admin", "admin123");

        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("dashboard"),
                "Login failed: Dashboard not reached");
    }
}
