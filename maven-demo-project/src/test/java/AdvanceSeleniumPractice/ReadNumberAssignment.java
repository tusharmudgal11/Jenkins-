package AdvanceSeleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadNumberAssignment {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream  fos = new FileInputStream("./src/test/resources/Book1test.xlsx");
		Workbook book = WorkbookFactory.create(fos);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		DataFormatter format = new DataFormatter();
		String exceldata = format.formatCellValue(cell);
		System.out.println(exceldata);
	}
}
