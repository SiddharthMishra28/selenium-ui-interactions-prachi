package com.selenium.ui.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.ui.config.Hooks;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportManager extends Hooks implements ITestListener {

    public static Logger logger = LoggerFactory.getLogger(ReportManager.class);

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started!");
        logger.info("Sample Log!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test "+result.getMethod().getMethodName()+" Passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result.getMethod().getMethodName());
        System.out.println("Testcase xyz FAILED!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Testcase xyz SKIPPED!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(configProps.getProperty("report_path"));
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Hybird Framework Test Execution Report");
        sparkReporter.config().setReportName("Test Summary Report");
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public static void captureScreenshot(String testName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String folderPath = configProps.getProperty("screenshot_path");
        String name = folderPath+"/"+testName + "_" + timestamp+".png";
        File folder = new File(folderPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        try {
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenShot, new File(name));
            test.log(Status.FAIL, "Script Failed Due to... ", MediaEntityBuilder.createScreenCaptureFromPath(new File(name).getAbsolutePath()).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
