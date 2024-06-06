package com.selenium.ui.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorsDemoTest {

    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://demo.guru99.com/V1/index.php");
        driver.findElement(By.name("uid")).sendKeys("mngr571718");
        driver.findElement(By.name("password")).sendKeys("patygYh");
        // tagname[@attribute=value]
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void checkContactUsLinkTest() throws InterruptedException {
        driver.get("http://vistacommerce-qa.rf.gd/");
        Thread.sleep(2000);
        String contactUsLink = driver.findElement(By.xpath("//div[@id='contact-link']/a")).getText();
        this.getTextBasedSearchedWebElement("*", "All sale products").click();
        if(contactUsLink.equalsIgnoreCase("Contact us")) {
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    public WebElement getTextBasedSearchedWebElement(String tagName, String elementText) {
        return driver.findElement(By.xpath("//"+tagName+"[contains(text(),'"+elementText+"')]"));
    }
}
