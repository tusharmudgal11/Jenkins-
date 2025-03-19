package AdvanceSeleniumPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class WriteDataOnExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		
		 Workbook book = WorkbookFactory.create(file);
		 Sheet sheet = book.getSheet("Sheet1");
		    Row row = sheet.createRow(0);
		    Cell cell = row.createCell(0);
		    cell.setCellValue("Nike");
		   FileOutputStream fos = new FileOutputStream("./src/test/resources/ExcelData.xlsx");
		   book.write(fos);
		   book.close();
		   

	}

}
