package com.training.sanity.tests;

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
import com.training.pom.ELTC_049_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_049_Test {

	private static WebDriver driver;
	private static String baseUrl;
	private static ELTC_049_POM ELTC_049_POM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		ELTC_049_POM = new ELTC_049_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);	
		
		//WebDriverWait waitlist=new WebDriverWait(driver, 20);
		
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
		screenShot.captureScreenShot("ELTC_049_1");
		ELTC_049_POM.sendUserName("boiju1");
		ELTC_049_POM.sendPassword("Password1");		
		screenShot.captureScreenShot("ELTC_049_2");
		ELTC_049_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("ELTC_049_3");
	}
	
	//*******This part is responsible for Add Classes*******
		
		@Test (priority = 2) 
		public void addClassTest()
	{		
		ELTC_049_POM.clickAdm();
		screenShot.captureScreenShot("ELTC_049_4");
		ELTC_049_POM.clickClassesLink();
		screenShot.captureScreenShot("ELTC_049_5");	
		
		boolean eleAddClass = driver.findElement(By.xpath("//li[@class='active']")).isDisplayed();
	    Assert.assertTrue(eleAddClass);
	    System.out.println("List of existing classes are appearing " + eleAddClass);
	    
	    WebDriverWait waitlist=new WebDriverWait(driver, 40);
	    waitlist.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-paging-info']")));
	    
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	    screenShot.captureScreenShot("ELTC_049_6");
	   
	    ELTC_049_POM.clickClassIcon();
	    screenShot.captureScreenShot("ELTC_049_7");
	    
		boolean eleAddClass1 = driver.findElement(By.xpath("//legend[contains(text(),'Add')]")).isDisplayed();
	    Assert.assertTrue(eleAddClass1);
	    System.out.println("Add class screen is appearing to add new class " + eleAddClass1);
	    
		ELTC_049_POM.sendclassName("RPA Automation");
		screenShot.captureScreenShot("ELTC_049_8");
		
		ELTC_049_POM.sendclassDescriotion("Push your automated business processes to new heights with RPA.");
		screenShot.captureScreenShot("ELTC_049_9");
		
		//Start - Code for Bootstrap Drop-down value select	
		ELTC_049_POM.clickGroupPermissions();
		screenShot.captureScreenShot("ELTC_049_10");
		ELTC_049_POM.selectGroupPermissions();	
		screenShot.captureScreenShot("ELTC_049_11");
		//End - Code for Bootstrap Drop-down value select
		
		ELTC_049_POM.clickAddBtn();
		screenShot.captureScreenShot("ELTC_049_12");

		boolean eleAddClass2 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
	    Assert.assertTrue(eleAddClass2);
	    System.out.println("Class is added successfully. " + eleAddClass2);	
	}
		
		//*******This part is responsible for Subscribe users to class*******
		
		@Test (priority = 3) 
		public void SubscribeUsers()
		{
			ELTC_049_POM.clickSubscribeUsersIcon();
			screenShot.captureScreenShot("ELTC_049_13");			
						
			boolean eleSubscribeUsers = driver.findElement(By.xpath("//legend[contains(text(),'Subscribe users to class: RPA Automation')]")).isDisplayed();
		    Assert.assertTrue(eleSubscribeUsers);
		    System.out.println("Subscribe users to class screen is appearing " + eleSubscribeUsers);
		    
		    
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
		    
		    /*ELTC_049_POM.SelectUser();
		    screenShot.captureScreenShot("ELTC_049_18");
		    
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,1000)");
		    
		    ELTC_049_POM.SelectCourse();
		    screenShot.captureScreenShot("ELTC_049_19");*/
		    
		    //driver.findElement(By.xpath("/html/body/main/section/div/form[2]/table/tbody/tr[2]/td[3]/select")).click();
		    //--driver.findElement(By.xpath("/html/body/main/section/div/form[2]/table/tbody/tr[2]/td[3]/select/option[41]")).click();
		    //screenShot.captureScreenShot("ELTC_048_20");
		    
		    /*ELTC_049_POM.clickAddtobtn1();
		    screenShot.captureScreenShot("ELTC_049_20");
		    
		    boolean eleUserCourse = driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
		    Assert.assertTrue(eleUserCourse);
		    System.out.println("User is subscribed to the selected course " + eleUserCourse);*/
		  
		        
			driver.quit();
			//driver.close();
			
			
		}	
}
