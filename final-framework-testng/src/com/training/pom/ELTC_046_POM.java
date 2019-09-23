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


public class ELTC_046_POM {
	private WebDriver driver;		
	
    public ELTC_046_POM(WebDriver driver) {
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth") //formLogin_submitAuth
	private WebElement loginBtn;
	
	@FindBy(xpath= "//a[@href='main/auth/courses.php']")
	private WebElement catCourses;
	
	@FindBy(xpath= "//input[@name='search_term']")
	private WebElement searchCourse;
	
	@FindBy(xpath= "//button[@type='submit']")
	private WebElement searchSubmit;	

	@FindBy(xpath= "//div[@class='grid-courses row']//div[1]//div[1]//div[2]//div[4]//div[1]//a[1]")
	private WebElement subscribeIT;	
	
	/*@FindBy(xpath= "//input[@id='course_category_name']")
	private WebElement addCourCatName;

	@FindBy(xpath= "//div[@class='col-sm-8']//div[1]//label[1]")
	private WebElement addCourCatYes;	

	@FindBy(id= "course_category_submit")
	private WebElement btnAddCat;

	@FindBy(xpath= "//a[@href='index.php?']")
	private WebElement clickAdmLink;	

	@FindBy(xpath= "//a[contains(text(),'Create a course')]")
	private WebElement clkCreateCour;
	
	@FindBy(xpath= "//input[@id='update_course_title']")
	private WebElement txtTitle;
	
	@FindBy(xpath= "//input[@id='visual_code']")
	private WebElement txtCode;		
		
	//Start - Code for Bootstrap Drop-down value select	
	@FindBy(xpath="//div[contains(text(),'none')]")
	private WebElement clkCateDrop;	
	
	@FindBy(xpath="//span[contains(text(),'Robotic Process Automation (RPA)')]")	
	private WebElement selRAPCate;
	//End - Code for Bootstrap Drop-down value select	
	
	@FindBy(xpath= "li[@class='select2-results__option select2-results__message']")
	private WebElement entTeachers;	
	
	@FindBy(xpath= "//button[@title='English']//span[@class='caret']")
	private WebElement clkLanguage;	
	
	@FindBy(xpath= "//span[contains(text(),'English')]")
	private WebElement seleLanguageEng;			
	
	@FindBy(xpath= "//button[@id='update_course_submit']")
	private WebElement btnCreateCour;	*/
	
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
	
	public void clickcatCourses()
	{
		this.catCourses.click();
	}
	
	public void inputSearchCourse(String searchCourse) 
	{
		this.searchCourse.clear(); 
		this.searchCourse.sendKeys(searchCourse);
	}	
	
	public void clickSearchSubmit() 
	{
		this.searchSubmit.click();
	}
	
	public void clicksubscribeIT() 
	{
		this.subscribeIT.click();		
	}
	
	/*public void addCourCatName1(String addCourCatName) 
	{
		this.addCourCatName.clear();
		this.addCourCatName.sendKeys(addCourCatName);
	}
	
	public void addCourCatYes1() 
	{
		this.addCourCatYes.click();
	}
	
	public void btnAddCat1() 
	{
		this.btnAddCat.click();
	}
	
	public void clickAdmLink1()
	{
		this.clickAdmLink.click();
	}
	
	public void clkCreateCour1() 
	{
		this.clkCreateCour.click();
	}	
	
	public void txtTitle1(String txtTitle)  
	{
		this.txtTitle.clear();
		this.txtTitle.sendKeys(txtTitle);
	}	
	
	public void txtCode1(String txtCode)  
	{
		this.txtCode.clear();
		this.txtCode.sendKeys(txtCode);
	}	
	
	//Start - Code for Bootstrap Drop-down value select
	public void clkCateDrop1()
	{
		this.clkCateDrop.click();
	}	
	
	public void selRAPCate1()
	{
		this.selRAPCate.click();		
	}		
	//End - Code for Bootstrap Drop-down value select		
	
	public void entTeachers1(String entTeachers)  
	{
		this.entTeachers.clear();
		this.entTeachers.sendKeys(entTeachers);		
	}			
	
	public void clkLanguage1()
	{
		this.clkLanguage.click();
	}	
	
	public void seleLanguageEng1()
	{
		this.seleLanguageEng.click();
	}	
	
	public void btnCreateCour1()
	{
		this.btnCreateCour.click();
	}*/
}