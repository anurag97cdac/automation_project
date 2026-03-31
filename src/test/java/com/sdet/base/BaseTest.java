package com.sdet.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import com.sdet.utils.ConfigReader;

public class BaseTest {
    
    ConfigReader configReader = new ConfigReader();

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public WebDriver getDriver(){
        return driver.get();
    }

    @BeforeMethod
    public void setUp(){
        String browser = configReader.getProperty("browser");
        String url = configReader.getProperty("baseurl");
        
        if(browser.equalsIgnoreCase("chrome")){
            // Initialize ChromeDriver
            driver.set(new ChromeDriver());
        }else if(browser.equalsIgnoreCase("firefox")){
            // Initialize FirefoxDriver
            driver.set(new FirefoxDriver());
        }else if(browser.equalsIgnoreCase("edge")){
            // Initialize EdgeDriver
            driver.set(new EdgeDriver());
        }else{
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        getDriver().manage().window().maximize();
        getDriver().get(url);
        System.out.println("Launching browser: " + browser);
        System.out.println("Opening URL: " + url);
    }

    @AfterMethod
    public void tearDown(){
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}

