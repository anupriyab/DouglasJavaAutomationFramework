package com.douglas.guiActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuiActions {


	private static WebDriver driver;

	/* Method name: clickButton
	 * Parameters: webelement,By,webdriver
	 * Description:This performs click action on element
	 * Author:Anupriya
	 * 
	 */
	public static void clickButton(WebElement fieldBy,WebDriver driver ) {
		Duration timeout=Duration.ofSeconds(15L);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element1 = (WebElement)wait.until(ExpectedConditions.elementToBeClickable(fieldBy));
		element1.click();
	}


	/* Method name: explicitWait
	 * Parameters:  webdriver
	 * Description:This performs explicit wait for an page loading to complete
	 * Author:Anupriya
	 * 
	 */
	public static void explicitWait( WebDriver driver)
	{
		Duration duration=Duration.ofSeconds(150);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		// Wait for a JavaScript variable to be set to true
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return js.executeScript("return document.readyState").toString().equals("complete");
			}
		});

	}

	/* Method name: enterText
	 * Parameters: webelement, webdriver,string
	 * Description:This performs enters a text to the textbox.
	 * Author:Anupriya
	 * 
	 */
	public static void enterText(WebElement ele, WebDriver driver, String txt)
	{
		ele.sendKeys(txt);

		System.out.println(" entering text into   textbox");
	}


	/* Method name: scrollintoView
	 * Parameters: webelement, webdriver
	 * Description:This method scrolls till the element visible
	 * Author:Anupriya
	 * 
	 */
	public static void scrollIntoViewIfNeeded(WebElement ele, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", ele);



	}

	/* Method name: scrollBy
	 * Parameters: webelement, webdriver
	 * Description:This method scrolls till the element visible
	 * Author:Anupriya
	 * 
	 */
	public static void scrollBy( WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");


	}

	/*Method name:mouseHover
	 *Parameters:Webelement,driver
	 *Description: This method is for hovering the element
	 *Author:Anupriya
	 * 
	 */
	public static void mouseHover( WebDriver driver)
	{
		Actions act =new Actions(driver);
		Actions action=new Actions(driver);
		action.moveByOffset(46,54).click().build().perform();	
	}

}

