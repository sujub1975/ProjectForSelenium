package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_016_LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_016_Login {

	private WebDriver driver;
	private String baseUrl;
	private ELTC_016_LoginPOM ELTC_016_LoginPOM;
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
		ELTC_016_LoginPOM = new ELTC_016_LoginPOM(driver); 
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
		screenShot.captureScreenShot("ELTC_016_1");
		ELTC_016_LoginPOM.sendUserName("admin");	    
		ELTC_016_LoginPOM.sendPassword("admin@123");
		screenShot.captureScreenShot("ELTC_016_2");
		ELTC_016_LoginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("ELTC_016_3");
		ELTC_016_LoginPOM.clickDropmenu();	
		screenShot.captureScreenShot("ELTC_016_4");
		
		//Thread.sleep(1000);		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//WebDriverWait wait =new WebDriverWait(driver, 60);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='form-login_submitAuth']")));
		
		ELTC_016_LoginPOM.clickLogout();		
		screenShot.captureScreenShot("ELTC_016_5");		
		
		boolean eleAfterLO = driver.findElement(By.xpath("//h4[contains(text(),'Most popular courses')]")).isDisplayed();
	    Assert.assertTrue(eleAfterLO);
	    System.out.println("Logout successfully!!" + eleAfterLO);		
	    
	    driver.quit();
	}	
}