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
import com.training.dataproviders.LoginDataProviders077;
import com.training.generics.ScreenShot;
import com.training.pom.ELTC_077_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginExcelTest077 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_077_POM ELTC_077_POM;
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
		ELTC_077_POM = new ELTC_077_POM(driver);
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

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders077.class)
	public void checkExcelDataTest(String FirstName, String LastName, String eMail, String UserName, String Pass, String ConPass, String Phone) {
//		System.out.println("Pass these values to the input form.");
//		System.out.println("First Name: " + FirstName + "Last Name: "+LastName + "E-Mail: "+eMail + "User Name: "+UserName + "Password: "+Pass + "Confirm Password: "+ConPass + "Phone No.: "+Phone + "Language: "+Language);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();  
		String s = dtf.format(now);
		
		screenShot.captureScreenShot("ELTC_077_0_"+s);
		
		ELTC_077_POM.clickbtnSignUp();
		screenShot.captureScreenShot("ELTC_077_1_"+s);
		
		ELTC_077_POM.clickoptTeacher();
		screenShot.captureScreenShot("ELTC_077_2_"+s);
		
		ELTC_077_POM.sendFirstName(FirstName);
		screenShot.captureScreenShot("ELTC_077_3_"+s);
		
		ELTC_077_POM.sendSecondName(LastName);
		screenShot.captureScreenShot("ELTC_077_4_"+s);
		
		ELTC_077_POM.sendEmailID(eMail);
		screenShot.captureScreenShot("ELTC_077_5_"+s);
		
		ELTC_077_POM.senduserName(UserName);
		screenShot.captureScreenShot("ELTC_077_6_"+s);
		
		ELTC_077_POM.sendPassword(Pass);
		screenShot.captureScreenShot("ELTC_077_7_"+s);
		
		ELTC_077_POM.sendconfPassword(Phone);
		screenShot.captureScreenShot("ELTC_077_8_"+s);
		
		ELTC_077_POM.sendconfPassword(ConPass);
		screenShot.captureScreenShot("ELTC_077_9_"+s);
				
		ELTC_077_POM.clickbtnRegister();
		screenShot.captureScreenShot("ELTC_077_10_"+s);
	    
	    boolean msgFailed = driver.findElement(By.xpath("//div[@class='alert alert-warning']")).isDisplayed();
	    Assert.assertTrue(msgFailed);
	    System.out.println("Error message is appearing for wrong data " + msgFailed);  
	    
	}

}