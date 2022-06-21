package com.crm.vtigerTY.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerContactPage
{
	// declaration
		@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createContactLUImg;
		
		@FindBy(xpath = "//span[@vtfieldname='firstname']/preceding-sibling::a")
		private WebElement createdContactLink;
		
		@FindBy(xpath = "//img[@title='Last Viewed']")
		private WebElement lastViewedLUImg;
		
		@FindBy(xpath = "//td[@class='trackerList small']//a")
		private WebElement lastViewedText;

		// initialization
		public VtigerContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//utilization
		public void getCreateContactLUImg() {
			createContactLUImg.click();
		}
		public void getCreatedContactLink()
		{
			createdContactLink.click();
		}
		public String getCreatedContactText()
		{
			String value = createdContactLink.getText().toString();
		return value;
		}
		public void getLastViewedLUImg()
		{
			lastViewedLUImg.click();
		}
		public  String getLastViewedText()
		{
			return lastViewedText.getText() ;
			
		}
}
