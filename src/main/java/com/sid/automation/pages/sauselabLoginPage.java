package com.sid.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sid.automation.base.BaseClass;

public class sauselabLoginPage extends BaseClass{
     @FindBy(id = "user-name")
    private WebElement usernamefieldElement;
    
    @FindBy(id = "password")
    private WebElement passwordfieldElement;

    @FindBy(id = "login-button")
    private WebElement loginbtn;


    public sauselabLoginPage() {
        super(); // calls BaseClass constructor
        PageFactory.initElements(driver, this);
    }
    public void entercredentials(String username, String password){
        sendKeys(usernamefieldElement, username);
        sendKeys(passwordfieldElement, password);
    }
    public void clickLoginBtn(){
        click(loginbtn);

    }
}
