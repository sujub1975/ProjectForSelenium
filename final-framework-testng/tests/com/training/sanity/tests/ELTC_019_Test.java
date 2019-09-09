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
import com.training.pom.ELTC_019_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_019_Test {

	private WebDriver driver;
	private String baseUrl;
	private ELTC_019_POM ELTC_019_POM;
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
		ELTC_019_POM = new ELTC_019_POM(driver); 
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
		screenShot.captureScreenShot("ELTC_019_1");
		ELTC_019_POM.sendUserName("admin");
		ELTC_019_POM.sendPassword("admin@123");		
		screenShot.captureScreenShot("ELTC_019_2");
		ELTC_019_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("ELTC_019_3");
		ELTC_019_POM.clickAdm();
		screenShot.captureScreenShot("ELTC_019_4");
		ELTC_019_POM.clickUlist();
		screenShot.captureScreenShot("ELTC_019_5");
		ELTC_019_POM.clickUEdit();
		screenShot.captureScreenShot("ELTC_019_6");	
		
		boolean userInfo = driver.findElement(By.xpath("//legend[contains(text(),'Edit user information')]")).isDisplayed();
	    Assert.assertTrue(userInfo);
	    System.out.println("Edit user information screen is appearing " + userInfo);
		
	}	
}