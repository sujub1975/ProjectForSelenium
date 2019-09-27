package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.LoginDataProviders076;
import com.training.generics.ScreenShot;
import com.training.pom.ELTC_076_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginExcelTest076 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_076_POM ELTC_076_POM;
	private static Properties properties;
	private ScreenShot screenShot;
//	private Date date;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		ELTC_076_POM = new ELTC_076_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);		
	}

	@AfterMethod
	public void tearDown() throws Exception 
	{
		driver.quit();}
	
	
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders076.class)
	public void checkExcelDataTest(String FirstName, String LastName, String eMail, String UserName, String Pass, String ConPass, String Phone) {
//		System.out.println("Pass these values to the input form.");
//		System.out.println("First Name: " + FirstName + "Last Name: "+LastName + "E-Mail: "+eMail + "User Name: "+UserName + "Password: "+Pass + "Confirm Password: "+ConPass + "Phone No.: "+Phone + "Language: "+Language);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();  
		String s = dtf.format(now);
		
		
		screenShot.captureScreenShot("ELTC_076_0_"+s);
		
		ELTC_076_POM.clickbtnSignUp();
		screenShot.captureScreenShot("ELTC_076_1_"+s);
		
		ELTC_076_POM.clickoptTeacher();
		screenShot.captureScreenShot("ELTC_076_2_"+s);
		
		ELTC_076_POM.sendFirstName(FirstName);
		screenShot.captureScreenShot("ELTC_076_3_"+s);
		
		ELTC_076_POM.sendSecondName(LastName);
		screenShot.captureScreenShot("ELTC_076_4_"+s);
		
		ELTC_076_POM.sendEmailID(eMail);
		screenShot.captureScreenShot("ELTC_076_5_"+s);
		
		ELTC_076_POM.senduserName(UserName);
		screenShot.captureScreenShot("ELTC_076_6_"+s);
		
		ELTC_076_POM.sendPassword(Pass);
		screenShot.captureScreenShot("ELTC_076_7_"+s);
		
//		System.out.println("*"+ Pass+"*"+ConPass+"*");
		
//		******I am getting regustration error when execute ConPass code run from in this position.******
//		ELTC_076_POM.sendconfPassword(ConPass);
//		screenShot.captureScreenShot("ELTC_076_8");			
		
		ELTC_076_POM.sendconfPassword(Phone);
		screenShot.captureScreenShot("ELTC_076_8_"+s);
		
//		******I am not getting regustration error when execute ConPass code run from in this position.******
		ELTC_076_POM.sendconfPassword(ConPass);
		screenShot.captureScreenShot("ELTC_076_9_"+s);		
				
		ELTC_076_POM.clickbtnRegister();
		screenShot.captureScreenShot("ELTC_076_10_"+s);
		
		boolean eleAvailable = driver.findElement(By.xpath("//li[@class='active']")).isDisplayed();
	    Assert.assertTrue(eleAvailable);
	    System.out.println("Register successfully !! " + eleAvailable);
	    
	    boolean eleAvailable1 = driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-12']//p[1]")).isDisplayed();
	    Assert.assertTrue(eleAvailable1);
	    System.out.println("Salutation as Dear is appearing  " + eleAvailable1);
	    
	    boolean eleAvailable2 = driver.findElement(By.xpath("//p[contains(text(),'An e-mail has been sent to remind you of your logi')]")).isDisplayed();
	    Assert.assertTrue(eleAvailable2);
	    System.out.println("Mailling message is appearing  " + eleAvailable2);
	    
	    screenShot.captureScreenShot("ELTC_076_11_"+s);	  
	}

}