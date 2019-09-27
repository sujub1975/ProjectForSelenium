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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.LoginDataProviders080;
import com.training.generics.ScreenShot;
import com.training.pom.ELTC_080_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginExcelTest080 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_080_POM ELTC_080_POM;
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
		ELTC_080_POM = new ELTC_080_POM(driver);
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
	
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders080.class)
	public void checkExcelDataTest(String FirstName, String LastName, String eMail, String Phone, String Login, String Password) {
//		System.out.println("Pass these values to the input form.");
//		System.out.println("First Name: " + FirstName + "Last Name: "+LastName + "E-Mail: "+eMail + "User Name: "+UserName + "Password: "+Pass + "Confirm Password: "+ConPass + "Phone No.: "+Phone + "Language: "+Language);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();  
		String s = dtf.format(now);		
		
		screenShot.captureScreenShot("ELTC_080_0_"+s);
		
		ELTC_080_POM.sendtxtLogin("admin");
		screenShot.captureScreenShot("ELTC_080_1_"+s);
		
		ELTC_080_POM.sendtxtPasword("admin@123");
		screenShot.captureScreenShot("ELTC_080_2_"+s);		
		
		ELTC_080_POM.clickbtnLogin();
		screenShot.captureScreenShot("ELTC_080_3_"+s);
		
		ELTC_080_POM.clickmnuAdmin();
		screenShot.captureScreenShot("ELTC_080_4_"+s);
		
		ELTC_080_POM.clicklnkAddUser();
		screenShot.captureScreenShot("ELTC_080_5_"+s);
		
		ELTC_080_POM.sendtxtFName(FirstName);
		screenShot.captureScreenShot("ELTC_080_6_"+s);
		
		ELTC_080_POM.sendtxtLName(LastName);
		screenShot.captureScreenShot("ELTC_080_7_"+s);		
		
		ELTC_080_POM.sendtxtEmail(eMail);
		screenShot.captureScreenShot("ELTC_080_8_"+s);
		
		ELTC_080_POM.sendtxtPhone(Phone);
		screenShot.captureScreenShot("ELTC_080_9_"+s);
		
		ELTC_080_POM.sendtxtLoginUser(Login);
		screenShot.captureScreenShot("ELTC_080_10_"+s);
		
		ELTC_080_POM.clickoptPassword();
		screenShot.captureScreenShot("ELTC_080_11_"+s);
		
		ELTC_080_POM.sendtxtPasword1(Password);
		screenShot.captureScreenShot("ELTC_080_12_"+s);
		
		ELTC_080_POM.clickdropProfiled();
		screenShot.captureScreenShot("ELTC_080_13_"+s);
		
		ELTC_080_POM.clickdropTProfiled();
		screenShot.captureScreenShot("ELTC_080_14_"+s);
		
		ELTC_080_POM.clickbtnSubmit();
		screenShot.captureScreenShot("ELTC_080_15_"+s);
		
		boolean eleAvailable = driver.findElement(By.xpath("//div[@class='alert alert-info']")).isDisplayed();
	    Assert.assertTrue(eleAvailable);
	    System.out.println("User added successfully !! " + eleAvailable);
	    
	    ELTC_080_POM.clickmnuAdmin();
		screenShot.captureScreenShot("ELTC_080_16_"+s);
		
		ELTC_080_POM.clicklnkAddUserCourse();
		screenShot.captureScreenShot("ELTC_080_17_"+s);
		
		boolean eleAvailable1 = driver.findElement(By.xpath("//legend[contains(text(),'Add users to course')]")).isDisplayed();
	    Assert.assertTrue(eleAvailable1);
	    System.out.println("Add users to course screen open successfully !! " + eleAvailable1);
	    
	    ELTC_080_POM.SelectUser();
	    screenShot.captureScreenShot("ELTC_080_18_"+s);
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");		
	    
	    ELTC_080_POM.SelectCourse();
	    screenShot.captureScreenShot("ELTC_080_19_"+s);

	    ELTC_080_POM.clickbtnAddUserCoursen();
	    screenShot.captureScreenShot("ELTC_080_20_"+s);	
	    
	    boolean eleAvailable2 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
	    Assert.assertTrue(eleAvailable2);
	    System.out.println("The selected users are subscribed to the selected course successfully !! " + eleAvailable2);
	    
	}

}