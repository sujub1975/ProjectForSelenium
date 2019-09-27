package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_080_POM {
	private WebDriver driver;
	
    public ELTC_080_POM(WebDriver driver) {
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }   
    
    @FindBy(id="login")
	private WebElement txtLogin; 
    
    @FindBy(id="password")
	private WebElement txtPasword;
    
    @FindBy(xpath="//button[@id='form-login_submitAuth']")
	private WebElement btnLogin;
    
    @FindBy(xpath="//a[@title='Administration']")
	private WebElement mnuAdmin;
    
    @FindBy(xpath="//a[contains(text(),'Add a user')]")
	private WebElement lnkAddUser;
    
    @FindBy(xpath="//input[@id='firstname']")
	private WebElement txtFName;
    
    @FindBy(xpath="//input[@id='lastname']")
	private WebElement txtLName;
    
    @FindBy(xpath="//input[@id='email']")
	private WebElement txtEmail;
    
    @FindBy(xpath="//input[@id='phone']")
	private WebElement txtPhone;
    
    @FindBy(xpath="//input[@id='username']")
	private WebElement txtLoginUser;
    
    @FindBy(xpath="//div[@id='password-group']//div[@class='col-sm-8']//div[2]//label[1]")
	private WebElement optPassword;
    
    @FindBy(xpath="//input[@id='password']")
	private WebElement txtPasword1;
    
//    Start Dropdown
    @FindBy(xpath="//button[@title='Learner']//div[@class='filter-option-inner']")
	private WebElement dropProfile;
    
    @FindBy(xpath="//span[contains(text(),'Trainer')]")
	private WebElement dropTProfile;
//    End Dropdown
    
    @FindBy(xpath="//button[@name='submit']")
	private WebElement btnSubmit;
    
    @FindBy(xpath="//a[contains(text(),'Add users to course')]")
	private WebElement lnkAddUserCourse;
    
    @FindBy(xpath="//button[@value='Add to the course(s) >>']")
	private WebElement btnAddUserCourse; 
  
    
    public void sendtxtLogin(String txtLogin) 
    {
		this.txtLogin.clear();
		this.txtLogin.sendKeys(txtLogin);
	}
	
	public void sendtxtPasword(String txtPasword) 
	{
		this.txtPasword.clear(); 
		this.txtPasword.sendKeys(txtPasword); 
	}
	
	public void clickbtnLogin() 
	{
		this.btnLogin.click(); 
	}
	
	public void clickmnuAdmin() 
	{
		this.mnuAdmin.click(); 
	}
    
	public void clicklnkAddUser() 
	{
		this.lnkAddUser.click(); 
	}
	
	public void sendtxtFName(String txtFName) 
    {
		this.txtFName.clear();
		this.txtFName.sendKeys(txtFName);
	}
	
	public void sendtxtLName(String txtLName) 
    {
		this.txtLName.clear();
		this.txtLName.sendKeys(txtLName);
	}
	
	public void sendtxtEmail(String txtEmail) 
    {
		this.txtEmail.clear();
		this.txtEmail.sendKeys(txtEmail);
	}
	
	public void sendtxtPhone(String txtPhone) 
    {
		this.txtPhone.clear();
		this.txtPhone.sendKeys(txtPhone);
	}
	
	public void sendtxtLoginUser(String txtLoginUser) 
    {
		this.txtLoginUser.clear();
		this.txtLoginUser.sendKeys(txtLoginUser);
	}
	
	public void clickoptPassword() 
	{
		this.optPassword.click(); 
	}
	 
	public void sendtxtPasword1(String txtPasword1) 
	{
		this.txtPasword1.clear(); 
		this.txtPasword1.sendKeys(txtPasword1); 
	}
	
	public void clickdropProfiled() 
	{
		this.dropProfile.click(); 
	}
	
	public void clickdropTProfiled() 
	{
		this.dropTProfile.click(); 
	}
	
	public void clickbtnSubmit() 
	{
		this.btnSubmit.click(); 
	}
	
	public void clicklnkAddUserCourse() 
	{
		this.lnkAddUserCourse.click(); 
	}
	
	public void SelectUser()
	{
		String before_xpath = "/html/body/main/section/div/form[2]/table/tbody/tr[2]/td[1]/select/option[";
		String after_xpath = "]";
		
		for (int i=1; i<=100; i++)
		{
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			//System.out.println(name);
			if (name.contains("mehadi80 manzoor80 (manzoor80)"))
			{
				driver.findElement(By.xpath("/html/body/main/section/div/form[2]/table/tbody/tr[2]/td[1]/select/option[" + i + "]")).click();
			}
		}
	}
		
		public void SelectCourse()
		{
			String before_xpath = "/html/body/main/section/div/form[2]/table/tbody/tr[2]/td[3]/select/option[";
			String after_xpath = "]";
			
			for (int i=1; i<=50; i++)
			{
				String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
				//System.out.println(name);
				if (name.contains("(AUTOMATEELTC079) AutomateELTC_079"))
				{
					driver.findElement(By.xpath("/html/body/main/section/div/form[2]/table/tbody/tr[2]/td[3]/select/option[" + i + "]")).click();
				}
			}		
		}
		
		public void clickbtnAddUserCoursen() 
		{
			this.btnAddUserCourse.click(); 
		}	
	
}
