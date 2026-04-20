package com.sdet.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {
    public static String captureScreenShot(String testname){
        //Implement logic to capture screenshot and return the path of the saved screenshot
        WebDriver driver = DriverFactory.getDriver();
        //Use Selenium's TakesScreenshot interface to capture the screenshot
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String dirPath = "screenshots";
        String screenShotName = testname + "_" + System.currentTimeMillis() + "_T" + Thread.currentThread().getId();
        String path = dirPath + "/" + screenShotName +".png";
        try {
            //Create the directory if it doesn't exist
            Files.createDirectories(Paths.get(dirPath));
            Files.copy(srcFile.toPath(), Paths.get(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return path; // Placeholder return statement
    }
}
