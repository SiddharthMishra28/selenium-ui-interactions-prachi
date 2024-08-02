package com.selenium.ui.tests;

import com.selenium.ui.config.Hooks;
import com.selenium.ui.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends Hooks {

    LoginPage loginPage;

    @Test
    public void login_with_valid_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.loginIntoPage(configProps.getProperty("url"), "mngr581275", "YjUtavA");
        loginPage.assertStringMatch("GTPL Bank Manager HomePage", driver.getTitle());
    }
}
