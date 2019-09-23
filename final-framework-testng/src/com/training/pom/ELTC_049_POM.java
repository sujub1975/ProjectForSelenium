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


public class ELTC_049_POM {
	private WebDriver driver;		
	
    public ELTC_049_POM(WebDriver driver) {
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
	
	@FindBy(xpath= "//a[contains(text(),'Classes')]")
	private WebElement selectClasses;
	
	@FindBy(xpath= "//img[@title='Add classes']")
	private WebElement addClassIcon;

	@FindBy(id= "usergroup_name")
	private WebElement className;

	@FindBy(id= "usergroup_description")
	private WebElement classDescriotion;
	
	//Start - Code for Bootstrap Drop-down value select
	@FindBy(xpath="//div[@class='filter-option-inner-inner']")
	private WebElement selectDropGroupPermissions;	
		
	@FindBy(xpath="//span[contains(text(),'Open')]")
	private WebElement selectGroupPermissions;
	//End - Code for Bootstrap Drop-down value select

	@FindBy(xpath= "//button[@id='usergroup_submit']")
	private WebElement btnAdd;	
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/section[1]/div[1]/div[3]/div[3]/div[3]/div[1]/table[1]/tbody[1]/tr[7]/td[6]/a[1]/img[1]")
	private WebElement btnSubscribe;
	
	/*@FindBy(xpath= "//input[@id='username']")
	private WebElement LUser;

	@FindBy(xpath= "//div[@id='password-group']//div[@class='col-sm-8']//div[2]//label[1]")
	private WebElement ePass;	

	@FindBy(xpath= "//input[@id='password']")
	private WebElement addPass;
	
	//Start - Code for Bootstrap Drop-down value select
	@FindBy(xpath="//button[@title='Learner']//div[@class='filter-option-inner']")
	private WebElement selectDrop;	
	
	@FindBy(xpath="//span[contains(text(),'Trainer')]")
	private WebElement selectDropVal;
	//End - Code for Bootstrap Drop-down value select
	
	@FindBy(xpath= "//button[@name='submit']")
	private WebElement btnSubmit;
	
	@FindBy(xpath= "//a[contains(text(),'Add users to course')]")
	private WebElement addUserToCourse;
	
	@FindBy(xpath= "//button[@value='Add to the course(s) >>']")
	private WebElement clickAddtobtn;*/
	

	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}	
	
	public void clickAdm()
	{
		this.admClick.click();
	}
	
	public void clickClassesLink() 
	{
		this.selectClasses.click();		
	}
	
	public void clickClassIcon() 
	{
		this.addClassIcon.click();		
	}
	
	public void sendclassName(String className) 
	{
		this.className.clear();
		this.className.sendKeys(className);
	}
	
	public void sendclassDescriotion(String classDescriotion) 
	{
		this.classDescriotion.clear();
		this.classDescriotion.sendKeys(classDescriotion);
	}
	
	//Start - Code for Bootstrap Drop-down value select
	public void clickGroupPermissions()
	{
		this.selectDropGroupPermissions.click();
	}	
		
	public void selectGroupPermissions()
	{
		this.selectGroupPermissions.click();
	}	
	//End - Code for Bootstrap Drop-down value select
		
	
	public void clickAddBtn() 
	{
		this.btnAdd.click();
	}
	
	public void clickSubscribeUsersIcon()
	{
		String before_xpath = "/html/body/main/section/div/div[3]/div[3]/div[3]/div/table/tbody/tr[";
		String after_xpath = "]/td[6]/a[1]/img";
		
		for (int i=1; i<=25; i++)
		{
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			/*if (name.contains("RPA Automation"))
			{
				driver.findElement(By.xpath("" + i + "")).click();
			}*/
		}		
		
	}
	
	/*public void sendlogUser(String LUser) 
	{
		this.LUser.clear();
		this.LUser.sendKeys(LUser);
	}
	
	public void clickePassOpt()
	{
		this.ePass.click();
	}
	
	public void sendAPass(String addPass) 
	{
		this.addPass.clear();
		this.addPass.sendKeys(addPass);
	}	
	//Start - Code for Bootstrap Drop-down value select
	public void clickeDrop()
	{
		this.selectDrop.click();
	}	
	
	public void clickDropVal()
	{
		this.selectDropVal.click();
	}	
	//End - Code for Bootstrap Drop-down value select
	
	public void clickbtnSubmit()
	{
		this.btnSubmit.click();
	}	
	
	public void clickaddUserToCourse()
	{
		this.addUserToCourse.click();
	}	
	
	public void SelectUser()
	{
		String before_xpath = "/html[1]/body[1]/main[1]/section[1]/div[1]/form[2]/table[1]/tbody[1]/tr[2]/td[1]/select[1]/option[";
		String after_xpath = "]";
		
		for (int i=1; i<=50; i++)
		{
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			//System.out.println(name);
			if (name.contains("Bhattacharjee Sujayb (sujayb2019)"))
			{
				driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/form[2]/table[1]/tbody[1]/tr[2]/td[1]/select[1]/option[" + i + "]")).click();
			}
		}
	}
		
		public void SelectCourse()
		{
			String before_xpath = "/html[1]/body[1]/main[1]/section[1]/div[1]/form[2]/table[1]/tbody[1]/tr[2]/td[3]/select[1]/option[";
			String after_xpath = "]";
			
			for (int i=1; i<=50; i++)
			{
				String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
				//System.out.println(name);
				if (name.contains("(RPA1) Robotic Part 1"))
				{
					driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/form[2]/table[1]/tbody[1]/tr[2]/td[3]/select[1]/option[" + i + "]")).click();
				}
			}		
		}
		
		public void clickAddtobtn1()
		{
			this.clickAddtobtn.click();
		}*/
}