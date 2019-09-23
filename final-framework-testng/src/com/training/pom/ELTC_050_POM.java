package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.training.generics.ScreenShot;
import org.testng.Assert;


public class ELTC_050_POM {
	private WebDriver driver;		
	
    public ELTC_050_POM(WebDriver driver) 
    {
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth") //formLogin_submitAuth
	private WebElement loginBtn;
	
	@FindBy(xpath= "//a[@title='Administration']")
	private WebElement admClick;
	
	@FindBy(xpath= "//a[contains(text(),'Add a training session')]")
	private WebElement Addatrainingsession;	
	
	@FindBy(xpath= "//input[@id='add_session_name']")
	private WebElement AddSessionName;
	
//	Start - Code for Bootstrap Drop-down value select
	@FindBy(xpath="//span[@id='select2-coach_username-container']")
	private WebElement selectDropCoach;	
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchValue;		
//		End - Code for Bootstrap Drop-down value select
	
	
	public void sendUserName(String userName) 
	{
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) 
	{
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() 
	{
		this.loginBtn.click(); 
	}	
	
	public void clickAdm()
	{
		this.admClick.click();
	}
	
	public void clickAddatrainingsession() 
	{		
		this.Addatrainingsession.click();		
	}
	
	public void valueAddSessionName(String AddSessionName) 
	{		
		this.AddSessionName.clear();
		this.AddSessionName.sendKeys(AddSessionName);
	}	
	
//	Start - Code for Bootstrap Drop-down value select
		public void selectDropCoach()
		{
			this.selectDropCoach.click();
		}	
		
		public void entersearchValue(String searchValue) 
		{		
			this.searchValue.clear();
			this.searchValue.sendKeys(searchValue);
//			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
//			this.searchValue.sendKeys(Keys.TAB);
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//			this.searchValue.sendKeys(Keys.ENTER);
		}		
		
		public void actualsearchValue(String ActsearchValue) 
		{		
			this.ActsearchValue.clear();
			this.ActsearchValue.sendKeys(ActsearchValue);
		}	
		
//		End - Code for Bootstrap Drop-down value select
	
}