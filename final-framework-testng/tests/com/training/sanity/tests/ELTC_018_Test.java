package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_018_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_018_Test {

	private WebDriver driver;
	private String baseUrl;
	private ELTC_018_POM ELTC_018_POM;
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
		ELTC_018_POM = new ELTC_018_POM(driver); 
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
		//I am using my login details for this script. My user name is "sujub" and PW is "ABCDEF1@4"
		screenShot.captureScreenShot("ELTC_018_1");
		ELTC_018_POM.sendUserName("sujub");
		ELTC_018_POM.sendPassword("ABCDEF1@4");		
		screenShot.captureScreenShot("ELTC_018_2");
		ELTC_018_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("ELTC_018_3");
		ELTC_018_POM.clickProf();
		screenShot.captureScreenShot("ELTC_018_4");
		ELTC_018_POM.sendPassW("ABCDEF1@4");
		screenShot.captureScreenShot("ELTC_018_5");
		ELTC_018_POM.sendPassN("ABCDEF1@5");
		screenShot.captureScreenShot("ELTC_018_6");
		ELTC_018_POM.sendPassC("ABCDEF1@5");
		screenShot.captureScreenShot("ELTC_018_7");
		ELTC_018_POM.clickSave();
		screenShot.captureScreenShot("ELTC_018_8");
		
		boolean eleUpdate = driver.findElement(By.xpath("//div[@class='alert alert-info']")).isDisplayed();
	    Assert.assertTrue(eleUpdate);
	    System.out.println("Your new profile has been saved message should get displayed " + eleUpdate);
		
	}	
}