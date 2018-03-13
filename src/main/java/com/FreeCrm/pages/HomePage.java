package com.FreeCrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCrm.testbase.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: Reddy Anish')]")
	public WebElement HomeUserName;
	
	@FindBy(xpath="//a[@title='Contacts']")
	public WebElement contactslink;
	
	@FindBy(xpath="//a[@title='Deals']")
	public WebElement Dealslink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	public WebElement NewContact;
	
	@FindBy(xpath="//a[@class='topnavlink']")
	public WebElement logout;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String getUser(){
		driver.switchTo().frame("mainpanel");
		String HUser=HomeUserName.getText();
		driver.switchTo().defaultContent();
		return HUser;
	}
	
	public ContactsPage clickContacts(){
		driver.switchTo().frame("mainpanel");
		contactslink.click();
		driver.switchTo().defaultContent();
		return new ContactsPage();
		
	}
	
	public ContactsPage clickNewContact(){
		driver.switchTo().frame("mainpanel");
		Actions a=new Actions(driver);
		a.moveToElement(contactslink).build().perform();
		NewContact.click();
		driver.switchTo().defaultContent();
		return new ContactsPage();
	}

	public DealsPage clickDeals(){
		driver.switchTo().frame("mainpanel");
		contactslink.click();
		driver.switchTo().defaultContent();
		return new DealsPage();
	}
	
	public LoginPage Logout(){
		driver.switchTo().frame("mainpanel");
		logout.click();
		driver.switchTo().defaultContent();
		return new LoginPage();
	}
}
