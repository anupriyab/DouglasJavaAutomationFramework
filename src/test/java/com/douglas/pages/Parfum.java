package com.douglas.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.douglas.guiActions.GuiActions;

public class Parfum {

	protected WebDriver driver;
	//-----------------Locators------------------------------------------	
	@FindBy(xpath = "//div[contains(text(),'Produktart')]")
	WebElement produktart;

	@FindBy(css = "div[class='facet-option__label'] div")
	WebElement produktartOption;

	@FindBy(xpath = "//div[contains(text(),'Marke')]")
	WebElement marke;

	@FindBy(css = "input[placeholder='Produktart suchen']")
	WebElement produkSuchen;

	@FindBy(xpath = "//input[@placeholder='Marke suchen']")
	WebElement markeSuchen;

	@FindBy(xpath = "(//div[normalize-space()='Für Wen'])[1]")
	WebElement furWene;

	@FindBy(xpath = "//div[contains(text(),'Geschenk ')]")
	WebElement geschenkfur;
	@FindBy(xpath = "//input[@placeholder='Geschenk für suchen']")
	WebElement geschenkSuchen;

	@FindBy(xpath = "//div[@class='facet-option__label']//div[contains(text(),'Sale')]")
	WebElement sale;

	@FindBy(xpath = "//div[contains(text(),'Highlights')]")
	WebElement Highlights;
	@FindBy(xpath = "//div[@class='facet-option__label']//div[contains(text(),'NEU')]")
	WebElement neu;

	@FindBy(xpath = "//div[contains(text(),'Limitiert')]")
	WebElement limitert;
	@FindBy(xpath = "//button[normalize-space()='Alle Filter löschen']")
	WebElement AllFliter;

	//------------------------Constructor----------------------------
	public Parfum(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//--------------------------Methods----------------------------------

	/* Method name: restoreFliter
	 * Parameters: NA
	 * Description:This method restores all the fliters
	 * Author:Anupriya
	 * 
	 */


	public void restoreFliter() throws InterruptedException {

		GuiActions.clickButton(AllFliter, driver);
		System.out.println("Restore  the fliter");


	}

	/* Method name: viewHighlight
	 * Parameters: NA
	 * Description:This method moves to highlight filter
	 * Author:Anupriya
	 * 
	 */

	public void viewHighlight() throws InterruptedException
	{
		GuiActions.explicitWait(driver);
		GuiActions.scrollBy(driver);
		Thread.sleep(2000);
		GuiActions.mouseHover( driver);
	}

	/* Method name: selectProdukart
	 * Parameters: productname
	 * Description:This method select Produkart
	 * Author:Anupriya
	 * 
	 */
	public void selectProdukart(String productname) throws InterruptedException {

		GuiActions.clickButton(produktart, driver);
		Thread.sleep(2000);
		GuiActions.enterText(produkSuchen, driver, productname);
		GuiActions.clickButton(produktartOption, driver);
		Thread.sleep(6000);
		System.out.println("clicked produkart");
	}
	/* Method name: selectHighlight
	 * Parameters: Highlight
	 * Description:This method select Highlights
	 * Author:Anupriya
	 * 
	 */

	public void selectHighlight(String Highlight ) throws InterruptedException {

		GuiActions.clickButton(Highlights, driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(!Highlight.equals("Limitiert"))
		{
			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='facet-option__label']//div[contains(text(),'" + Highlight + "')]")));
			element1.click();
			//driver.findElement(By.xpath("//div[@class='facet-option__label']//div[contains(text(),'" + Highlight + "')]")).click();
			GuiActions.explicitWait(driver);
		}
		else
		{
			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + Highlight + "')]")));
			element1.click();
			//driver.findElement(By.xpath("//div[contains(text(),'" + Highlight + "')]")).click();
			GuiActions.explicitWait(driver);

		}
		System.out.println("clicked Highlights");
	}

	/* Method name: selectMarke
	 * Parameters: markes
	 * Description:This method select Marke
	 * Author:Anupriya
	 * 
	 */
	public void selectMarke(String markes ) throws InterruptedException {
		GuiActions.clickButton(marke, driver);
		Thread.sleep(2000);
		GuiActions.enterText(markeSuchen, driver, markes);
		GuiActions.clickButton(produktartOption, driver);
		Thread.sleep(1000);
		System.out.println("clicked Marke");
	}
	/* Method name: selectgeschenk
	 * Parameters: geschenk
	 * Description:This method select geschenk
	 * Author:Anupriya
	 * 
	 */
	public void selectgeschenk(String geschenk ) throws InterruptedException {
		Thread.sleep(6000);
		if(!geschenk.equals("NA"))
		{
			System.out.println("Inside if condition");
			GuiActions.clickButton(geschenkfur, driver);	
			Thread.sleep(2000);
			GuiActions.enterText(geschenkSuchen, driver, geschenk);
			GuiActions.clickButton(produktartOption, driver);
			Thread.sleep(6000);
			System.out.println("clicked geschenkfur");
		}
		else
		{
			System.out.println(" no  value present");
		}
	}
	/* Method name: selectfurWen
	 * Parameters: furwen
	 * Description:This method selectfurWen
	 * Author:Anupriya
	 * 
	 */
	public void selectfurWen(String furwen ) throws InterruptedException {
		Thread.sleep(4000);
		GuiActions.clickButton(furWene, driver);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(text(),'" +furwen+ "')]")).click();
		Thread.sleep(6000);
		System.out.println("clicked furwen");

	}
}
