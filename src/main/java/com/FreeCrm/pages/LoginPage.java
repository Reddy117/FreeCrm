package com.FreeCrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FreeCrm.testbase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	public WebElement UserName;
	
	@FindBy(name="password")
	public WebElement Password;
	
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement Loginbtn;
	
	@FindBy(xpath="//img[@classs='img-responsive']")
	public WebElement CrmLogo;
	
	@FindBy(xpath="//div[@class='intercom-borderless-dismiss-button']")
	public WebElement noborderfrm;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public String getpagesourse(){
		return driver.getPageSource();
	}
	
	public void closenoborderframe() {
		try{
			driver.findElement(By.name("intercom-borderless-frame"));
			driver.switchTo().frame("intercom-borderless-frame");
			Actions a=new Actions(driver);
			a.moveToElement(noborderfrm).build().perform();
			noborderfrm.click();
			driver.switchTo().defaultContent();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public HomePage login(String Uname,String password){
		UserName.sendKeys(Uname);
		Password.sendKeys(password);
		Loginbtn.click();
		return new HomePage();
		
	}
	
	public void closeapp(){
		driver.quit();
	}

}
