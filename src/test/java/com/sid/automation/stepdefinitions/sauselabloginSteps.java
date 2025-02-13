package com.sid.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sid.automation.driver.DriverManager;
import com.sid.automation.pages.sauselabLoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sauselabloginSteps {
    private WebDriver driver = DriverManager.getDriver();
    private sauselabLoginPage sauselabLoginPage = new sauselabLoginPage();

    @Given("user is on sauselab log in page")
    public void i_am_on_sauselab_loginpage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enter {string} and {string} in fields")
    public void user_enter(String username, String password) {
        sauselabLoginPage.entercredentials(username, password);
    }

    @And("user click on log in button")
    public void user_click_on_login_btn(){
        sauselabLoginPage.clickLoginBtn();

    }

    @Then("user is logged in successfully")
    public void user_logged_in_successfuly() throws InterruptedException {
        // Add proper verification
        Thread.sleep(3000);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assert.assertTrue(pageTitle.contains("Swag Labs"), 
            "Search results page not displayed");
    }
}
