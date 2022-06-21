package com.crm.vtigerTY.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerDuplicateContactInfoPage {
	@FindBy(xpath = "//td[@class='showPanelBg']//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public VtigerDuplicateContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getSaveBtn()
	{
		saveBtn.click();
	}
}
