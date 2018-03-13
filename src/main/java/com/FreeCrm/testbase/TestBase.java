package com.FreeCrm.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static WebDriver driver;
	public static FileInputStream f=null;
	public static Properties Config=null;
	
	public TestBase() {
		
		try{
			f=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/FreeCrm/config/config.properties");
			Config=new Properties();
			Config.load(f);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void initializeApp(){
		String browser=Config.getProperty("browser");
		if(browser.equals("ff")){
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/com/FreeCrm/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/com/FreeCrm/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(Config.getProperty("url"));
		
	}
	

}
