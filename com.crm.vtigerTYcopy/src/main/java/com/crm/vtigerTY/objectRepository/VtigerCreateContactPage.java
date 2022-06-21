package com.crm.vtigerTY.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtigerTY.genericUtilities.WebDriverUtility;

public class VtigerCreateContactPage extends WebDriverUtility
{

	// declaration
	@FindBy(xpath = "//select[@name='salutationtype']")
	private  WebElement salutationTypeDropdown;

	@FindBy(name = "firstname")
	private WebElement firstNameTxtEdit;

	@FindBy(name = "lastname")
	private WebElement lastNameTxtEdit;

	@FindBy(xpath = "//table[@class='small']//tr[5]//td[2]//img")
	private WebElement selectOrgLUImg;

	@FindBy(xpath = "//input[@name='search_text']" )
	private WebElement searchTextEdit;

	@FindBy(xpath = "//select[@name='search_field']")
	private WebElement inDropdown;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//table[@class='small']//tr[3]//td[1]//a")
	private WebElement createdOrgName;

	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobileTextEdit;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTextEdit;

	@FindBy(xpath = "//input[@name='birthday']")
	private WebElement birthdayTextEdit;

	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement endDateTextEdit;

	//@FindBy(xpath = "//div[@class='calendar']/following-sibling::div[13]//td[.='10']")
	//private WebElement selectDate;

	@FindBy(xpath = "//b[.='Copy Other Address']/preceding-sibling::input")
	private WebElement copyOtherRadioButton;

	@FindBy(xpath = "//b[.='Copy Mailing Address']/preceding-sibling::input")
	private WebElement copyMailingRadioButton;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement chooseFile;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
		
	// initialization

	public VtigerCreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// utilization
	public void getSalutationTypeDropdown(String salutationText) {
		salutationTypeDropdown.click();
		selectDropDown(salutationTypeDropdown, salutationText);
	}

	public void getFirstName(String firstName) {
		firstNameTxtEdit.sendKeys(firstName);
	}

	public void getLastName(String lastName) {
		lastNameTxtEdit.sendKeys(lastName);
	}

	public void getSelectOrgLUImg() {
		selectOrgLUImg.click();
	}
	
	public void getSearchTextEdit(String organizationName ) {
		searchTextEdit.sendKeys(organizationName);
	}

	public void getInDropdown(String inText) {
		inDropdown.click();
		selectDropDownVisibleText(inDropdown, inText);
	}
	public void getSearchBtn()
	{
		searchBtn.click();
	}
	public void getCreatedOrgName() {
		createdOrgName.click();                     
	}

	public void getMobileTextEdit(String mobileNumber) {    
		mobileTextEdit.sendKeys(mobileNumber);;
	}

	public void getEmailTextEdit(String emailId) {
		emailTextEdit.sendKeys(emailId);
	}

	public void getBirthdayTextEdit(String birthdayDate) {
		birthdayTextEdit.sendKeys(birthdayDate);;
	}

	public void getEndDateTextEdit(String endDate) {
		endDateTextEdit.sendKeys(endDate);
	}

	//public WebElement getSelectDate() {
	//	return selectDate;
	//}

	public void getCopyOtherRadioButton() {
		copyOtherRadioButton.click();
	}

	public void getCopyMailingRadioButton() {
		copyMailingRadioButton.click();
	}

	public void getChooseFile() {
		chooseFile.sendKeys("C:\\Users\\heman\\OneDrive\\Desktop\\240445_Friends.jpg");
	}

	public void getSaveBtn()
	{
		saveBtn.click();
	}
}
