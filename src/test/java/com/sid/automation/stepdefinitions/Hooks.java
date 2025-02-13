package com.sid.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import com.sid.automation.driver.DriverManager;
import com.sid.automation.utils.Loggers.Log;
import com.sid.automation.utils.Reporting.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static WebDriver driver;
    private static boolean isLoggedIn = false;

    @Before(order = 1)
    public void setup(Scenario scenario) {  
        // Initialize Extent Reports before creating the test
        ExtentReportManager.initReports();  
        
        // Create a test in the report with the scenario name
        ExtentReportManager.createTest(scenario.getName());

        System.out.println("🔹 Scenario Name: " + scenario.getName()); 

        if (driver == null) {
            driver = DriverManager.getDriver();
            Log.info("Browser is launching...");
        }
    }

    @Before(order = 2)
    public void loginBeforeScenario(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@LoginRequired") && !isLoggedIn) {
            Log.info("Executing login before scenario: " + scenario.getName());

            sauselabloginSteps loginSteps = new sauselabloginSteps();
            loginSteps.i_am_on_sauselab_loginpage();
            loginSteps.user_enter("standard_user", "secret_sauce");
            loginSteps.user_click_on_login_btn();

            isLoggedIn = true;  // Set flag to avoid logging in again
        }
    }

    @After
    public void tearDownAfterTest(Scenario scenario) {
    ExtentTest test = ExtentReportManager.getTest();

    if (test == null) {
        System.out.println("❌ ERROR: ExtentTest instance is NULL for scenario: " + scenario.getName());
    } else {
        if (scenario.isFailed()) {
            test.fail("❌ Test Failed: " + scenario.getName());
        } else {
            test.pass("✅ Test Passed: " + scenario.getName());
        }
    }

    ExtentReportManager.flushReports();  // Flush the reports
    Log.info("Scenario Completed: " + scenario.getName());
    }
    
    
    @AfterAll
    public static void tearDownAfterAll() { // Close browser after all tests
        if (driver != null) {
            DriverManager.quitDriver();
            driver = null; // Reset driver
        }
    }
}