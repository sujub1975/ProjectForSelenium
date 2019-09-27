package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean078;
import com.training.dao.ELearningDAO_078;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ApachePOIExcelRead078;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders078 {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean078> list = new ELearningDAO_078().getregistration(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean078 temp : list){
			Object[]  obj = new Object[9]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getLastName(); 
			obj[2] = temp.geteMail();
			obj[3] = temp.getUserName();
			obj[4] = temp.getPass();
			obj[5] = temp.getConfirmPass();
			obj[6] = temp.getPhone();
			obj[7] = temp.getLanguage();
			obj[8] = temp.getTeachCoursesOption();
			
			result[count ++] = obj; 
		}		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")	
	public Object[][] getExcelData(){
		//String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx";		
		String fileName ="C:/ELearningData078.xlsx";
		int START_ROW = 1;
		int START_COL = 2;
		int TOTAL_ROWS = 3;
		int TOTAL_COLUMNS = 7;
		
		return new ApachePOIExcelRead078().getExcelContent(fileName, "TestData",START_ROW, START_COL, TOTAL_ROWS, TOTAL_COLUMNS);		
		}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/ELearningData.xlsx", "TestData"); 
	}
}
