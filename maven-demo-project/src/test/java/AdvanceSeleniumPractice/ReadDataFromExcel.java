package AdvanceSeleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
           FileInputStream file = new FileInputStream("./src/test/resources/ExcelData.xlsx");
           Workbook book = WorkbookFactory.create(file);
            org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Sheet1");
          int rowNum = sheet.getLastRowNum();
          for(int i=0;i<rowNum;i++)
          {
        	  Row row = sheet.getRow(i);
        	  Cell cell = row.getCell(0);
        	  String links = cell.getStringCellValue();
        	  System.out.println(links);
          }
          

	}

}
