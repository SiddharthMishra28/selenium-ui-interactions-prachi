package com.selenium.ui.tests;

import com.selenium.ui.config.Hooks;
import com.selenium.ui.pages.LoginPage;
import com.selenium.ui.utils.CommonUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends Hooks {

    public LoginPage loginPage;

    @Test(dataProvider = "loginData")
    public void login_with_valid_credentials(String userName, String password) {
        loginPage = new LoginPage(driver);
        loginPage.loginIntoPage(configProps.getProperty("url"), userName, password);
        loginPage.assertStringMatch("GTPL Bank Manager HomePage", driver.getTitle());
    }

    @DataProvider(name = "loginData")
    public String[][] dataFeed() {
        return CommonUtils.readExcel(configProps.getProperty("data_source"), "loginData");
    }
}
