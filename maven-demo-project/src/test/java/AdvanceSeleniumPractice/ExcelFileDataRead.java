package AdvanceSeleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileDataRead {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("./src/test/resources/Book1test.xlsx");
		
	    Workbook book = WorkbookFactory.create(file);
	    
	    
	    Sheet sheet = book.getSheet("Sheet1");
	    Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	    String excelData = cell.getStringCellValue();
	    System.out.println(excelData);
	    
	    
		

	}

}
