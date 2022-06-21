package com.crm.vtigerTY.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.vtigerTY.objectRepository.VtigerHomePage;
import com.crm.vtigerTY.objectRepository.VtigerLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver sdriver;
	public WebDriver driver;
	public	DataBaseUtility dutil=new DataBaseUtility();
	public	ExcelUtility eutil=new ExcelUtility();
	public	FileUtility futil=new FileUtility();
	public	JavaUtility jutil=new JavaUtility();
	public	WebDriverUtility wutil=new WebDriverUtility();

	/**
	 * connect to the database
	 */
 @BeforeSuite(groups = {"smoke","system"})
	public void connectToDatabase()
	{
		dutil.connectToDatabase();
	}

	/**
	 * launch the browser
	 * @throws Throwable
	 */
	//@Parameters("Browser")
	@BeforeClass(groups = {"smoke","system"})
	public void launchBrowser() throws Throwable
	{
		String Browser = futil.getPropertyKeyValue("browser");
		String Url=futil.getPropertyKeyValue("url");
		if (Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		sdriver=driver;
		wutil.waitForPageToLoad(driver);
		sdriver.get(Url);
		driver.manage().window().maximize();
	}

	/**
	 * login to application
	 * @throws Throwable
	 */
	@BeforeMethod(groups = {"smoke","system"})
	public void loginToApplication() throws Throwable
	{
		String Username = futil.getPropertyKeyValue("username");
		String Password=futil.getPropertyKeyValue("password");
		VtigerLoginPage loginPage=new VtigerLoginPage(driver);
		loginPage.loginToAppk(Username , Password);
	}

	/**
	 * Sign out off application
	 */
	@AfterMethod(groups = {"smoke","system"})
	public void LogoutOffApplication()
	{
		VtigerHomePage homePage=new VtigerHomePage(driver);
		homePage.signoutAppk(driver);
	}

	/**
	 * close the browser
	 */
	@AfterClass(groups = {"smoke","system"})
	public void closeTheBrowser()
	{
		driver.quit();
	}

	/**
	 * close the database
	 */
	@AfterSuite(groups = {"smoke","system"})
	public void closeTheDatabase()
	{
		dutil.closeTheDatabase();
	}
}
