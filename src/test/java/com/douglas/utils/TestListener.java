package com.douglas.utils;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

	public class TestListener implements ITestListener {
	    private ExtentReports extent = ExtentManager.getInstance();
	    private ExtentTest test;

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.pass("Test passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.fail(result.getThrowable());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.skip(result.getThrowable());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        ExtentManager.flush();
	    }
}
