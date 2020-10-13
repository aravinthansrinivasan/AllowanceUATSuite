package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.BaseClass.TestBase;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;

public class LoginPageTest extends TestBase
{	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		initialization();
		Log.info("Application Launched Successfully");
		
		loginPage = new LoginPage();
	}
	
		
	@Test(priority=1, enabled=true)
	public void VerifyNavigationToLoginPage()
	{
		String title = loginPage.getLoginPageName();
		Assert.assertEquals(title, "Aravin Test Employee Allowance Form", "Login Page Title is not Matched");
		Log.info("Login Page Title Verified");
	}
	
	
	@Test(priority=2, enabled=true)
	public void VerifyLoginSuccessWithValidCredentials()
	{
		loginPage.sendKeysToUserName("admin");
		loginPage.sendKeysToPassword("Te$t1234");
		loginPage.clickLogin();
		Assert.assertEquals(loginPage.getLoginPageName(), "Aravin Test Employee Allowance Form", "Login Page Title is not Matched");
		Log.info("Successfull Login Verified");
	}
	
	@Test(priority=3, enabled=true)
	public void VerifyLoginfailwithInvalidCredentials()
	{
		loginPage.sendKeysToUserName("admin");
		loginPage.sendKeysToPassword("Te$t1234");
		Assert.assertEquals(loginPage.getLoginPageName(), "Aravin Test Employee", "Login Success with Invalid Credentials");
		Log.info("Login with invalid credenatials Verified");
	}
	
	
	@Test(priority=4, enabled=true) 
	public void VerifyUserAbleToNavigateToAllowanceSubmitPage()
	{
		loginPage.sendKeysToUserName("admin");
		loginPage.sendKeysToPassword("Te$t1234");
		loginPage.clickLogin();
		loginPage.clickSubmitClaim();
		Assert.assertEquals(loginPage.getTextSubmitClaimPageHeader(), "WORKING IN NIGHT SHIFTS", "Navigated to Claim Submit Page");
		Log.info("Navigation to Submit Claim Page");
	}
	
	@Test(priority=5, enabled=true) 
	public void VerifyUserAbleToSuccessfullySubmitClaim()
	{
		loginPage.sendKeysToUserName("admin");
		loginPage.sendKeysToPassword("Te$t1234");
		loginPage.clickLogin();
		loginPage.clickSubmitClaim();
		loginPage.sendKeysToEmpName("Arav");
		loginPage.sendKeysToApprover("Manger");
		loginPage.sendKeysToEmpId("2101");
		loginPage.sendKeysToProject("GS");
		loginPage.sendKeysToAllowance1("1");
		loginPage.sendKeysToSprintNumber("7");
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.getTextSuccessClaimSubmit(), "Record Successfully Submitted", "Claim Submitted Successfully");
		Log.info("Navigation to Submit Claim Page");
	}
	
	
	@Test(priority=6, enabled=true) 
	public void VerifyClaimNotSubmittedOnNotFillingMandatoryFeilds()
	{
		loginPage.sendKeysToUserName("admin");
		loginPage.sendKeysToPassword("Te$t1234");
		loginPage.clickLogin();
		loginPage.clickSubmitClaim();
		loginPage.sendKeysToEmpName("Arav");
		loginPage.sendKeysToApprover("Manger");
		loginPage.sendKeysToSprintNumber("7");
		loginPage.ClickSubmitButton();
		Assert.assertNotEquals(loginPage.getTextSuccessClaimSubmit(), "Record Successfully Submitted", "Claim Submitted Even if mandatory fields are not entered");
		Log.info("Navigation to Submit Claim Page");
	}
}
