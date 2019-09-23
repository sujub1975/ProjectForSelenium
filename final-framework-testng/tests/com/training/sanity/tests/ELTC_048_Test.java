package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_048_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_048_Test {

	private static WebDriver driver;
	private static String baseUrl;
	private static ELTC_048_POM ELTC_048_POM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		ELTC_048_POM = new ELTC_048_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);				
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//int iframesize = 0;
		
		boolean eleAvailableU = driver.findElement(By.id("login")).isDisplayed();
	    Assert.assertTrue(eleAvailableU);
	    System.out.println("User name text box is appearing " + eleAvailableU);
	    
	    boolean eleAvailableP = driver.findElement(By.id("password")).isDisplayed();
	    Assert.assertTrue(eleAvailableP);
	    System.out.println("Passsword text box is appearing " + eleAvailableP);
	    
	    boolean view = driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).isDisplayed();
	    Assert.assertTrue(view);
	    System.out.println("Login button should appear " + view);
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
		screenShot.captureScreenShot("ELTC_048_1");
		ELTC_048_POM.sendUserName("boiju1");
		ELTC_048_POM.sendPassword("Password1");		
		screenShot.captureScreenShot("ELTC_048_2");
		ELTC_048_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("ELTC_048_3");
	}
	
	//*******This part is responsible for Add User*******
		
		@Test (priority = 2) 
		public void createCoursesCategoriesTest()
	{		
		ELTC_048_POM.clickAdm();
		screenShot.captureScreenShot("ELTC_048_4");
		ELTC_048_POM.addUser1();
		screenShot.captureScreenShot("ELTC_048_5");	
		
		boolean eleAddUser = driver.findElement(By.xpath("//legend[contains(text(),'Add a user')]")).isDisplayed();
	    Assert.assertTrue(eleAddUser);
	    System.out.println("Add user screen is appearing to add a new user " + eleAddUser);
	    
	    ELTC_048_POM.sendfName("Sujayb");
		screenShot.captureScreenShot("ELTC_048_6");
		ELTC_048_POM.sendlName("Bhattacharjee");
		screenShot.captureScreenShot("ELTC_048_7");
		ELTC_048_POM.sendMail("suju.b19751@gmail.com");
		screenShot.captureScreenShot("ELTC_048_8");
		ELTC_048_POM.sendPhone("9800111289");
		screenShot.captureScreenShot("ELTC_048_9");
		ELTC_048_POM.sendlogUser("sujayb2019");
		screenShot.captureScreenShot("ELTC_048_10");
		ELTC_048_POM.clickePassOpt();
		screenShot.captureScreenShot("ELTC_048_11");
		ELTC_048_POM.sendPassword("sujay2019X");
		screenShot.captureScreenShot("ELTC_048_12");
		//Thread.sleep(1000);
		//Start - Code for Bootstrap Drop-down value select	
		ELTC_048_POM.clickeDrop();
		screenShot.captureScreenShot("ELTC_048_13");
		ELTC_048_POM.clickDropVal();	
		screenShot.captureScreenShot("ELTC_048_14");
		//End - Code for Bootstrap Drop-down value select		
		ELTC_048_POM.clickbtnSubmit();
		screenShot.captureScreenShot("ELTC_048_15");
				
		boolean usrAlart = driver.findElement(By.xpath("//div[@class='alert alert-info']")).isDisplayed();
	    Assert.assertTrue(usrAlart);
	    System.out.println("User added successfully!! " + usrAlart);		
	}		
		
		//*******This part is responsible for Add users to course*******
		
		@Test (priority = 3) 
		public void addAddUsersToCourse()
		{
			ELTC_048_POM.clickAdm();
			screenShot.captureScreenShot("ELTC_048_16");
			ELTC_048_POM.clickaddUserToCourse();
			screenShot.captureScreenShot("ELTC_048_17");
			
			boolean eleAddUserToCourse = driver.findElement(By.xpath("//legend[contains(text(),'Add users to course')]")).isDisplayed();
		    Assert.assertTrue(eleAddUserToCourse);
		    System.out.println("Add users to course screen is appearing " + eleAddUserToCourse);
		    
		    /*WebElement element = driver.findElement(By.cssSelector("main.section-platform_admin:nth-child(1) div.container form:nth-child(5) table:nth-child(2) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(1)"));
		    Action builder = new Actions(driver);
		    builder.moveToElement(element).perform();		      
		    WebElement dropdown = driver.findElement(By.name("UserList[]"));
		    dropdown.findElement(By.xpath("//option[. = 'angel mark (mark)']")).click();*/
		    
		    //driver.switchTo().frame("Bhattacharjee Sujayb (sujayb2019)").switchTo().frame("Bhattacharjee Sujayb (sujayb2019)");
		    //screenShot.captureScreenShot("ELTC_048_18");
			
		    //int iframesize = driver.findElements(By.tagName("iframe")).size();
		    //System.out.print("Total number of iframe is " + iframesize);
		    
		    //driver.findElement(By.xpath("/html/body/main/section/div/form[2]/table/tbody/tr[2]/td[1]/select")).click();
		    //---driver.findElement(By.xpath("/html/body/main/section/div/form[2]/table/tbody/tr[2]/td[1]/select/option[13]")).click();
		    //driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/select/option[13]")).click();
		    
		    ELTC_048_POM.SelectUser();
		    screenShot.captureScreenShot("ELTC_048_18");
		    
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,1000)");
		    
		    ELTC_048_POM.SelectCourse();
		    screenShot.captureScreenShot("ELTC_048_19");
		    
		    //driver.findElement(By.xpath("/html/body/main/section/div/form[2]/table/tbody/tr[2]/td[3]/select")).click();
		    //--driver.findElement(By.xpath("/html/body/main/section/div/form[2]/table/tbody/tr[2]/td[3]/select/option[41]")).click();
		    //screenShot.captureScreenShot("ELTC_048_20");
		    
		    ELTC_048_POM.clickAddtobtn1();
		    screenShot.captureScreenShot("ELTC_048_20");
		    
		    boolean eleUserCourse = driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
		    Assert.assertTrue(eleUserCourse);
		    System.out.println("User is subscribed to the selected course " + eleUserCourse);
		  
		        
			driver.quit();
			//driver.close();
			
			
		}		
}
