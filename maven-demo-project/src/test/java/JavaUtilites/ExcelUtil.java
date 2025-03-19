package JavaUtilites;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil 
{
	public static  String getExcelValue(String sheetName,int rowNum, int cellNum) throws EncryptedDocumentException, IOException 
	
	{
		FileInputStream fio = new FileInputStream("./src/test/resources/ExcelData.xlsx");
        Workbook book = WorkbookFactory.create(fio);
        org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Organisation");
        Row row = sheet.getRow( rowNum);
        Cell cell = row.getCell( cellNum);
       String orgName = cell.getStringCellValue();
       System.out.println(orgName);
       return orgName;
		
	}
	public static String ReadDataUsingDataFormatter(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fio = new FileInputStream("./src/test/resources/ExcelData.xlsx");
        Workbook book = WorkbookFactory.create(fio);
        org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Organisation");
        Row row = sheet.getRow( rowNum);
        Cell cell = row.getCell( cellNum);
        DataFormatter format = new DataFormatter();
        String ExcelData = format.formatCellValue(cell);
        System.out.println(ExcelData);
        return ExcelData;
		
	}

}
