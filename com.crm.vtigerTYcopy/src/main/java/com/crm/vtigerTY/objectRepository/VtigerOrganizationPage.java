package com.crm.vtigerTY.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtigerTY.genericUtilities.WebDriverUtility;

public class VtigerOrganizationPage extends WebDriverUtility
{
	// declaration
		@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createNewOrganizationLUImg;
		
		@FindBy(xpath = "//table[@class='lvt small']//td[3]/a")
		private WebElement organizationRecordsTable;
		
		@FindBy(xpath = "//input[@class='txtBox']")
		private WebElement organizationSearchField;
		
		@FindBy(xpath = "//select[@name='search_field']")
		private WebElement inDropdown;
		
		@FindBy(xpath = "//input[@value=' Search Now ']")
		private WebElement searchBtn;
		
		// initialization
		public VtigerOrganizationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public void getCreateNewOrganizationLUImg() 
		{
			createNewOrganizationLUImg.click();
		}

		public String getOrganizationRecordsTable() 
		{
			String value = organizationRecordsTable.getText().toString();
			return value;
		}

		public void getOrganizationSearchField(String searchForName) 
		{
			organizationSearchField.sendKeys(searchForName);
		}

		public void getInDropdown(WebElement element,String visibleText) 
		{
			selectDropDownVisibleText(element, visibleText);
		}

		public void getSearchBtn() 
		{
			searchBtn.click();
		}
}
