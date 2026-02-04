package dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name="loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"Admin", "admin123"},
                {"Invalid", "admin123"},
                {"Admin", "invalidPassword"}
        };
    }
}
