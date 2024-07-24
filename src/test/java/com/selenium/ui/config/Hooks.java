package com.selenium.ui.config;

import com.selenium.ui.utils.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    public Properties configProps = null;
    public WebDriver driver = null;

    @BeforeSuite
    public void beforeSuite() {
        readConfig();
    }

    @BeforeClass
    public void beforeClass() {

    }

    @BeforeTest
    public void beforeTest() {

    }

    @BeforeMethod
    public void beforeMethod() {
        launchBrowser();
    }

    @AfterMethod
    public void afterMethod() {
        closeBrowser();
    }

    @AfterTest
    public void afterTest() {

    }

    @AfterClass
    public void afterClass() {

    }

    @AfterSuite
    public void afterSuite() {

    }

    public void readConfig() {
        try {
            FileInputStream fis = new FileInputStream(new File("./src/test/resources/config-qa.properties"));
            configProps = new Properties();
            configProps.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void launchBrowser() {
        if(configProps.getProperty("browser").equalsIgnoreCase("CHROME")) {
            System.setProperty("webdriver.chrome.driver", configProps.getProperty("browser_driver"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void closeBrowser() {
        driver.quit();
    }
}
