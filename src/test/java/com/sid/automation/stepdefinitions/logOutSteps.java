package com.sid.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sid.automation.driver.DriverManager;
import com.sid.automation.pages.LogOutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logOutSteps {
     private WebDriver driver = DriverManager.getDriver();
    private LogOutPage LogOutPage = new LogOutPage();

    @Given("user is logged in")
    public void User_is_logged_in() {
        LogOutPage.clickOnMenuBtn();
    }

    @When("user click on logout button")
    public void user_click_on_logout_btn() {
        LogOutPage.clickLogOutBtn();
    }
     @Then("User is logged out from application")
    public void user_logged_out_successfuly() throws InterruptedException {
        // Add proper verification
        Thread.sleep(3000);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assert.assertTrue(pageTitle.contains("Swag Labs"), 
            "Search results page not displayed");
    }
}
