package com.selenium.ui.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserLaunchTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void launchBrowserTest() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void launchBrowserTest2() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.quit();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
