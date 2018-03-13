package com.FreeCrm.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCrm.testbase.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//input[@title='New Contact']")
	public WebElement NewContactbtn;
	
	@FindBy(xpath="//*[@id='first_name']")
	public WebElement Fname;
	
	@FindBy(xpath="//*[@id='surname']")
	public WebElement Surname;
	
	@FindBy(xpath="//input[@value='Save']")
	public WebElement savebtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void createNewcontact(String fname,String lname){
		driver.switchTo().frame("mainpanel");
		Fname.sendKeys(fname);
		Surname.sendKeys(lname);
		savebtn.click();
		driver.switchTo().defaultContent();
		
	}
	
	public String getContact(String newcont){
		driver.switchTo().frame("mainpanel");
		String actcontact=driver.findElement(By.xpath("//a[@_name='"+newcont+"']")).getText();
		driver.switchTo().defaultContent();
		return actcontact;
		
	}
	
	public void checkanddeletecontact(String newcont) throws InterruptedException{
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[@_name='"+newcont+"']/preceding::input[1]")).click();
		driver.findElement(By.xpath("//a[@_name='"+newcont+"']/following::i[4]")).click();
		Thread.sleep(3000);
		Alert a=driver.switchTo().alert();
		a.accept();
		driver.switchTo().defaultContent();
	}
	

}
