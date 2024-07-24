package com.selenium.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonUtils {

    WebDriver driver = null;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void clickElement(By id){
        driver.findElement(id).click();
    }
}
