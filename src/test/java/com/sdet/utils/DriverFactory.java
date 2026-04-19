package com.sdet.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser){
        
        switch (browser.toLowerCase()){
            case "chrome":
                //Initialize Chrome Driver
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                //initialize firefox Driver
                driver.set(new FirefoxDriver());
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public void quitdriver(){
        driver.get().quit();
        driver.remove();
    }

}
