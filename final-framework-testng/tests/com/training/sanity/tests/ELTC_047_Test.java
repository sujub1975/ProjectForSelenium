package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_047_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_047_Test {

	private static WebDriver driver;
	private static String baseUrl;
	private static ELTC_047_POM ELTC_047_POM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		ELTC_047_POM = new ELTC_047_POM(driver); 
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
	
	//*******This part is responsible for Login*******
	
	@Test (priority = 1) 
	public void validLoginTest()
	{
		//I have used 'ADMIN' user name and password only for LOGIN and LOGOUT.
		//I have created my own user name and password, which will use only for update or delete purpose.
		//Before use this script DELETE the existing record. Login as Admin and click on Administration menu.
		//Click on Courses categories. List of Courses categories should appear. Delete the name as 
		screenShot.captureScreenShot("ELTC_047_1");
		ELTC_047_POM.sendUserName("boiju1");
		ELTC_047_POM.sendPassword("Password1");		
		screenShot.captureScreenShot("ELTC_047_2");
		ELTC_047_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("ELTC_047_3");
	}
	
	//*******This part is responsible for Add Category*******
		
		@Test (priority = 2) 
		public void createCoursesCategoriesTest()
	{		
		ELTC_047_POM.clickAdm();
		screenShot.captureScreenShot("ELTC_047_4");
		ELTC_047_POM.addCourse();
		screenShot.captureScreenShot("ELTC_047_5");	
		ELTC_047_POM.addCategory();
		screenShot.captureScreenShot("ELTC_047_6");
		ELTC_047_POM.addCourCatCode1("RPA");
		screenShot.captureScreenShot("ELTC_047_7");
		ELTC_047_POM.addCourCatName1("Robotic Process Automation");
		screenShot.captureScreenShot("ELTC_047_8");
		ELTC_047_POM.addCourCatYes1();
		screenShot.captureScreenShot("ELTC_047_9");
		ELTC_047_POM.btnAddCat1();
		screenShot.captureScreenShot("ELTC_047_10");
				
		boolean eleCreated = driver.findElement(By.xpath("//div[@class='alert alert-info']")).isDisplayed();
	    Assert.assertTrue(eleCreated);
	    System.out.println("Course category is created " + eleCreated);
	}
		
		//*******This part is responsible for Create a Course*******
		
		@Test (dependsOnMethods = "createCoursesCategoriesTest") 
		public void createACoursesTest()
	{			    
		ELTC_047_POM.clickAdmLink1();
		screenShot.captureScreenShot("ELTC_047_11");
		ELTC_047_POM.clkCreateCour1();
		screenShot.captureScreenShot("ELTC_047_12");		
		
		boolean eleCreateCour = driver.findElement(By.xpath("//legend[contains(text(),'Create a course')]")).isDisplayed();
	    Assert.assertTrue(eleCreateCour);
	    System.out.println("Create a course page is opened " + eleCreateCour);	    
	    		
	    ELTC_047_POM.txtTitle1("Robotic Part 1");
		screenShot.captureScreenShot("ELTC_047_13");	
		ELTC_047_POM.txtCode1("RPA1");
		screenShot.captureScreenShot("ELTC_047_14");			
		
		//Start - Code for Bootstrap Drop-down value select	
		ELTC_047_POM.clkCateDrop1();
		screenShot.captureScreenShot("ELTC_047_15");
		ELTC_047_POM.selRAPCate1();	
		screenShot.captureScreenShot("ELTC_047_16");
		//End - Code for Bootstrap Drop-down value select		
				
		ELTC_047_POM.clkLanguage1();
		screenShot.captureScreenShot("ELTC_047_17");
		ELTC_047_POM.seleLanguageEng1();
		screenShot.captureScreenShot("ELTC_047_18");		  
		
		ELTC_047_POM.btnCreateCour1();
		screenShot.captureScreenShot("ELTC_047_19");
				
		boolean usrAlart = driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
	    Assert.assertTrue(usrAlart);
	    System.out.println("Course added successfully!! " + usrAlart);
		
		driver.quit();
		//driver.close();
	}		
}
