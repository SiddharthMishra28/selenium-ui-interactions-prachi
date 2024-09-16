package com.selenium.ui.tests;

import com.selenium.ui.config.Hooks;
import com.selenium.ui.pages.LoginPage;
import com.selenium.ui.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends Hooks {

    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    public LoginPage loginPage;

    @Test
    public void dummyTest() {
        System.out.println("Test case failed");
        Assert.assertTrue(false);
    }

    @Test(dataProvider = "loginData")
    public void login_with_valid_credentials(String userName, String password) {
        loginPage = new LoginPage(driver);
        loginPage.loginIntoPage(configProps.getProperty("url"), userName, password);
        logger.info("This is a sample log");
        loginPage.assertStringMatch("GTPL Bank Manager HomePage", driver.getTitle());
        logger.error("Script Failed for some reason!");
    }

    @DataProvider(name = "loginData")
    public String[][] dataFeed() {
        return CommonUtils.readExcel(configProps.getProperty("data_source"), "loginData");
    }
}
