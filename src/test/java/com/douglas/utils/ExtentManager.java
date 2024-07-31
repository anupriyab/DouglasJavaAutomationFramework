package com.douglas.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	 private static ExtentReports extent;
	    private static ExtentSparkReporter htmlReporter;
	    private static String reportFilePath = "target/ExtentReport.html";

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            extent = new ExtentReports();
	            htmlReporter = new ExtentSparkReporter(reportFilePath);
	            htmlReporter.config().setDocumentTitle("Automation Report");
	            htmlReporter.config().setReportName("Automation Test Results");
	            htmlReporter.config().setTheme(Theme.STANDARD);
	            extent.attachReporter(htmlReporter);
	        }
	        return extent;
	    }

	    public static ExtentTest createTest(String testName, String testDescription) {
	        return extent.createTest(testName, testDescription);
	    }

	    public static void flush() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }

}
