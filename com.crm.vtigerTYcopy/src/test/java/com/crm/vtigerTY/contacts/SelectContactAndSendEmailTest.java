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
public class SelectContactAndSendEmailTest extends BaseClass {
	@Test(groups = "system")
	public void selectOneContactSendEmail() throws Throwable 
	{
		// click on contact link
		VtigerHomePage homePage = new VtigerHomePage(driver);
		homePage.getContactLink();
		String parentWindow = driver.getWindowHandle();

		// click on created contact
		VtigerContactPage contactPage = new VtigerContactPage(driver);
		contactPage.getCreatedContactLink();
		// click on send Mail	
		VtigerContactInfoPage contactInfoPage = new VtigerContactInfoPage(driver);
		contactInfoPage.clickOnSendMail();
		// un check email check box ,click on secondary check box and click on select
		contactInfoPage.sendMail();

		// verify compose mail page is displayed
		wutil.switchToWindow(driver, parentWindow);
		String title = driver.getTitle();
		SoftAssert  sas=new SoftAssert();
		sas.assertNotEquals(title, parentWindow);
		Reporter.log("compose page is displayed",true);
		// switch back to parent window
		wutil.switchBackToParentWindow(driver, parentWindow);
		sas.assertAll();
	}
}
