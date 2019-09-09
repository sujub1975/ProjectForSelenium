package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.training.generics.ScreenShot;


public class ELTC_018_POM {
	private WebDriver driver;	
	
    public ELTC_018_POM(WebDriver driver) {
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth") //formLogin_submitAuth
	private WebElement loginBtn;
	
	@FindBy(xpath= "//a[contains(text(),'Edit profile')]")
	private WebElement editProf;
	
	@FindBy(xpath= "//input[@id='profile_password0']")
	private WebElement passW;
	
	@FindBy(xpath= "//input[@id='password1']")
	private WebElement passN;
	
	@FindBy(xpath= "//input[@id='profile_password2']")
	private WebElement passC;
	
	@FindBy(xpath= "//button[@id='profile_apply_change']")
	private WebElement saveSet;
	
	
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
	
	public void clickProf()
	{
		this.editProf.click();
	}
	
	public void sendPassW(String passW) 
	{
		this.passW.clear();
		this.passW.sendKeys(passW);
	}
	
	public void sendPassN(String passN) 
	{
		this.passN.clear();
		this.passN.sendKeys(passN);
	}
	
	public void sendPassC(String passC) 
	{
		this.passC.clear();
		this.passC.sendKeys(passC);
	}
	
	public void clickSave()
	{
		this.saveSet.click();
	}
}