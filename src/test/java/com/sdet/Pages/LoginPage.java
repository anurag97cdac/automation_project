package com.sdet.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    
    // private WaitUtils waitUtil;
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        // this.waitUtil = new WaitUtils(driver);
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


    // public void login(String user, String pass){
    //     // waitUtil.waitForVisiblity(username).sendKeys(user);
    //     // waitUtil.waitForVisiblity(password).sendKeys(pass);
    //     // waitUtil.waitForClickable(loginButton).click();

    //     username.sendKeys(user);
    //     password.sendKeys(pass);
    //     loginButton.click();

    // }

    public void enterUserName(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }
    public String getMessage(){
        // return waitUtil.waitForVisiblity(flashMessage).getText().trim();
        return flashMessage.getText().trim();
    }





}
