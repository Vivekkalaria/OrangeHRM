package testdata;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excelsheet {

	public static Workbook book;
	public static Sheet sheet;
	public static Object[][] readdata(String Sheetname){
		
	FileInputStream file=null; 
	try {
		file=new FileInputStream("C:\\Users\\Tast\\eclipse-workspace\\OrangeHR\\src\\test\\java\\testdata\\Details.xlsx");
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	
	try {
	book=WorkbookFactory.create(file);
	}
	
	catch(IOException a ){
		  a.printStackTrace();
	}
	
	Sheet sheet= book.getSheet(Sheetname);
	
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for (int i=0;i<sheet.getLastRowNum();i++) {
		
		for (int f=0;i<sheet.getRow(0).getLastCellNum();f++) {
	
		data[i][f]=sheet.getRow(i+1).getCell(f).toString();
		
		}
	
	
	
	
	
	
	}
	return data;
}
}