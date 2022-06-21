package com.crm.vtigerTY.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtigerTY.genericUtilities.WebDriverUtility;

public class VtigerHomePage extends WebDriverUtility
{
	// declaration
	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationLink;

	@FindBy(xpath = "//a[@href='index.php?module=Calendar&action=index']")
	private WebElement calenderLink;

	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactLink;

	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement productLink;

	@FindBy(xpath = "//a[.='More']")
	private WebElement moreLink;
	
	@FindBy(xpath = "//a[@name='Purchase Order']")
	private WebElement purchaseOrderLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorLookUpImage;

	@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")
	private WebElement signoutlink;

	// initialization
	public VtigerHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// utilization
	public void getOrganizationLink()
	{
		organizationLink.click();
	}

	public void getCalenderLink() {
		calenderLink.click();
	}

	public void getContactLink() {
		contactLink.click();
	}

	public void getProductLink() {
	    productLink.click();
	}

	public void getMoreLink() {
		moreLink.click();
	}
	
	public void getPurchaseOrderLink()
	{
		purchaseOrderLink.click();
	}
	
	public void getAdministratorLookUpImage() {
		administratorLookUpImage.click();;
	}

	public void getSignoutlink() {
		signoutlink.click();
	}

	// business libraries
	public void signoutAppk(WebDriver driver)
	{
		mouseOverAnElement(driver, administratorLookUpImage);
		signoutlink.click();
	}
}
