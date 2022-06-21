package com.crm.vtigerTY.contacts;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtigerTY.genericUtilities.BaseClass;
import com.crm.vtigerTY.objectRepository.VtigerContactInfoPage;
import com.crm.vtigerTY.objectRepository.VtigerContactPage;
import com.crm.vtigerTY.objectRepository.VtigerHomePage;

//@Listeners(com.crm.vtigerTY.genericUtilities.ListenerImp.class)
public class EditContactAndVerifyTest extends BaseClass 
{
	@Test(groups = "system")
	public void editContactAndVerify() throws Throwable 
	{
	// to get random number
		int random = jutil.getRandomNumber();
		
	// Fetch the data's from Excel
		String editedName = eutil.getExcelData("contact", 1, 11)+random;

	// click on contact link
					VtigerHomePage homePage = new VtigerHomePage(driver);
					homePage.getContactLink();
							
	// click on edit contact
			VtigerContactPage contactPage = new	VtigerContactPage(driver);
					contactPage.getCreatedContactLink();
					
	// edit the contact and save
					VtigerContactInfoPage contactInfoPage = new VtigerContactInfoPage(driver);
					contactInfoPage.mouseOverToName(driver);
					contactInfoPage.clickOnEdit();
					contactInfoPage.getUpdateNameTxtEditAndSave(editedName);
				
	// get screenshot of updated contact
			wutil.takeScreenShot(driver, editedName);
				
   // verify contact is edited 			
				String edited = contactInfoPage.getFirstName();
				SoftAssert sas=new SoftAssert();
				sas.assertEquals(edited, editedName);
				Reporter.log("Contact is created and Test case is pass",true);	
				sas.assertAll();
	}

}
