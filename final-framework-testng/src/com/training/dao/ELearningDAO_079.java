package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean079;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class ELearningDAO_079 {
	
	Properties properties; 
	
	public ELearningDAO_079() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean079> getassessment(){
		String sql = properties.getProperty("get.assessment"); //Update sql.properties file from resources as per your table.
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean079> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean079>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean079 temp = new LoginBean079(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));
				temp.setWeight(gc.rs1.getString(3));
				temp.setsUserName(gc.rs1.getString(4));
				temp.setsPassword(gc.rs1.getString(5));
				temp.setSearch(gc.rs1.getString(6));
				
				
				list.add(temp); 
				System.out.println(temp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new ELearningDAO_079().getassessment().forEach(System.out :: println);
	}
	
	
}
