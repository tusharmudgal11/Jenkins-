package AdvanceSeleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import JavaUtilites.CreateJavaUtiles;
import JavaUtilites.ExcelUtil;
import JavaUtilites.WebDriverUtility;

public class CreateOrganization {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		 FileInputStream  file = new FileInputStream("./src/test/resources/OrganisationLogin");
			Properties p = new  Properties();
			    p.load(file);
			    String admin =  p.getProperty("user_name");
			    String password = p.getProperty("password");
			    String brow = p.getProperty("browser");
			    String Url = p.getProperty("URL");
			    WebDriver driver;
		  if(brow.equalsIgnoreCase("chrome")) {
			  driver = new ChromeDriver();
		  }
		  else if(brow.equalsIgnoreCase("Edge"))
		  {
			  driver = new EdgeDriver();
		  }
		  else if (brow.equalsIgnoreCase("FireFox"))
		  {
			  driver = new FirefoxDriver();
		  }
		  else
		  {
			  driver = new ChromeDriver();
		  }
		  
		    WebDriverUtility fibs = new WebDriverUtility();
		    fibs.MaximizeWindow(driver);
		    fibs.loadTheElement(driver);
		    driver.get(Url);
		    driver.findElement(By.name("user_name")).sendKeys(admin);
		    driver.findElement(By.name("user_password")).sendKeys(password);
		    driver.findElement(By.id("submitButton")).click();
		    driver.findElement(By.linkText("Organizations")).click();
		    driver.findElement(By.xpath("//td[@style = 'padding-right:0px;padding-left:10px;']")).click();
		    CreateJavaUtiles obj = new CreateJavaUtiles();
		   int ranNum = obj.getRandom();
		   ExcelUtil ob = new ExcelUtil();
		           String orgName     = ob.getExcelValue("Organisation", 0, 0)+ranNum;
		    
//...........................Take Data From Excel.............................................................................................		    
		    
                   //  FileInputStream fio = new FileInputStream("./src/test/resources/ExcelData.xlsx");
                   //  Workbook book = WorkbookFactory.create(fio);
                   //  org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Organisation");
                   //  Row row = sheet.getRow(0);
                  //   Cell cell = row.getCell(0);
                   // String orgName = cell.getStringCellValue()+ranNum;
                  ///  System.out.println(orgName);
		   
                    driver.findElement(By.name("accountname")).sendKeys(orgName);
                    
//.....................PhoneNumber...................................................................................................................
                          String phonnum1 = ob.ReadDataUsingDataFormatter("Organisation", 1, 0);
                            driver.findElement(By.name("phone")).sendKeys(phonnum1);          
 //..................MailId.........................................................................................................................                    
                 //  Row row2= sheet.getRow(2);
                 //  Cell cell2 = row2.getCell(0);
                //  String mailid = cell2.getStringCellValu()
                     String mailid  = ob.getExcelValue("Organisation", 2, 0);
                  //System.out.println(mailid);
                  driver.findElement(By.name("email1")).sendKeys( mailid);
                  
//......................SaveDetails..................................................................................................................
                     driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
    
//.......................Check Organisation is save or not...........................................................................................
                      Thread.sleep(9000);
                     String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
                        if(actData.contains(orgName))
                        {
                        	System.out.println("Organisation Created");
                        }
                        else {
                        	System.out.println("Organisation is not Created");
                        }
                        driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']")).click();
                        driver.findElement(By.linkText("Sign Out")).click();
	
	}

}
