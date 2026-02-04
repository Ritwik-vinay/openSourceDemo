package pages;

import base.basePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.configReader;
import utils.elementActions;
import utils.waitUtils;

import java.util.NoSuchElementException;

public class loginPage extends basePage {
    private elementActions actions;
    //    @FindBy(xpath = "//input[@placeholder= 'Username']")
//    private WebElement username;
//
//    @FindBy(xpath = "//input[@placeholder='Password']")
//    private WebElement password;
//
//    @FindBy(xpath = "//button[@type= 'submit']")
//    private WebElement submitbtn;
    private By username = By.xpath("//input[@placeholder= 'Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By loginbtn = By.xpath("//button[@type= 'submit']");
//    private By nameUser = By.xpath("//p[@class='oxd-userdropdown-name']");

    public loginPage(WebDriver driver) {
        super(driver);
        actions = new elementActions(driver);
    }

    public void open() {

        driver.get(configReader.get("baseUrl"));
        waitUtils.waitForPageLoadComplete();
    }

    public void login(String user, String pass) {
        actions.type(username, "Admin");
        actions.type(password, "admin123");
        actions.click(loginbtn);
    }

//    public boolean isLoginSuccessful() {
//        try {
//            return DriverManager.getDriver().findElement(nameUser).isDisplayed();
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
}

