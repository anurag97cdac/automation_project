package com.sdet.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {
    public static String captureScreenShot(String testname){
        //Implement logic to capture screenshot and return the path of the saved screenshot
        WebDriver driver = DriverFactory.getDriver();
        //create Date Time Formatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        //Get currrent date and time
        String dateTime = LocalDateTime.now().format(dtf);
        //Use Selenium's TakesScreenshot interface to capture the screenshot
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String dirPath = "test-output/screenshots";
        //Create aunique Screenshot name
        String screenShotName = testname + "_" + dateTime + "_T" + Thread.currentThread().getId();
        String path = dirPath + "/" + screenShotName +".png";
        try {
            //Create the directory if it doesn't exist
            Files.createDirectories(Paths.get(dirPath));
            Files.copy(srcFile.toPath(), Paths.get(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "screenshots/" + screenShotName +".png"; // Placeholder return statement
    }
}
