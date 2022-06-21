package com.crm.vtigerTY.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtigerTY.genericUtilities.WebDriverUtility;

public class VtigerCreateOrganizationPage extends WebDriverUtility
{
	// declaration
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement organizationNameTextField;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropdown;

	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDropdown;

	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupRadioBtn;

	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement assignedToDropdown;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// initialization
	public VtigerCreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// utilization
	public void getOrganizationNameTextField(String organizationName)
	{
		organizationNameTextField.sendKeys(organizationName);
	}
	public void getIndustryDropdown(WebElement element,String visibleText)
	{
		selectDropDownVisibleText(element, visibleText);
	}
	public void getTypeDropdown(WebElement element,String visibleText)
	{
		selectDropDownVisibleText(element, visibleText);
	}
	public void getGroupRadioBtn()
	{
		groupRadioBtn.click();
	}
	public void getAssignedToDropdown(WebElement element,String visibleText)
	{
		selectDropDownVisibleText(element, visibleText);
	}
	public void getSaveBtn()
	{
		saveBtn.click();
	}

	public void createOrganization(String organizationName,String industryText,String typeText,String groupText )
	{
		organizationNameTextField.sendKeys(organizationName);
		selectDropDownVisibleText(industryDropdown, industryText);
		selectDropDownVisibleText(typeDropdown, typeText);
		groupRadioBtn.click();
		selectDropDownVisibleText(assignedToDropdown, groupText);
		saveBtn.click();
	}
}
