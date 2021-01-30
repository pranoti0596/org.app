package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readsimpleinterestExcel {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream file = new FileInputStream("E://Pragati.xlsx");
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowiterator = sheet.iterator();
		
		while(rowiterator.hasNext()) {
			
			}
		
		   Row row = rowiterator.next();
		   
		   Iterator<Cell> cellIterator =row.cellIterator();
		   
		   while(cellIterator.hasNext()) {
			   
		   }
		   
		   Cell cell = cellIterator.next();
		   
		   
		    if(Cell.CELL_TYPE_NUMERIC == cell.getCellType()){
			   
			   System.out.println("cell.getNumericValue");
			   
			   
		   }if(Cell.CELL_TYPE_STRING == cell.getCellType()) {
			   
			   System.out.println("cell.getStringValue");
			   
		   }
		   
		  // else(Cell.CELL_TYPE_FORMULA:)
			   
			   
		   }
		
		
		

	}


