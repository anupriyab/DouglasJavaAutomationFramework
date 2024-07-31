package com.douglas.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.douglas.utils.*;

public class BaseTestclass {
	protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        driver = BrowserFactorylass.getDriver(browser);
        extent = ExtentManager.getInstance();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }
}

