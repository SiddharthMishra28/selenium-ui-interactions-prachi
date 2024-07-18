package com.selenium.ui.interactions.sanitysuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestEventsDemo {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I will run before test method");
    }

    @Test
    public void simpleTest() {
        System.out.println("I am a test");
        Assert.assertTrue(false);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I will run after test method");
    }
}
