package uiTest;

import base.baseTest;
import dataproviders.CSVDataProvider;
import dataproviders.LoginDataProvider;
import driver.DriverManager;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.loginPage;

public class loginTest extends baseTest {

//    private static final Logger log = LoggerFactory.getLogger(loginTest.class);

    @Test(groups = "smoke" ,
            retryAnalyzer = retry.RetryAnalyzer.class,
            dataProviderClass = CSVDataProvider.class,
            dataProvider  = "loginData")
    @Description("Login with the valid username and Password")

    public void verifyValidLogin(String username, String password, String expectedResult){
        loginPage loginpage = new loginPage(DriverManager.getDriver());
        loginpage.open();
        loginpage.login(username, password);
        boolean loginStatus= loginpage.isLoginSuccessful();
        if (expectedResult.equalsIgnoreCase("success")){
            Assert.assertTrue(loginStatus, "Login should be Succeed");
        }
        else {
            Assert.assertTrue(loginStatus,"Login should be Failed");
        }

//        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("dashboard"),
//                "Login failed: Dashboard not reached");
    }
}
