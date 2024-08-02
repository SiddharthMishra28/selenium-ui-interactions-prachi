package com.selenium.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CommonUtils {

    WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void typeIntoField(By field, String text) {
        driver.findElement(field).sendKeys(text);
    }

    public void clickElement(By id){
        driver.findElement(id).click();
    }

    public void assertStringMatch(String expected, String actual) {
        Assert.assertEquals(expected, actual);
    }
}
