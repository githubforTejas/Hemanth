package com.crm.vtigerTY.genericUtilities;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Hemanth
 *
 */
public class WebDriverUtility {
	/**
	 *It will wait for 10 seconds till the page gets loaded 
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * It will wait for JS elements
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	/**
	 * it will check for the elements in the GUI for polling time of 500ms
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * here we can change the polling time from default 500ms to any polling time
	 * @param driver
	 * @param element
	 * @param pollingTime
	 */
	public void waitForTitleContains(WebDriver driver,WebElement element,int pollingTime)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * here we are giving custom time out
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable
	{
		int count=0;
		while (count<10)
		{
			try 
			{
				element.click();
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * used to switch from one window to another window
	 * @param driver
	 * @param partialWindow
	 */
	public void switchToWindow(WebDriver driver,String partialWindow)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wTle = it.next();
			driver.switchTo().window(wTle);
			String currentWindow = driver.getTitle();
			if (currentWindow.contains(partialWindow)) 
			{
				break;	
			}
		}		
	}
	/**
	 * switch back to parent window
	 * @param driver
	 * @param parentWindow
	 */
	public void switchBackToParentWindow(WebDriver driver,String parentWindow)
	{
		driver.switchTo().window(parentWindow);
	}
	/**
	 * switch from one frame to another frame by using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * switch from one frame to another frame by using id_attribute
	 * @param driver
	 * @param id_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_attribute)
	{
		driver.switchTo().frame(id_attribute);
	}
	/**
	 * switch from one frame to another frame by using absolute_path
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * switch from one frame to immediate parent frame
	 * @param driver
	 */
	public void switchBackToImmediateParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * switch from one frame to main frame
	 * @param driver
	 */
	public void switchBackToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * to switch to alert popup
	 * @param driver
	 */
	public void switchToAlertPopUp(WebDriver driver) 
	{
	driver.switchTo().alert();	
	}
	/**
	 * its used to switch to alert popup and accept
	 * @param driver
	 */
	public void switchToAlertPopUpAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * its used to switch to alert popup and dismiss
	 * @param driver
	 */
	public void switchToAlertPopUpAnddismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * it is used to select dropdown by using index 
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 *it is used to select dropdown by using value 
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * it is used to select dropdown by using visible text
	 * @param element
	 * @param visible_text
	 */
	public void selectDropDownVisibleText(WebElement element,String visible_text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visible_text);
	}
	/**
	 * it is used to move over an element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAnElement(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * it is used to move over an element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAnElementAndClick(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	/**
	 * it is used right click on a element 
	 * @param element
	 * @param driver
	 */
	public void rightClickOnTheElement(WebElement element,WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.contextClick().perform();	
	}
	/**
	 * it is used to click on enter button using keyboard actions
	 * @param driver
	 */
	public void clickOnEnterButton(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * it is used to take screen shot
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable
	 */
	public void takeScreenShot(WebDriver driver,String screenShotName) throws Throwable 
	{
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File(IPathConstant.screenshotpath+screenShotName+".png");
		Files.copy(src, dst);
	}
	/**
	 * it is used to perform scroll bar Action
	 * @param driver
	 */
	public void scrollBarActions(WebDriver driver)
	{
		JavascriptExecutor javaScript = (JavascriptExecutor) driver;
		javaScript.executeScript("window.scrollBy(0,500)");
	}
	/**
	 * to upload file
	 * @param element
	 */
	public void fileUploadPopup(WebElement element)
	{
		element.sendKeys("C:\\Users\\heman\\OneDrive\\Desktop\\240445_Friends.jpg");
	}
}
