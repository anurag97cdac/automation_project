package com.sdet.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sdet.Pages.LoginPage;
import com.sdet.base.BaseTest;
import com.sdet.utils.DataProviderUtil;
import com.sdet.utils.DriverFactory;

public class LoginTest extends BaseTest{

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUtil.class)
    public void loginLogoutTest(Map<String,Object> data){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        String userName  = data.get("username").toString();
        String password = data.get("password").toString();
        String actions = data.get("action").toString();
        String expected = data.get("expectedResult").toString();

        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String message = loginPage.getMessage();
        System.out.println("Login message: " + message+"1");
        Assert.assertTrue(message.trim().contains(expected.trim()), "Message Mismatch (login)");

        // if (actions.equalsIgnoreCase("logout")) {
        //     loginPage.clickLogin();
        //     loginPage.clickLogout();
        //     String logOutMessage = loginPage.getMessage();
        //     System.out.println("Logout message: " + logOutMessage+"2");
        //     Assert.assertEquals(
        //         logOutMessage.trim().replaceAll("\\s+", " ").toLowerCase(),
        //         expected.trim().replaceAll("\\s+", " ").toLowerCase(),
        //         "Message Mismatch (logout)"
        //     );
        // }
        if (actions.equalsIgnoreCase("Invalid Login")) {
            String invalidLogin = loginPage.getMessage();
            System.out.println("Invalid Login message: " + invalidLogin+"3");
            Assert.assertTrue(message.trim().contains(expected.trim()), "Message Mismatch (login)");
        }
    }
    
}
