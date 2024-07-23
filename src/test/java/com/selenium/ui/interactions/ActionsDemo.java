package com.selenium.ui.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsDemo {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void createAccountTest() throws InterruptedException {
        driver.get("http://vistacommerce-qa.rf.gd/");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a/span[contains(text(), 'Sign in')]")));
        actions.build().perform();
        Thread.sleep(2000);
    }
}
