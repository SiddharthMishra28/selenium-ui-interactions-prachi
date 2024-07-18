package com.selenium.ui.interactions.sanitysuite;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class EventListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName());
        System.out.println("Test PASSED!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test FAILED!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Testing Completed!");
    }
}
