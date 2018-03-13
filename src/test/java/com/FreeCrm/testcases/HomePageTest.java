package com.FreeCrm.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCrm.pages.ContactsPage;
import com.FreeCrm.pages.HomePage;
import com.FreeCrm.pages.LoginPage;
import com.FreeCrm.testbase.TestBase;

public class HomePageTest extends TestBase{
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactpage;
	String fName="Test";
	String lName="Test";
	
	@BeforeMethod
	public void openApp(){
		initializeApp();
		loginpage=new LoginPage();
		homepage=new HomePage();
		contactpage=new ContactsPage();
		
	}
	
	@Test
	public void verifyHomepageUser(){
		loginpage.closenoborderframe();
		homepage=loginpage.login(Config.getProperty("Uname"), Config.getProperty("Password"));
		String actUser=homepage.getUser();
		//Assert.assertEquals(actUser, "Reddy Anish");
		Assert.assertTrue(actUser.contains("Reddy Anish"));
	}
	
	
	

}
