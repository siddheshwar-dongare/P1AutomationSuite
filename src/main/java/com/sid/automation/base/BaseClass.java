package com.sid.automation.base;

import com.sid.automation.driver.DriverManager;
import com.sid.automation.utils.ScreenshotUtils;
import com.sid.automation.utils.Reporting.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.MediaEntityBuilder;
import java.time.Duration;

public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseClass() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click(WebElement element) {
        try {
            waitForElementToBeClickable(element);
            element.click();
        } catch (Exception e) {
            attachScreenshot("Click_Failed");
            throw e;
        }
    }

    protected void sendKeys(WebElement element, String text) {
        try {
            waitForElementToBeVisible(element);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            attachScreenshot("SendKeys_Failed");
            throw e;
        }
    }

    protected String getText(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            return element.getText();
        } catch (Exception e) {
            attachScreenshot("GetText_Failed");
            throw e;
        }
    }
    public void attachScreenshot(String stepName) {
    String screenshotPath = ScreenshotUtils.takeScreenshot(stepName); // Use ScreenshotUtils
    ExtentReportManager.getTest().fail("Screenshot on failure: " + stepName,
            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
}

}