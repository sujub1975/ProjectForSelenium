package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.LoginDataProviders078;
import com.training.generics.ScreenShot;
import com.training.pom.ELTC_078_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginExcelTest078 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_078_POM ELTC_078_POM;
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
		ELTC_078_POM = new ELTC_078_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);		
	}

	@AfterMethod
	public void tearDown() throws Exception 
	{
		driver.quit();
	}
	
	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders078.class)
	public void checkExcelDataTest(String FirstName, String LastName, String eMail, String UserName, String Pass, String ConPass, String Phone, String Language, String TeachCoursesOption) 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();  
		String s = dtf.format(now);
		
		screenShot.captureScreenShot("ELTC_078_0_"+s);
		
		ELTC_078_POM.clickbtnSignUp();
		screenShot.captureScreenShot("ELTC_078_1_"+s);
		
		ELTC_078_POM.clickoptTeacher();
		screenShot.captureScreenShot("ELTC_078_2_"+s);
		
		ELTC_078_POM.sendFirstName(FirstName);
		screenShot.captureScreenShot("ELTC_078_3_"+s);
		
		ELTC_078_POM.sendSecondName(LastName);
		screenShot.captureScreenShot("ELTC_078_4_"+s);
		
		ELTC_078_POM.sendEmailID(eMail);
		screenShot.captureScreenShot("ELTC_078_5_"+s);
		
		ELTC_078_POM.senduserName(UserName);
		screenShot.captureScreenShot("ELTC_078_6_"+s);
		
		ELTC_078_POM.sendPassword(Pass);
		screenShot.captureScreenShot("ELTC_078_7_"+s);
		
		ELTC_078_POM.sendconfPassword(Phone);
		screenShot.captureScreenShot("ELTC_078_8_"+s);
		
		ELTC_078_POM.sendconfPassword(ConPass);
		screenShot.captureScreenShot("ELTC_078_9_"+s);
				
		ELTC_078_POM.clickbtnRegister();
		screenShot.captureScreenShot("ELTC_078_10_"+s);
	    
	    boolean msgPassed = driver.findElement(By.xpath("//li[@class='active']")).isDisplayed();
	    Assert.assertTrue(msgPassed);
	    System.out.println("Registration successfully screen should display " + msgPassed);  
	    
	    boolean msgPassed1 = driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-12']//p[1]")).isDisplayed();
	    Assert.assertTrue(msgPassed1);
	    System.out.println("Message for user should display " + msgPassed1);  
	    
	    boolean msgPassed2 = driver.findElement(By.xpath("//p[contains(text(),'An e-mail has been sent to remind you of your logi')]")).isDisplayed();
	    Assert.assertTrue(msgPassed2);
	    System.out.println("Email confiramation should display " + msgPassed2);  
	    
	    System.out.println("Pass all above values to the DB and show data from DB");		
		System.out.println(FirstName+"***"+LastName+"***"+eMail+"***"+UserName+"***"+Pass+"***"+ConPass+"***"+Phone+"***"+Language+"***"+TeachCoursesOption);
		
	}

}