package com.selenium.ui.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserLaunchTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I'll execute before Test Method!");
    }

    @Test
    public void launchBrowserTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void launchBrowserTest2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.quit();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I'll execute after Test Method!");
    }
}
