package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_017_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_017_Test {

	private WebDriver driver;
	private String baseUrl;
	private ELTC_017_POM ELTC_017_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		ELTC_017_POM = new ELTC_017_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		boolean eleAvailableU = driver.findElement(By.id("login")).isDisplayed();
	    Assert.assertTrue(eleAvailableU);
	    System.out.println("User name text box is appearing " + eleAvailableU);
	    
	    boolean eleAvailableP = driver.findElement(By.id("password")).isDisplayed();
	    Assert.assertTrue(eleAvailableP);
	    System.out.println("Passsword text box is appearing " + eleAvailableP);
	    
	    boolean view = driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).isDisplayed();
	    Assert.assertTrue(view);
	    System.out.println("Login Button should appear " + view);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		//I have used 'ADMIN' user name and password only for LOGIN and LOGOUT.
		//I have created my own user name and password, which will use only for update or delete purpose.
		screenShot.captureScreenShot("ELTC_017_1");
		ELTC_017_POM.sendUserName("admin");
		ELTC_017_POM.sendPassword("admin@123");		
		screenShot.captureScreenShot("ELTC_017_2");
		ELTC_017_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("ELTC_017_3");			
		
		boolean eleAdmin = driver.findElement(By.xpath("//a[@title='Administration']")).isDisplayed();
	    Assert.assertTrue(eleAdmin);
	    System.out.println("Admin home page should get displayed " + eleAdmin);
		
		
	}	
}