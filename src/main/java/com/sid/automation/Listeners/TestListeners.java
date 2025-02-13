package com.sid.automation.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.sid.automation.utils.ScreenshotUtils;
import com.sid.automation.utils.Reporting.ExtentReportManager;

    
@Listeners
public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ScreenshotUtils.takeScreenshot(result.getMethod().getMethodName());
        ExtentReportManager.getTest().fail("Test failed. Screenshot: " + screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Test skipped");
    }
}
