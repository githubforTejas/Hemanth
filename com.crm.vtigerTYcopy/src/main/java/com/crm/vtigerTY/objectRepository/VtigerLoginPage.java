package com.crm.vtigerTY.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {
	// declaration
	@FindBy(name = "user_name")
	private WebElement usernameTextEdit;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextEdit;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	// initialization
	public VtigerLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilization
	public WebElement getUsernameTextEdit()
	{
		return usernameTextEdit ;
	}

	public WebElement getPasswordTextEdit() {
		return passwordTextEdit;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	// business libraries
	public void loginToAppk(String username, String password)
	{
		usernameTextEdit.sendKeys(username);
		passwordTextEdit.sendKeys(password);
		submitBtn.click();
	}
}
