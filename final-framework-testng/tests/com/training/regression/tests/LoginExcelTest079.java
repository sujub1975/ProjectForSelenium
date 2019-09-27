package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.training.dataproviders.LoginDataProviders079;
import com.training.generics.ScreenShot;
import com.training.pom.ELTC_079_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginExcelTest079 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_079_POM ELTC_079_POM;
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
		ELTC_079_POM = new ELTC_079_POM(driver);
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
	
		
	@Test(priority = 1, dataProvider = "db-inputs", dataProviderClass = LoginDataProviders079.class)
	public void checkExcelDataTest(String UserName, String Password, String Weight, String sUserName, String sPassword, String Search) 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();  
		String s = dtf.format(now);
		
		screenShot.captureScreenShot("ELTC_079_1"+s);
		ELTC_079_POM.sendUserName(UserName);
		ELTC_079_POM.sendPassword(Password);		
		screenShot.captureScreenShot("ELTC_079_2"+s);
		ELTC_079_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("ELTC_079_3"+s);
		ELTC_079_POM.clickbtnThumbnail();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		screenShot.captureScreenShot("ELTC_079_4"+s);
		
		ELTC_079_POM.clickimgAssesment();
		screenShot.captureScreenShot("ELTC_079_5"+s);		
		ELTC_079_POM.clickbtnOnlineAct();
		screenShot.captureScreenShot("ELTC_079_6"+s);
		
//		Start - Code for Bootstrap Drop-down value select	
		ELTC_079_POM.clickeDrop();
		screenShot.captureScreenShot("ELTC_079_7"+s);
		ELTC_079_POM.clickDropVal();	
		screenShot.captureScreenShot("ELTC_079_8"+s);
//		End - Code for Bootstrap Drop-down value select	

		ELTC_079_POM.sendvalweight(Weight);
		screenShot.captureScreenShot("ELTC_079_9"+s);
		
		ELTC_079_POM.clickbtnAddAssesment();
		screenShot.captureScreenShot("ELTC_079_10"+s);			
		boolean msgPassed = driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
	    Assert.assertTrue(msgPassed);
	    System.out.println("Online activity assesment submitted " + msgPassed);		
		
		/*ELTC_079_POM.clickicoEdit();
		screenShot.captureScreenShot("ELTC_079_11"+s);
		boolean msgPassed1 = driver.findElement(By.xpath("//legend[contains(text(),'Edit link')]")).isDisplayed();
	    Assert.assertTrue(msgPassed1);
	    System.out.println("Edit link screen is appearing " + msgPassed1);
	    
	    boolean msgPassed2 = driver.findElement(By.xpath("//div[@id='visible']//label")).isSelected();
	    Assert.assertTrue(msgPassed2);
	    System.out.println("Visible checkbox is selected " + msgPassed2);
	    screenShot.captureScreenShot("ELTC_079_12"+s);
		
		ELTC_079_POM.clickbtnEditLink();
	    screenShot.captureScreenShot("ELTC_079_13"+s);	    
	    boolean msgPassed3 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
	    Assert.assertTrue(msgPassed3);
	    System.out.println("Assessment edited message is displayed " + msgPassed3);*/
	    
//	    driver.findElement(By.xpath("//button[@id='edit_link_form_submit']")).click();	    
	    
	    ELTC_079_POM.clickicoCertificate();
	    boolean msgPassed4 = driver.findElement(By.xpath("//a[contains(text(),'Default certificate')]")).isDisplayed();
	    Assert.assertTrue(msgPassed4);
	    System.out.println("Default certificate is displayed " + msgPassed4);	    
	    screenShot.captureScreenShot("ELTC_079_11"+s);	
	    
	    System.out.println("Pass all above values to the DB and show data from DB for Teacher");		
		System.out.println(UserName+"***"+Password+"***"+Weight);
		
	}
	
	@Test(priority = 2, dataProvider = "db-inputs", dataProviderClass = LoginDataProviders079.class)
	public void checkExcelDataTest1(String UserName, String Password, String Weight, String sUserName, String sPassword, String Search) 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();  
		String s = dtf.format(now);
		
		screenShot.captureScreenShot("ELTC_079_12"+s);
		ELTC_079_POM.sendUserName(sUserName);
		ELTC_079_POM.sendPassword(sPassword);		
		screenShot.captureScreenShot("ELTC_079_13"+s);
		ELTC_079_POM.clickLoginBtn(); 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");		
		screenShot.captureScreenShot("ELTC_079_14"+s);	
		
		ELTC_079_POM.clicklnkCourseCat();
		screenShot.captureScreenShot("ELTC_079_15"+s);		
		boolean msgPassed5 = driver.findElement(By.xpath("//h2[@class='title-courses']")).isDisplayed();
	    Assert.assertTrue(msgPassed5);
	    System.out.println("Courses catalog screen is displayed " + msgPassed5);
	    
	    ELTC_079_POM.sendvalSearch(Search);
	    screenShot.captureScreenShot("ELTC_079_16"+s);
	    
	    ELTC_079_POM.clickbtnSearch();
	    screenShot.captureScreenShot("ELTC_079_17"+s);	
	    
	    ELTC_079_POM.clickbtnSubscribeh();
	    screenShot.captureScreenShot("ELTC_079_18"+s);	
	    
	    ELTC_079_POM.clickmnuMyCourses();
	    screenShot.captureScreenShot("ELTC_079_19"+s);	
	    
	    ELTC_079_POM.clickbtnThumbnail();
	    screenShot.captureScreenShot("ELTC_079_20"+s);	
	    
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,300)");	    
		screenShot.captureScreenShot("ELTC_079_21"+s);	
		
		ELTC_079_POM.clickimgAssesment();
		screenShot.captureScreenShot("ELTC_079_22"+s);	
		
		ELTC_079_POM.clicklnkTestName();
		screenShot.captureScreenShot("ELTC_079_23"+s);	
		
		ELTC_079_POM.clickbtnStartTest();
		screenShot.captureScreenShot("ELTC_079_24"+s);	
	  
		ELTC_079_POM.clickoptAnswer();
		screenShot.captureScreenShot("ELTC_079_25"+s);	
		
		ELTC_079_POM.clickbtnEndTest();
		screenShot.captureScreenShot("ELTC_079_26"+s);			
		
		boolean msgPassed6 = driver.findElement(By.xpath("//h3[contains(text(),'MockELTC_079 : Result')]")).isDisplayed();
	    Assert.assertTrue(msgPassed6);
	    System.out.println("Default certificate is displayed " + msgPassed6);	    
	    screenShot.captureScreenShot("ELTC_079_27"+s);	
				
	    System.out.println("Pass all above values to the DB and show data from DB");		
		System.out.println(sUserName+"***"+sPassword+"***"+Search);
		
	}

}