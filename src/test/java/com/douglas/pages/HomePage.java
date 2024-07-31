package com.douglas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.douglas.guiActions.GuiActions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {


	protected WebDriver driver;
	//-------------Locators--------------------------------------	  
	@FindBy(css = "#usercentrics-root")
	WebElement shadowHost;

	@FindBy(css = "[href='/de/c/parfum/01']")
	WebElement parfum;
	//----------------------Constructor-----------------------------
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//-------------------------------Methods-------------------------------
	/* Method name: navigateToHomePage
	 * Parameters: NA
	 * Description:This method navigates to homepage of application
	 * Author:Anupriya
	 * 
	 */

	public void navigateToHomePage() throws InterruptedException {
		driver.get("https://www.douglas.de/de");
		driver.manage().window().fullscreen();
		Thread.sleep(3000);
	}

	/* Method name: handleCookies
	 * Parameters: NA
	 * Description:This method handles cookies
	 * Author:Anupriya
	 * 
	 */

	public void handleCookies() throws InterruptedException
	{

		Thread.sleep(3000);
		WebElement shadowhost= driver.findElement(By.cssSelector("#usercentrics-root"));
		SearchContext shadowroot= shadowhost.getShadowRoot();		
		WebElement shadowContent=shadowroot.findElement(By.cssSelector(
				"[data-testid='uc-deny-all-button']"));
		GuiActions.clickButton(shadowContent, driver);
		System.out.println("clicked cookie");

	}

	/* Method name: clickOnParfum
	 * Parameters: NA
	 * Description:This method clicks on parfum
	 * Author:Anupriya
	 * 
	 */
	public void clickOnParfum() throws InterruptedException
	{
		GuiActions.clickButton(parfum, driver);
		System.out.println("clicked parfum");
		Thread.sleep(6000);

	}
}
