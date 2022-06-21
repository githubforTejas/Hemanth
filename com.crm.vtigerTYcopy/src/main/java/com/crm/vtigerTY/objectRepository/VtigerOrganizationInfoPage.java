package com.crm.vtigerTY.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOrganizationInfoPage {
	// declaration
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement organizationName;

	// initialization
	public VtigerOrganizationInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// utilization
	public String getActualOrganizationName()
	{
		String actualName = organizationName.getText().toString();
		return actualName;
	}
}
