package com.crm.vtigerTY.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtigerTY.genericUtilities.WebDriverUtility;

public class VtigerContactInfoPage extends WebDriverUtility
{

@FindBy(xpath = "//span[@id='dtlview_First Name']")
private WebElement firstName;

@FindBy(xpath = "//input[@title='Duplicate [Alt+U]']")
private WebElement duplicateBtn;

@FindBy(xpath = "//a[.='Edit']")
private WebElement editLink;

@FindBy(xpath = "//input[@id='txtbox_First Name']")
private WebElement updateNameTxtEdit;

@FindBy(xpath = "//a[.='Send Mail']")
private WebElement sendMailLink;

@FindBy(xpath = "//input[@name='semail']")
private WebElement emailCheckBox;

@FindBy(xpath = "//input[@name='semail' and @value='83']")
private WebElement secondaryCheckBox;

@FindBy(xpath = "//input[@name='Select']")
private WebElement selectButton;

@FindBy(xpath = "//input[@name='button_First Name']")
private WebElement editSaveBtn;

public VtigerContactInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public String getFirstName()
{
	String actualName = firstName.getText().toString();
	return actualName;
}
public void clickDuplicateBtn()
{
	duplicateBtn.click();
}
public void mouseOverToName(WebDriver driver)
{
	mouseOverAnElement(driver, firstName);
}
public void clickOnEdit()
{
	editLink.click();
}
public void clickOnSendMail()
{
	sendMailLink.click();
}
public void getEmailCheckBox() 
{
	emailCheckBox.click();
}

public void getSecondaryCheckBox() 
{
    secondaryCheckBox.click();
}

public void getSelectButton() 
{
	selectButton.click();
}

public void getUpdateNameTxtEditAndSave(String updatedName)
{
	updateNameTxtEdit.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
	updateNameTxtEdit.sendKeys(updatedName);
	editSaveBtn.click();
}
public void sendMail() {
	emailCheckBox.click();
	secondaryCheckBox.click();
	selectButton.click();
}
}
