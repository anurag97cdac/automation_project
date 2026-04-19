package com.sdet.base;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sdet.utils.ConfigReader;
import com.sdet.utils.DriverFactory;
import com.sdet.utils.ExtentManager;
import com.sdet.utils.ScreenShotUtil;

public class BaseTest {
    
     ConfigReader configReader = new ConfigReader();
    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> testreport = new ThreadLocal<>();

    @BeforeSuite
    public void startReport(){
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(Method method,String browser){
        String url = configReader.getProperty("baseurl");
        
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get(url);

        //Create test in Report
        testreport.set(extent.createTest(method.getName()));


        System.out.println("Launching browser: " + browser);
        System.out.println("Opening URL: " + url);
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenShotUtil.captureScreenShot(result.getName());
            testreport.get().fail(result.getThrowable());
            testreport.get().addScreenCaptureFromPath(path);
        }else if(result.getStatus() == ITestResult.SUCCESS){
            testreport.get().pass("Test Passed");
        }

        DriverFactory.getDriver().quit();
    }

    @AfterSuite
    public void endReport(){
        extent.flush();
    }
}

