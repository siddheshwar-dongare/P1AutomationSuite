package com.sid.automation.runners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sid.automation.utils.Reporting.ExtentReportListerns;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Test
@Listeners(ExtentReportListerns.class)
@CucumberOptions(
    features = "src/test/resources/features",  // Update this path
    glue = {"com.sid.automation.stepdefinitions"},
    plugin = { "pretty", "html:target/cucumber-reports" },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests{
    
}
