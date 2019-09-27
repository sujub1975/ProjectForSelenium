package com.training.bean;

public class LoginBean078 {
	private String FirstName;
	private String LastName;
	private String eMail;
	private String UserName;
	private String Pass;
	private String ConfirmPass;
	private String Phone;
	private String Language;
	private String TeachCoursesOption;

	public LoginBean078() {
	}

	public LoginBean078(String FirstName, String LastName, String eMail, String UserName, String Pass, String ConfirmPass, String Phone, String Language, String TeachCoursesOption) {
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.eMail = eMail;
		this.UserName = UserName;
		this.Pass = Pass;
		this.ConfirmPass = ConfirmPass;
		this.Phone = Phone;
		this.Language = Language;
		this.Language = TeachCoursesOption;
		
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	
	public String getPass() {
		return Pass;
	}

	public void setPass(String Pass) {
		this.Pass = Pass;
	}
	
	public String getConfirmPass() {
		return ConfirmPass;
	}

	public void setConfirmPass(String ConfirmPass) {
		this.ConfirmPass = ConfirmPass;
	}
	
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	
	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String Language) {
		this.Language = Language;
	}	
	
	public String getTeachCoursesOption() {
		return TeachCoursesOption;
	}

	public void setTeachCoursesOption(String TeachCoursesOption) {
		this.TeachCoursesOption = TeachCoursesOption;
	}		
	
	@Override
	public String toString() {
		return "LoginBean078 [FirstName=" + FirstName + ", LastName=" + LastName + ", eMail=" + eMail + ", UserName=" + UserName + ", Pass=" + Pass + ", ConfirmPass=" + ConfirmPass + ", Phone=" + Phone + ", Language=" + Language + ", TeachCoursesOption=" + TeachCoursesOption +"]";
	}

}
