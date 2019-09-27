package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_079_POM {
	private WebDriver driver;
	
    public ELTC_079_POM(WebDriver driver) {
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }
    ////////////////Part-1//////////////////////
    @FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth") //formLogin_submitAuth
	private WebElement loginBtn;
    
    @FindBy(xpath="//a[@class='thumbnail']")
	private WebElement btnThumbnail; 
    
    @FindBy(xpath="//img[@id='toolimage_3741']")
	private WebElement imgAssesment; 
    
    @FindBy(xpath="//img[@title='Add online activity']")
	private WebElement btnOnlineAct;   
    
//  Start - Code for Bootstrap Drop-down value select
    @FindBy(xpath="//div[@class='filter-option-inner']")
	private WebElement selectDrop;	
	
	@FindBy(xpath="//ul[contains(@class,'dropdown-menu inner')]//li[2]//a[1]")
	private WebElement selectDropVal;
//	End - Code for Bootstrap Drop-down value select
	
	@FindBy(xpath="//input[@id='weight_mask']")
	private WebElement valweight;
	
	@FindBy(xpath="//button[@id='add_link_submit']")
	private WebElement btnAddAssesment; 
	
	/*@FindBy(xpath="/html/body/main/section/div/div[3]/div/section/form/div/table/tbody/tr[2]/td[6]/a[1]/img")
	private WebElement icoEdit; 
	
	@FindBy(xpath = "//button[@id='edit_link_form_submit']")
	private WebElement btnEditLink;*/
	
	@FindBy(xpath="//img[@title='Attach certificate']")
	private WebElement icoCertificate; 
	
	//////////////////Part-2//////////////////////
	@FindBy(xpath="//a[@href='main/auth/courses.php']")
	private WebElement lnkCourseCat; 
	
	@FindBy(xpath="//input[@name='search_term']")
	private WebElement valSearch;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btnSearch;
	
	@FindBy(xpath="//a[@title='Subscribe']")
	private WebElement btnSubscribe;
	
	@FindBy(xpath="//a[@title='My courses']")
	private WebElement mnuMyCourses;
	
	@FindBy(xpath="//a[contains(text(),'MockELTC_079')]")
	private WebElement lnkTestName;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-large']")
	private WebElement btnStartTest;
	
	@FindBy(xpath="//input[@id='choice-90-4']")
	private WebElement optAnswer;
	
	@FindBy(xpath="/html/body/main/section/div/div[2]/form/div/div[3]/button")
	private WebElement btnEndTest;	
	////////////////////Part-3/////////////////////////
	@FindBy(xpath="//img[@id='toolimage_3738']")
	private WebElement imgAssignment;
	
	
	
	
	/////////////////////////////////////////
	
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
		
	public void clickbtnThumbnail() 
	{
		this.btnThumbnail.click(); 
	}	
	
	public void clickimgAssesment() 
	{
		this.imgAssesment.click(); 
	}	
	
	public void clickbtnOnlineAct() 
	{
		this.btnOnlineAct.click(); 
	}	
	
//	Start - Code for Bootstrap Drop-down value select
	public void clickeDrop()
	{
		this.selectDrop.click();
	}	
	
	public void clickDropVal()
	{
		this.selectDropVal.click();
	}	
//	End - Code for Bootstrap Drop-down value select
	
	
	public void sendvalweight(String valweight) {
		this.valweight.clear();
		this.valweight.sendKeys(valweight);
	}
	
	public void clickbtnAddAssesment()
	{
		this.btnAddAssesment.click();
	}	
	
	/*public void clickicoEdit()
	{
		this.icoEdit.click();
	}	
	
	public void clickbtnEditLink()
	{
		this.btnEditLink.click();
	}	*/
	
	public void clickicoCertificate()
	{
		this.icoCertificate.click();
	}		
	
	////////////////Part-2///////////////////
	
	public void clicklnkCourseCat()
	{
		this.lnkCourseCat.click();
	}	
	
	public void sendvalSearch(String valSearch) {
		this.valSearch.clear();
		this.valSearch.sendKeys(valSearch);
	}
	
	public void clickbtnSearch()
	{
		this.btnSearch.click();
	}	
	
	public void clickbtnSubscribeh()
	{
		this.btnSubscribe.click();
	}	
	
	public void clickmnuMyCourses()
	{
		this.mnuMyCourses.click();
	}	
	
	public void clicklnkTestName()
	{
		this.lnkTestName.click();
	}
	
	public void clickbtnStartTest()
	{
		this.btnStartTest.click();
	}
	
	public void clickoptAnswer()
	{
		this.optAnswer.click();
		this.optAnswer.isSelected();
	}
	
	public void clickbtnEndTest()
	{
		this.btnEndTest.click();
	}
	
	////////////////Part-3/////////////////////
	public void clickimgAssignment()
	{
		this.imgAssignment.click();
	}
	
	
	
}
