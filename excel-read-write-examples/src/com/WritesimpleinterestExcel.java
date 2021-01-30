package com;


import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritesimpleinterestExcel {

	public static void main(String[] args) throws IOException  {
		
		
		
			XSSFWorkbook workbook = new XSSFWorkbook();
		
		
		XSSFSheet sheet = workbook.createSheet("Calculate simple Interest");
		
		
		Row header = sheet.createRow(0);
		
		header.createCell(0).setCellValue("Principle");
        header.createCell(1).setCellValue("ROI");
        header.createCell(2).setCellValue("T");
        header.createCell(3).setCellValue("Iterest(p r T)");
        
        
        Row datarow = sheet.createRow(1);
		
        datarow.createCell(0).setCellValue(15000d);
        datarow.createCell(1).setCellValue(9.5);
		datarow.createCell(2).setCellValue(4d);
		datarow.createCell(3).setCellFormula("A2*B2*C2");
		
		
	
			FileOutputStream	ios = new FileOutputStream("E://Pragati.xlsx");
			
			 workbook.write(ios);
			 
			 ios.close();
			 
			 System.out.println("Excel with formula cell written Successfully");
			
			
		
		

	}

}
