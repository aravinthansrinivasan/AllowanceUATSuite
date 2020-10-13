package com.crm.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.BaseClass.TestBase;

public class LoginPage extends TestBase 
{
	@FindBy(id="ContentPlaceHolder1_username")
	WebElement username;
	
	@FindBy(id="ContentPlaceHolder1_password")
	WebElement password;
	
	@FindBy(id="ContentPlaceHolder1_LoginButton") 
	WebElement loginButton;
	
	@FindBy(id="submitclaim") 
	WebElement submitclaim;
	
	@FindBy(xpath="//*[@id='form1']/div[3]/nav/a/h4") 
	WebElement loginPageName;
		
	@FindBy(xpath="//*[@id='form1']/div[4]/div[1]/div[1]/div/h3") 
	WebElement SubmitClaimPageHeader;
	
	@FindBy(id="ContentPlaceHolder1_name") 
	WebElement empName;
	
	@FindBy(id="ContentPlaceHolder1_empid") 
	WebElement empId;
	
	@FindBy(id="ContentPlaceHolder1_project") 
	WebElement project;
	
	@FindBy(id="ContentPlaceHolder1_approver") 
	WebElement approver;
	
	@FindBy(id="ContentPlaceHolder1_Sprintno") 
	WebElement sprintNo;
	
	@FindBy(id="ContentPlaceHolder1_allow1") 
	WebElement allowance1;
	
	
	@FindBy(xpath="//*[@id='form1']/div[6]/div/input") 
	WebElement submitButton;
	
	

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageName()
	{
		return loginPageName.getText();
	}
	
	
	public void sendKeysToUserName(String value) {
		username.sendKeys(value);
	}
	
	public void sendKeysToPassword(String value) {
		password.sendKeys(value);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void clickSubmitClaim() {
		submitclaim.click();
	}
	
	public String getTextSubmitClaimPageHeader()
	{
		return SubmitClaimPageHeader.getText();
	}
	
	
	public String getTextSuccessClaimSubmit()
	{
		return driver.switchTo().alert().getText();
	}
	
	
	public void sendKeysToEmpName(String value) {
		empName.sendKeys(value);
	}
	
	
	public void sendKeysToEmpId(String value) {
		empId.sendKeys(value);
	}
	
	
	public void sendKeysToProject(String value) {
		project.sendKeys(value);
	}
	
	
	public void sendKeysToApprover(String value) {
		approver.sendKeys(value);
	}
	
	
	public void sendKeysToAllowance1(String value) {
		allowance1.sendKeys(value);
	}
	
	public void sendKeysToSprintNumber(String value) {
		sprintNo.sendKeys(value);
	}
	
	public void ClickSubmitButton() {
		submitButton.click();
	}
	
	public HomePage login(String uname, String pword)
	{
		username.sendKeys(uname);
		password.sendKeys(pword);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginButton);
				
		return new HomePage();
	}
}

