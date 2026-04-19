package com.sdet.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sdet.Pages.LoginPage;
import com.sdet.base.BaseTest;
import com.sdet.utils.DriverFactory;

public class LoginTest extends BaseTest{

    @Test
    public void loginLogoutTest(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();
        String message = loginPage.getMessage();
        System.out.println("Login message: " + message);
        Assert.assertTrue(message.contains("You logged into a secure area!"));
        loginPage.clickLogout();
        String logOutMessage = loginPage.getLogoutMessage();
        System.out.println("Logout message: " + logOutMessage);
        Assert.assertTrue(logOutMessage.contains("You logged out of the secure area!"));
    }
    @Test
    public void invalidLoginTest(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("InvalidPassword!");
        loginPage.clickLogin();
        String invalidLoginMessage = loginPage.getInvalidMessage();
        System.out.println("Invalid login message: " + invalidLoginMessage);
        Assert.assertTrue(invalidLoginMessage.contains("Your password is invalid!"));
    }
    
}
