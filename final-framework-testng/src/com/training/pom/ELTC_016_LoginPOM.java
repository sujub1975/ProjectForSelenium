package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.training.generics.ScreenShot;


public class ELTC_016_LoginPOM {
	private WebDriver driver;	
	
    public ELTC_016_LoginPOM(WebDriver driver) {
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth") //formLogin_submitAuth
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement dropmenu;
	
	@FindBy(xpath="//a[@id='logout_button']")
	private WebElement logOut;	
	
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
	
	public void clickDropmenu()
	{
		this.dropmenu.click();
	}
	
	public void clickLogout()
	{		
		this.logOut.click();		
	}
	
}
