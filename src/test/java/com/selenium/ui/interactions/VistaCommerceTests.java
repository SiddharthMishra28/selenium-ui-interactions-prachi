package com.selenium.ui.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VistaCommerceTests {
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
        driver.findElement(By.xpath("//a/span[text()='Sign in']")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Create one here')]")).click();
        driver.findElement(By.name("id_gender")).click();
        driver.findElement(By.id("field-firstname")).sendKeys("Sid");
        driver.findElement(By.id("field-lastname")).sendKeys("Mishra");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
