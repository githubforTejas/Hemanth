package com.crm.vtigerTY.organization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Reporter;

import com.crm.vtigerTY.genericUtilities.BaseClass;
import com.crm.vtigerTY.objectRepository.VtigerCreateOrganizationPage;
import com.crm.vtigerTY.objectRepository.VtigerHomePage;
import com.crm.vtigerTY.objectRepository.VtigerOrganizationInfoPage;
import com.crm.vtigerTY.objectRepository.VtigerOrganizationPage;
//@Listeners(com.crm.vtigerTY.genericUtilities.ListenerImp.class)
public class CreateOrganizationWithDropdownTest extends BaseClass{
	@Test(groups = "system")
	public void createOrganizationWithDropdowns() throws Throwable 
	{
	// to get random number
		// hiiiii
		int random = jutil.getRandomNumber();

	// Fetch the data's from Excel
		String organizationName = eutil.getExcelData("organization", 1, 2)+random;
		String industryName = eutil.getExcelData("organization", 1, 3);
		String typeName = eutil.getExcelData("organization", 1, 4);
		String groupName = eutil.getExcelData("organization", 1, 5);

	// Click on organization link
		VtigerHomePage homePage = new VtigerHomePage(driver);
		homePage.getOrganizationLink();

	// click on org lookup img
		VtigerOrganizationPage orgPage = new VtigerOrganizationPage(driver);
		orgPage.getCreateNewOrganizationLUImg();

	// Create organization
		VtigerCreateOrganizationPage newOrgPage = new VtigerCreateOrganizationPage(driver);
		newOrgPage.createOrganization(organizationName, industryName, typeName, groupName);
	// verify and sign out of application
		VtigerOrganizationInfoPage orgInfoPage = new VtigerOrganizationInfoPage(driver);	
		String actualOrganizationName = orgInfoPage.getActualOrganizationName();
		Assert.assertEquals(actualOrganizationName, organizationName);
			Reporter.log("organization created and Test case is pass",true);
		
	}
}
