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
import com.training.pom.ELTC_020_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_020_Test {

	private WebDriver driver;
	private String baseUrl;
	private ELTC_020_POM ELTC_020_POM;
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
		ELTC_020_POM = new ELTC_020_POM(driver); 
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
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/
	
	@Test
	public void validLoginTest(){
		//I have used 'ADMIN' user name and password only for LOGIN and LOGOUT.
		//I have created my own user name and password, which will use only for update or delete purpose.
		//Before use this script DELETE the record "sujay101" from the "USER LIST" section.
		screenShot.captureScreenShot("ELTC_020_1");
		ELTC_020_POM.sendUserName("admin");
		ELTC_020_POM.sendPassword("admin@123");		
		screenShot.captureScreenShot("ELTC_020_2");
		ELTC_020_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("ELTC_020_3");
		ELTC_020_POM.clickAdm();
		screenShot.captureScreenShot("ELTC_020_4");
		ELTC_020_POM.clickAddU();
		screenShot.captureScreenShot("ELTC_020_5");	
		ELTC_020_POM.sendfName("sujay101");
		screenShot.captureScreenShot("ELTC_020_6");
		ELTC_020_POM.sendlName("Bhattacharjee101");
		screenShot.captureScreenShot("ELTC_020_7");
		ELTC_020_POM.sendMail("suju.b19751@gmail.com");
		screenShot.captureScreenShot("ELTC_020_8");
		ELTC_020_POM.sendPhone("9800181289");
		screenShot.captureScreenShot("ELTC_020_9");
		ELTC_020_POM.sendlogUser("sujayb1");
		screenShot.captureScreenShot("ELTC_020_10");
		ELTC_020_POM.clickePassOpt();
		screenShot.captureScreenShot("ELTC_020_11");
		ELTC_020_POM.sendPassword("sujay201981");
		screenShot.captureScreenShot("ELTC_020_12");
		//Thread.sleep(1000);
		//Start - Code for Bootstrap Drop-down value select	
		ELTC_020_POM.clickeDrop();
		screenShot.captureScreenShot("ELTC_020_13");
		ELTC_020_POM.clickDropVal();	
		screenShot.captureScreenShot("ELTC_020_14");
		//End - Code for Bootstrap Drop-down value select		
		ELTC_020_POM.clickbtnSubmit();
		screenShot.captureScreenShot("ELTC_020_15");
				
		boolean usrAlart = driver.findElement(By.xpath("//div[@class='alert alert-info']")).isDisplayed();
	    Assert.assertTrue(usrAlart);
	    System.out.println("User added successfully!! " + usrAlart);
		
		driver.quit();
	}		
}
