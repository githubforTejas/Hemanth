package com.crm.vtigerTY.contacts;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtigerTY.genericUtilities.BaseClass;
import com.crm.vtigerTY.objectRepository.VtigerContactPage;
import com.crm.vtigerTY.objectRepository.VtigerHomePage;

//@Listeners(com.crm.vtigerTY.genericUtilities.ListenerImp.class)
public class SelectLastViewedContactAndLogoutTest extends BaseClass{
	@Test(groups ="smoke" )
	public void selectLastViewContactLogout() throws Throwable 
	{
		VtigerHomePage homePage=new VtigerHomePage(driver);
		homePage.getContactLink();
		VtigerContactPage contactPage = new VtigerContactPage(driver);
		contactPage.getLastViewedLUImg();
		String value = contactPage.getLastViewedText();
		SoftAssert sas=new SoftAssert();
		sas.assertNotNull(value);
		Reporter.log("test case is pass",true);
		sas.assertAll();
	}
}
