package com.selenium.ui.config;

import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

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

    }

    @Test
    public void dummyTest() {

    }

    @AfterMethod
    public void afterMethod() {

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
            Properties configProps = new Properties();
            configProps.load(fis);
            System.out.println("Browser : "+configProps.getProperty("browser"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
