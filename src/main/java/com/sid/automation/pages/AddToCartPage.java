package com.sid.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sid.automation.base.BaseClass;

public class AddToCartPage extends BaseClass{

     @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement backPackProduct;
    
    @FindBy(id = "add-to-cart")
    private WebElement AddToCartBtn;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

     public AddToCartPage() {
        super(); // calls BaseClass constructor
        PageFactory.initElements(driver, this);
    }
    public void clickOnProduct(){
        click(backPackProduct);
    }
    public void clickOnAddToCartBtn(){
        click(AddToCartBtn);
    }
    public void clickOnCartIcon(){
        click(cartIcon);
    }

}
