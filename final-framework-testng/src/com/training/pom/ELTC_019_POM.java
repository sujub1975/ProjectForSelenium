package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.training.generics.ScreenShot;


public class ELTC_019_POM {
	private WebDriver driver;	
	
    public ELTC_019_POM(WebDriver driver) {
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
	
	@FindBy(xpath= "//a[@href='user_list.php']")
	private WebElement uList;
	
	@FindBy(xpath= "//a[@href='http://elearningm1.upskills.in/main/admin/user_edit.php?user_id=17']//img[@title='Edit']")
	private WebElement uEdit;	
	
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
	
	public void clickUlist() 
	{
		this.uList.click();
	}
	
	public void clickUEdit()
	{
		this.uEdit.click();
	}	
}