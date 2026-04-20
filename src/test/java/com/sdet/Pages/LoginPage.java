package com.sdet.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet.utils.WaitUtils;

public class LoginPage {
    
    private WaitUtils waitUtil;
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.waitUtil = new WaitUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "[type='submit']")
    WebElement loginButton;

    @FindBy(id = "flash")
    WebElement flashMessage;

    @FindBy(xpath = "//i[text()=' Logout']")
    WebElement logoutButton;

    public void enterUserName(String user){
        waitUtil.waitForVisiblity(username).sendKeys(user);
    }

    public void enterPassword(String pass){
        waitUtil.waitForVisiblity(password).sendKeys(pass);
    }
    
    public void clickLogin(){
        waitUtil.waitForClickable(loginButton).click();
    }

    public String getMessage(){
        return waitUtil.waitForVisiblity(flashMessage).getText();
    }

    public void clickLogout(){
        logoutButton.click();
    }

    public String getLogoutMessage(){
        return waitUtil.waitForVisiblity(flashMessage).getText();
    }

    public String getInvalidMessage(){
        return waitUtil.waitForVisiblity(flashMessage).getText();
    }


}
