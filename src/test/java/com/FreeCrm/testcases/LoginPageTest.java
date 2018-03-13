package com.FreeCrm.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCrm.pages.HomePage;
import com.FreeCrm.pages.LoginPage;
import com.FreeCrm.testbase.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void openApp(){
		initializeApp();
		loginpage=new LoginPage();
		
	}
	
	@Test
	public void verifyLoginpagetitle(){
		String acttitle=loginpage.getTitle();
		Assert.assertEquals("", acttitle);
	}
	
	@Test
	public void verifypagetitleinpagesource() throws InterruptedException{
		//Thread.sleep(20000);
		loginpage.closenoborderframe();
		String pagesrc=loginpage.getpagesourse();
		System.out.println(pagesrc);
		System.out.println("********************");
		String title=loginpage.getTitle();
		System.out.println(title);
		Assert.assertTrue(pagesrc.contains(title));
	}

	@Test
	public void loginTest(){
		loginpage.closenoborderframe();
		homepage=loginpage.login(Config.getProperty("Uname"), Config.getProperty("Password"));
		String homepagesrc=loginpage.getpagesourse();
		
		String hometitle=loginpage.getTitle();
		Assert.assertTrue(homepagesrc.contains(hometitle));
	}
	
	
}
