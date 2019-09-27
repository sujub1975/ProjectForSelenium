package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean078;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class ELearningDAO_078 {
	
	Properties properties; 
	
	public ELearningDAO_078() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean078> getregistration(){
		String sql = properties.getProperty("get.registration"); //Update sql.properties file from resources as per your table.
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean078> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean078>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean078 temp = new LoginBean078(); 
				temp.setFirstName(gc.rs1.getString(1));
				temp.setLastName(gc.rs1.getString(2));
				temp.seteMail(gc.rs1.getString(3));
				temp.setUserName(gc.rs1.getString(4));
				temp.setPass(gc.rs1.getString(5));
				temp.setConfirmPass(gc.rs1.getString(6));
				temp.setPhone(gc.rs1.getString(7));
				temp.setLanguage(gc.rs1.getString(8));
				temp.setTeachCoursesOption(gc.rs1.getString(9));
				
				list.add(temp); 
//				System.out.println(temp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new ELearningDAO_078().getregistration().forEach(System.out :: println);
	}
	
	
}
