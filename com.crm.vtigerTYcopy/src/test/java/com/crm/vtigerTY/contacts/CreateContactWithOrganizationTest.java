package com.crm.vtigerTY.contacts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtigerTY.genericUtilities.BaseClass;
import com.crm.vtigerTY.objectRepository.VtigerContactInfoPage;
import com.crm.vtigerTY.objectRepository.VtigerContactPage;
import com.crm.vtigerTY.objectRepository.VtigerCreateContactPage;
import com.crm.vtigerTY.objectRepository.VtigerHomePage;
//@Listeners(com.crm.vtigerTY.genericUtilities.ListenerImp.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	@Test(groups = "system")
	public void createContactWithOrganization() throws Throwable 
	{
		
	// to get random number
		int random = jutil.getRandomNumber();
		
	// Fetch the data's from Excel
		String firstName = eutil.getExcelData("contact", 1, 3)+random;
		String lastName = eutil.getExcelData("contact", 1, 4)+random;
		String contactNumber = eutil.getNumericalData("contact", 1, 6);
		String salutationTxt = eutil.getExcelData("contact", 1, 2);
		String indropdownTxt = eutil.getExcelData("contact", 1, 5);

	// get parent window 
			String parentWindow = driver.getWindowHandle();
			
	// click on contact link
			VtigerHomePage homePage = new VtigerHomePage(driver);
			homePage.getContactLink();
			
	// click on create new contact look up image	
			VtigerContactPage contactPage = new VtigerContactPage(driver);
			contactPage.getCreateContactLUImg();
			
	// enter the details ,select organization and click on save	
			VtigerCreateContactPage createNewContactPage = new VtigerCreateContactPage(driver);
			createNewContactPage.getSalutationTypeDropdown(salutationTxt);
			createNewContactPage.getFirstName(firstName);
			createNewContactPage.getLastName(lastName);
			createNewContactPage.getSelectOrgLUImg();
			wutil.switchToWindow(driver, parentWindow);
			createNewContactPage.getSearchTextEdit("TestYantra");
			createNewContactPage.getInDropdown(indropdownTxt);
			createNewContactPage.getSearchBtn();		
			wutil.switchBackToParentWindow(driver, parentWindow);
			createNewContactPage.getMobileTextEdit(contactNumber);
			createNewContactPage.getSaveBtn();
		 
    // verify contact is created 
			VtigerContactInfoPage contactInfo = new VtigerContactInfoPage(driver);
			String actualContactName = contactInfo.getFirstName();
			assertEquals(actualContactName, firstName);
			System.out.println("Contact is created with organization and Test case is pass");						
	}
}
