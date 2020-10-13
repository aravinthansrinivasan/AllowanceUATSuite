package com.crm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.BaseClass.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath = "//td[contains(text(),'User: Pavan Reddy')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
}