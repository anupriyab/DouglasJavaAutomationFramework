package com.douglas.testcases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.douglas.pages.HomePage;
import com.douglas.pages.Parfum;
import com.douglas.testcases.*;
import com.douglas.utils.DataProviders;
import com.douglas.utils.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;


public class searchTest extends BaseTestclass{
	HomePage homepage;
	Parfum parfumPage;
	ExcelReader reader;

	@Test(priority = 1, description = "Precondition:  Open browser,Navigate to the Douglas URL")
	public void Step01_NavigetessToURL() throws Exception {
		System.out.println("step 1 begin");
		homepage= new HomePage(driver);
		homepage.navigateToHomePage();
		System.out.println("Successfully navigated to application URL");
	}

	@Test(priority = 2, description = "Denying all the cookies")
	public void Step02_HandlingCookies() throws Exception {
		System.out.println("step 2 begin");
		homepage.handleCookies();
		System.out.println("Denied all the cookies");
	}
	@Test(priority = 3, description = "Navigating to Parfum page")
	public void Step03_ClikonParfum() throws Exception {
		System.out.println("step 3 begin");
		homepage.clickOnParfum();
		System.out.println("parfum is clicked");
	}


	@Test(priority = 4, description = "moving to highlight fliter")
	public void Step03_viewHighlight() throws Exception {
		System.out.println("step 3 begin");
		parfumPage= new Parfum(driver);
		parfumPage.viewHighlight();
		System.out.println("moved to highlight fliter");
	}


	@Test(priority = 5, description = "selecting the fliters based on excel data",dataProvider = "excelData", dataProviderClass = DataProviders.class)
	public void testWithExcelData(String highlights, String marke, String produktart, String geschenkFur, String furWen) throws InterruptedException {

		parfumPage.selectHighlight(highlights);
		parfumPage.selectgeschenk(geschenkFur);
		parfumPage.selectfurWen(furWen);
		parfumPage.selectProdukart(produktart);
		parfumPage.selectMarke(marke);
		Thread.sleep(4000);
		parfumPage.restoreFliter();
		Thread.sleep(2000);
		


	}

}





