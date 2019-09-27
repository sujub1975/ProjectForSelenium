package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_078_POM {
	private WebDriver driver;
	
    public ELTC_078_POM(WebDriver driver) {
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }      
    
    @FindBy(xpath="//a[contains(text(),'Sign up!')]")
	private WebElement btnSignUp; 
    
    @FindBy(xpath="//p[contains(text(),'Teach courses')]")
	private WebElement optTeacher; 
    
    @FindBy(xpath="//input[@id='registration_firstname']")
	private WebElement FName;     
	
	@FindBy(xpath="//input[@id='registration_lastname']")
	private WebElement LName;
	
	@FindBy(xpath="//input[@id='registration_email']")
	private WebElement EmailID; 
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement userName; 
	
	@FindBy(xpath="//input[@id='pass1']")
	private WebElement Password; 
	
	@FindBy(xpath="//input[@id='pass2']")
	private WebElement confPassword; 
	
	@FindBy(xpath="//input[@id='registration_phone']")
	private WebElement numPhone; 
	
	@FindBy(xpath="//button[@id='registration_submit']")
	private WebElement btnRegister; 	
	
		
	public void clickbtnSignUp() 
	{
		this.btnSignUp.click(); 
	}
	
	public void clickoptTeacher() 
	{
		this.optTeacher.click(); 
	}	
	
	public void sendFirstName(String FName) {
		this.FName.clear();
		this.FName.sendKeys(FName);
	}
	
	public void sendSecondName(String LName) {
		this.LName.clear(); 
		this.LName.sendKeys(LName); 
	}
	
	public void sendEmailID(String EmailID) {
		this.EmailID.clear(); 
		this.EmailID.sendKeys(EmailID); 
	}
	
	public void senduserName(String userName) {
		this.userName.clear(); 
		this.userName.sendKeys(userName); 
	}
	
	public void sendPassword(String Password) {
		this.Password.clear(); 
		this.Password.sendKeys(Password); 
	}
	
	public void sendconfPassword(String confPassword) {
		this.confPassword.clear(); 
		this.confPassword.sendKeys(confPassword); 
	}
	
	public void sendnumPhone(String numPhone) {
		this.numPhone.clear(); 
		this.numPhone.sendKeys(numPhone); 
	}
	
	public void clickbtnRegister() 
	{
		this.btnRegister.click(); 
	}
	
	
	
	
}
