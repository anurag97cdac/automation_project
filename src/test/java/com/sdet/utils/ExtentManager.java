package com.sdet.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {
    
    protected static ExtentReports extent;


    public static ExtentReports getInstance() {
        if(extent ==  null){
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            sparkReporter.config().setCss("");
            sparkReporter.config().setJs("");
            sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
            sparkReporter.config().setOfflineMode(true);
            sparkReporter.config().setReportName("Automation Report");
            sparkReporter.config().setDocumentTitle("Test Results");  
            sparkReporter.config().setEncoding("utf-8");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }

        return extent;

    }




}
