package com.selenium.ui.pages;

import com.selenium.ui.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonUtils {

    public By userIdField = By.name("uid");
    public By passwordField = By.name("password");
    public By loginButton = By.name("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginIntoPage(String url, String userId, String password) {
        this.navigateToUrl(url);
        this.typeIntoField(userIdField, userId);
        this.typeIntoField(passwordField, password);
        this.clickElement(loginButton);
    }
}
