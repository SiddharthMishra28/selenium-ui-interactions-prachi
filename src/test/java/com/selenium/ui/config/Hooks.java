package com.selenium.ui.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.ui.reporting.ReportManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static com.selenium.ui.reporting.ReportManager.test;

public class Hooks {

    public static Properties configProps = null;
    public static WebDriver driver = null;
    public ExtentReports extent;
    public ExtentSparkReporter sparkReporter;
    public static ExtentTest test;

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
