package com.sid.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sid.automation.driver.DriverManager;
import com.sid.automation.pages.AddToCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addToCartSteps {
     private WebDriver driver = DriverManager.getDriver();
    private AddToCartPage AddToCartPage = new AddToCartPage();

    @Given("user is on product details page")
    public void user_click_on_product_details_page() {
        AddToCartPage.clickOnProduct();
    }

    @When("user click on add to cart button")
    public void user_click_on_add_to_cart_btn() {
        AddToCartPage.clickOnAddToCartBtn();
        AddToCartPage.clickOnCartIcon();
    }
    @Then("product is added oin the cart successfully")
    public void product_is_added_in_cart() throws InterruptedException{
       Thread.sleep(3000);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assert.assertTrue(pageTitle.contains("Swag Labs"), 
            "Search results page not displayed");
    }


}
