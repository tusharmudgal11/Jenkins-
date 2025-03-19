package AdvanceSeleniumPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKartAllLinkInExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream file = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		
		 Workbook book = WorkbookFactory.create(file);
		  org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Sheet1");
		 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		List<WebElement> ele = driver.findElements(By.xpath("//a"));
		
		for(int i =0;i<ele.size();i++)	
		{
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(ele.get(i).getAttribute("href"));
           String linkexceldata =  cell.getStringCellValue();
           System.out.println(linkexceldata);
			
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/ExcelData.xlsx");
		book.write(fos);
		book.close();




		 
		

	}

}
