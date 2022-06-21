package com.crm.vtigerTY.organization;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtigerTY.genericUtilities.BaseClass;
import com.crm.vtigerTY.objectRepository.VtigerContactPage;
import com.crm.vtigerTY.objectRepository.VtigerCreateContactPage;
import com.crm.vtigerTY.objectRepository.VtigerCreateOrganizationPage;
import com.crm.vtigerTY.objectRepository.VtigerHomePage;
import com.crm.vtigerTY.objectRepository.VtigerOrganizationInfoPage;
import com.crm.vtigerTY.objectRepository.VtigerOrganizationPage;
//@Listeners(com.crm.vtigerTY.genericUtilities.ListenerImp.class)
public class CreateOrganizationWithContactTest extends BaseClass{
	@Test(groups = "smoke")
	public void createOranizationAndContactsAndVerify() throws Throwable 
	{
	// to get random number
		int random = jutil.getRandomNumber();

	// Fetch the data's from Excel
		String organizationName = eutil.getExcelData("organization", 1, 2)+random;
		String firstName = eutil.getExcelData("contact", 1, 3)+random;
		String lastName = eutil.getExcelData("contact", 1, 4)+random;
		String contactNumber = eutil.getNumericalData("contact", 1, 6);
		String salutationTxt = eutil.getExcelData("contact", 1, 2);

	// Create organization
		VtigerHomePage homePage = new VtigerHomePage(driver);
		homePage.getOrganizationLink();

	// click on org lookup img
		VtigerOrganizationPage orgPage = new VtigerOrganizationPage(driver);
		orgPage.getCreateNewOrganizationLUImg();

	// Create organization
		VtigerCreateOrganizationPage newOrgPage = new VtigerCreateOrganizationPage(driver);
		newOrgPage.getOrganizationNameTextField(organizationName);
		newOrgPage.getSaveBtn();
	// verify organization is created 
		VtigerOrganizationInfoPage orgInfoPage = new VtigerOrganizationInfoPage(driver);
		String actualOrganizationName = orgInfoPage.getActualOrganizationName();
		Assert.assertEquals(actualOrganizationName, organizationName);
			System.out.println("organization created");
	// click on contact link
		homePage.getContactLink();
	// click on create new contact look up image	
		VtigerContactPage contactPage = new VtigerContactPage(driver);
		contactPage.getCreateContactLUImg();

	// enter the details and click on save	
		VtigerCreateContactPage createNewContactPage = new VtigerCreateContactPage(driver);
		createNewContactPage.getSalutationTypeDropdown(salutationTxt);
		createNewContactPage.getFirstName(firstName);
		createNewContactPage.getLastName(lastName);
		createNewContactPage.getMobileTextEdit(contactNumber);
		createNewContactPage.getSaveBtn();
	// verify contact is created 
		String actualContactName = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText().toString();
		Assert.assertEquals(actualContactName, firstName);
		
		Reporter.log("Contact is created and Test case is pass",true);	
	}	
}
