package com.training.sanity.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_050_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_050_Test {

	private static WebDriver driver;
	private static String baseUrl;
	private static ELTC_050_POM ELTC_050_POM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		ELTC_050_POM = new ELTC_050_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
//		 open the browser 
		driver.get(baseUrl);	
		
//		WebDriverWait waitlist=new WebDriverWait(driver, 20);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
				
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
	
//	@AfterMethod
//	public void tearDown() throws Exception {
//		Thread.sleep(1000);
//		driver.quit();
//	}
	
//	*******This part is responsible for Login*******
	
	@Test (priority = 1) 
	public void validLoginTest()
	{
//		I have used 'ADMIN' user name and password only for LOGIN and LOGOUT.
//		I have created my own user name and password, which will use only for update or delete purpose.
//		Before use this script DELETE the existing record. Login as Admin and click on Administration menu.
//		Click on Courses categories. List of Courses categories should appear. Delete the name as 
		screenShot.captureScreenShot("ELTC_050_1");
		ELTC_050_POM.sendUserName("boiju1");
		ELTC_050_POM.sendPassword("Password1");		
		screenShot.captureScreenShot("ELTC_050_2");
		ELTC_050_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("ELTC_050_3");
	}
	
//	*******This part is responsible to Open Add Session page*******
		
		@Test (priority = 2) 
		public void addSessionTest()
	{		
		ELTC_050_POM.clickAdm();
		screenShot.captureScreenShot("ELTC_050_4");		
	    
		ELTC_050_POM.clickAddatrainingsession();
		screenShot.captureScreenShot("ELTC_050_5");	
		
		boolean eleAddTsession = driver.findElement(By.xpath("//legend[contains(text(),'Add a training session')]")).isDisplayed();
	    Assert.assertTrue(eleAddTsession);
	    System.out.println("Add a training session screen is appearing " + eleAddTsession);	    
	}
		
//		*******This part is responsible to insert value in the Add Session screen and save it*******
		
		@Test (priority = 3) 
		public void dataSessionTest() //throws AWTException
		{
			ELTC_050_POM.valueAddSessionName("RPA First Session");
			screenShot.captureScreenShot("ELTC_050_6");	
			
			ELTC_050_POM.selectDropCoach();
			screenShot.captureScreenShot("ELTC_050_7");
			
			ELTC_050_POM.entersearchValue("boi");
			screenShot.captureScreenShot("ELTC_050_8");	
			
			ELTC_050_POM.actualsearchValue("Boiju1 Bhatt1");
			screenShot.captureScreenShot("ELTC_050_9");	
			
			
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//		    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/span/span/span[2]/ul/li"))).click(); 
//		    System.out.print(element + "XXXXXX");
		    
//		    driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")).sendKeys(Keys.ENTER);
		    
//			Actions builder = new Actions(driver);        
//			builder.sendKeys(Keys.ENTER);
			
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(Keys.ENTER);
			
			//driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
			
			//Thread.sleep(1000);
			
//			ELTC_050_POM.clickCoachNameDropdown();
//			screenShot.captureScreenShot("ELTC_050_7");	
//			
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			
//			ELTC_050_POM.enterSearchCoachName("Boiju1 Bhatt1");
//			screenShot.captureScreenShot("ELTC_050_8");	
//			
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			
//			ELTC_050_POM.clickSearchCoachvalue();
//			screenShot.captureScreenShot("ELTC_050_9");					
			
			
			//driver.quit();			
		}	
}
