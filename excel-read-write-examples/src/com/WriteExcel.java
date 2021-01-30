package com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		
		//create excel file
		
	
		
		//create workbook object
		
		//Workbook wb=new XSSFWorkbook();
		

		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("employee sheet");
		
		Map<String, Object[]> data =new TreeMap<String, Object[]>();
		
		data.put ("1", new Object[] {"Id", "Name", "LastName"});
		
		data.put( "2", new Object[] { 1, "Pranoti", "Sawarkar"});
		
	    data.put( "3", new Object[] {2, "Pragati", "Sawarkar" });
	    
	    data.put( "4", new Object[] {2, "Pallavi", "Dudurkar" });
	    
	    data.put( "5", new Object[] {2, "Shubham", "Sawarkar" });
	    
	    
	     Set<String> setOfKeys  = data.keySet();
	     
	     int rownum=0;
	     
	     for(String Keys : setOfKeys) {
	    	 
	    	 Row row =sheet.createRow(rownum++);
	    	 
	    	        Object[] value= data.get(Keys);
	    	        
	     int cellnum=0;
	     
	     for(Object obj : value) {
	    	 
	    	 Cell cell =row.createCell(cellnum++);
	    	 
	  
	    	
	       if(obj instanceof String) {
	    	   
	    	   String s= (String) obj;
	    	   
	    	   cell.setCellValue(s);
	    	  
	       }
	       else if( obj instanceof Integer) {
	    	   
	    	   Integer i= (Integer) obj;
	    	   
	    	   cell.setCellType(i);
	    	   
	       }
	     }
	    	 
	    	 
	     }
	 	FileOutputStream fops=new FileOutputStream("E://Pranoti.xlsx");
	
		
	 	workbook.write(fops);
			
			System.out.println("File created successfully");
		
			fops.close();

	}

}
