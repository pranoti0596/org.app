package com;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException  {
		
		//object for file reading
		
	
			FileInputStream fios=new FileInputStream("E://Pranoti.xlsx");
	
		
		
		//create workbook object
		
		XSSFWorkbook workbook=new XSSFWorkbook(fios);
		
		//create sheet object for read sheet
		
		
		Sheet sheet = workbook.getSheetAt(0);
		
		//iterator used for iteration
		
		Iterator<Row> itrrow = sheet.rowIterator();
		
		
		
		//read row from sheet
		
		            Row row = itrrow.next();
		            
		 Iterator<Cell> cells = row.cellIterator();
		 
		
		     //read cell by row
		
		      Cell cell = cells.next();
		      
		      
		      if(Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
		    	  
		    	  System.out.println("cell.getCellNumericValue");
		    	  
		      }
		      
		      else if(Cell.CELL_TYPE_STRING == cell.getCellType()) {
		    	  
		    	  System.out.println("cell.getCellStringValue");
		    	  
		      }
		

	}

}
