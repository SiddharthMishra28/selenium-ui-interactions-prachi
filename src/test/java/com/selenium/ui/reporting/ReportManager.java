package com.selenium.ui.reporting;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportManager implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Framework booted!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Testcase xyz PASSED!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // SCREENSHOT LOGIC
        System.out.println("Testcase xyz FAILED!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Testcase xyz SKIPPED!");
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
        System.out.println("Execution Completed with Duration..");
    }
}
