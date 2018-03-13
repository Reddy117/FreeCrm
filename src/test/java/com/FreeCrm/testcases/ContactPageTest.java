package com.FreeCrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCrm.pages.ContactsPage;
import com.FreeCrm.pages.HomePage;
import com.FreeCrm.pages.LoginPage;
import com.FreeCrm.testbase.TestBase;

public class ContactPageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactpage;
	
	@BeforeMethod
	public void openApp(){
		initializeApp();
		loginpage=new LoginPage();
		homepage=new HomePage();
		contactpage=new ContactsPage();
		
	}
	
	@AfterMethod
	public void Teardown(){
		loginpage=homepage.Logout();
		loginpage.closeapp();
		
	}
	
	@Test
	public void createNewContactandverify() throws InterruptedException{
		loginpage.closenoborderframe();
		homepage=loginpage.login(Config.getProperty("Uname"), Config.getProperty("Password"));
		contactpage=homepage.clickNewContact();
		contactpage.createNewcontact("Thor","Rangakok");
		contactpage=homepage.clickContacts();
		String actcont=contactpage.getContact("Thor Rangakok");
		Assert.assertEquals(actcont, "Thor Rangakok");
		contactpage.checkanddeletecontact("Thor Rangakok");
		
	}
	


}
