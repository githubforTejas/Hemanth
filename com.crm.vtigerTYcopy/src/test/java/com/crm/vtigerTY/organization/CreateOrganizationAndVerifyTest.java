package com.crm.vtigerTY.organization;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtigerTY.genericUtilities.BaseClass;
import com.crm.vtigerTY.objectRepository.VtigerCreateOrganizationPage;
import com.crm.vtigerTY.objectRepository.VtigerHomePage;
import com.crm.vtigerTY.objectRepository.VtigerOrganizationInfoPage;
import com.crm.vtigerTY.objectRepository.VtigerOrganizationPage;
//@Listeners(com.crm.vtigerTY.genericUtilities.ListenerImp.class)
public class CreateOrganizationAndVerifyTest extends BaseClass{
	@Test(groups = "system")
	public void createOrganizationAndVerify() throws Throwable 
	{
	// to get random number
		int random = jutil.getRandomNumber();

	// Fetch the data's from Excel
		String organizationName = eutil.getExcelData("organization", 1, 2)+random;

	// click on organization link
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
			Reporter.log("organization created and Test case is pass",true);
			System.out.println("hi hello bye");
	}
}
