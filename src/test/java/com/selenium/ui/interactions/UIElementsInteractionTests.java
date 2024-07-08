package com.selenium.ui.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UIElementsInteractionTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void checkoutTest() throws InterruptedException {
        driver.get("https://demo.guru99.com/payment-gateway/index.php");
        Select quantityDropdown = new Select(driver.findElement(By.name("quantity")));
        quantityDropdown.selectByVisibleText("1");
        driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
        driver.findElement(By.id("card_nmuber")).sendKeys("5544332299887733");
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        monthDropdown.selectByVisibleText("09");
        Select yearDropdown = new Select(driver.findElement(By.id("year")));
        yearDropdown.selectByVisibleText("2025");
        driver.findElement(By.name("cvv_code")).sendKeys("098");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);
    }

    @Test
    public void webTableTest() {
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        String baseXpath = "//table[@id='countries']/tbody/tr";
        int numRows = driver.findElements(By.xpath(baseXpath)).size();
        int numCols = driver.findElements(By.xpath(baseXpath+"[1]/td")).size();
        for(int i=1; i<=numRows; i++) {
            for(int j=1; j<numCols; j++) {
                String cellText = driver.findElement(By.xpath(baseXpath+"["+i+"]/td["+j+"]")).getText();
                System.out.println(cellText);
            }
        }
    }

    @Test
    public void explicititWaitExample() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
        driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
        driver.findElement(By.cssSelector("#btn1")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("txt1")));
        driver.findElement(By.id("txt1")).sendKeys("abcd");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    public WebElement getTextBasedSearchedWebElement(String tagName, String elementText) {
        return driver.findElement(By.xpath("//"+tagName+"[contains(text(),"+elementText+")]"));
    }
}
