package com.training.bean;

public class LoginBean079 {
	private String UserName;
	private String Password;
	private String Weight;	
	private String sUserName;
	private String sPassword;
	private String Search;

	public LoginBean079() {
	}

	public LoginBean079(String UserName, String Password, String Weight, String sUserName, String sPassword, String Search) {
		super();
		this.UserName = UserName;
		this.Password = Password;
		this.Weight = Weight;
		this.Weight = sUserName;
		this.Weight = sPassword;
		this.Weight = Search;		
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	public String getWeight() {
		return Weight;
	}

	public void setWeight(String Weight) {
		this.Weight = Weight;
	}
	
//	*******************************
	public String getsUserName() {
		return sUserName;
	}

	public void setsUserName(String sUserName) {
		this.sUserName = sUserName;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	
	public String getSearch() {
		return Search;
	}

	public void setSearch(String Search) {
		this.Search = Search;
	}
	
	@Override
	public String toString() {
		return "LoginBean079 [UserName=" + UserName + ", Password=" + Password + ", Weight=" + Weight + ", sUserName=" + sUserName + ", sPassword=" + sPassword + ", Search=" + Search +"]";
	}

}
