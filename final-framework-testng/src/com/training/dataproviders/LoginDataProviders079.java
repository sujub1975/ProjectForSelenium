package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean079;
import com.training.dao.ELearningDAO_079;
import com.training.readexcel.ApachePOIExcelRead;
//import com.training.readexcel.ApachePOIExcelRead079;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders079 {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean079> list = new ELearningDAO_079().getassessment(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean079 temp : list){
			Object[]  obj = new Object[6]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			obj[2] = temp.getWeight();
			obj[3] = temp.getsUserName(); 
			obj[4] = temp.getsPassword(); 
			obj[5] = temp.getSearch();
			
			result[count ++] = obj; 
		}		
		
		return result;
	}
	
	/*@DataProvider(name = "excel-inputs")	
	public Object[][] getExcelData(){
		//String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx";		
		String fileName ="C:/ELearningData079.xlsx";
		int START_ROW = 1;
		int START_COL = 2;
		int TOTAL_ROWS = 3;
		int TOTAL_COLUMNS = 7;
		
		return new ApachePOIExcelRead079().getExcelContent(fileName, "TestData",START_ROW, START_COL, TOTAL_ROWS, TOTAL_COLUMNS);		
		}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/ELearningData.xlsx", "TestData"); 
	}*/
}
