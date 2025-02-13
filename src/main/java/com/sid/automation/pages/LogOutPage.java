package com.sid.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sid.automation.base.BaseClass;

public class LogOutPage extends BaseClass{
     @FindBy(id = "react-burger-menu-btn")
    private WebElement MenuBtnElement;
    
    @FindBy(id = "logout_sidebar_link")
    private WebElement LogOutBtnElement;

       public LogOutPage() {
        super(); // calls BaseClass constructor
        PageFactory.initElements(driver, this);
    }
    public void clickOnMenuBtn(){
        click(MenuBtnElement);
    }
    public void clickLogOutBtn(){
        click(LogOutBtnElement);

    }
}
