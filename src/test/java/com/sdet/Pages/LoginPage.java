package com.sdet.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "[type='submit']")
    WebElement loginButton;

    @FindBy(id = "flash")
    WebElement message;

    @FindBy(xpath = "//i[text()=' Logout']")
    WebElement logoutButton;

    public void enterUserName(String user){
        username.sendKeys(user);
    }

    public void enterPassword(String pass){
        password.sendKeys(pass);
    }
    
    public void clickLogin(){
        loginButton.click();
    }

    public String getMessage(){
        return message.getText();
    }

    public void clickLogout(){
        logoutButton.click();
    }

    public String getLogoutMessage(){
        return message.getText();
    }

    public String getInvalidMessage(){
        return message.getText();
    }


}
