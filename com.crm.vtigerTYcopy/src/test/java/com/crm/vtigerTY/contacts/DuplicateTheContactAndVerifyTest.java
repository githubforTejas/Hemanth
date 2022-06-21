package com.crm.vtigerTY.contacts;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtigerTY.genericUtilities.BaseClass;
import com.crm.vtigerTY.objectRepository.VtigerContactInfoPage;
import com.crm.vtigerTY.objectRepository.VtigerContactPage;
import com.crm.vtigerTY.objectRepository.VtigerDuplicateContactInfoPage;
import com.crm.vtigerTY.objectRepository.VtigerHomePage;
//@Listeners(com.crm.vtigerTY.genericUtilities.ListenerImp.class)
public class DuplicateTheContactAndVerifyTest extends BaseClass{
	@Test(groups = "smoke")
	public void selectDuplicateContact() throws Throwable 
	{
	// click on contact link
		VtigerHomePage homePage = new VtigerHomePage(driver);
		homePage.getContactLink();	

	// Select a contact and duplicate the contact		

		VtigerContactPage contactPage = new VtigerContactPage(driver);
		String contactName = contactPage.getCreatedContactText();
		contactPage.getCreatedContactLink();
		VtigerContactInfoPage contactInfoPage = new VtigerContactInfoPage(driver);
		contactInfoPage.clickDuplicateBtn();
		VtigerDuplicateContactInfoPage save=new VtigerDuplicateContactInfoPage(driver);
		save.getSaveBtn();

	// verify contact is created 
		String actualContactName = contactInfoPage.getFirstName();
		System.out.println(actualContactName);
		System.out.println(contactName);
		SoftAssert sas = new SoftAssert();
		sas.assertEquals(actualContactName, contactName);
		Reporter.log("Contact is created and Test case is pass",true);	
		sas.assertAll();
	}
}
