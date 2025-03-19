package AdvanceSeleniumPractice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import JavaUtilites.CreateJavaUtiles;
import JavaUtilites.FileUtility;
import JavaUtilites.WebDriverUtility;

public class CreateCampaginWithProduct {

	public static void main(String[] args) throws Throwable
	{

		//FileInputStream  file = new FileInputStream("./src/test/resources/OrganisationLogin");
		//Properties p = new  Properties();
		  //  p.load(file);
		     FileUtility flib = new FileUtility();
		     WebDriverUtility fos1 = new WebDriverUtility();
		     CreateJavaUtiles ob = new CreateJavaUtiles();
		    String admin =  flib.getCommonData("username");
		    String password = flib.getCommonData("password");
		    String brow = flib.getCommonData("browser");
		    String Url = flib.getCommonData("URL");
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
	  
	    driver.get(Url);
	    driver.manage().window().maximize();
	    driver.findElement(By.name("user_name")).sendKeys(admin);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	    driver.findElement(By.id("submitButton")).click();
	    driver.findElement(By.linkText("Products")).click();
	    driver.findElement(By.xpath("//img[@src = 'themes/softed/images/btnL3Add.gif']")).click();
	        int ranNum=  ob.getRandom();
	    
	    FileInputStream fos = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		   Workbook book = WorkbookFactory.create(fos);
		    Sheet sheet = book.getSheet("Product");
		    Row row = sheet.getRow(0);
		    Cell cell = row.getCell(0);  
		    String product = cell.getStringCellValue()+ranNum;
		    System.out.println(product);
		    
		    driver.findElement(By.name("productname")).sendKeys(product);
		    driver.findElement(By.xpath("//input[@title= 'Save [Alt+S]']")).click();
 
			//.............................................go to campagine page.....................................................................//
		      
			 driver.findElement(By.linkText("More")).click();
			 driver.findElement(By.name("Campaigns")).click();
			 driver.findElement(By.xpath("//img[@src = 'themes/softed/images/btnL3Add.gif']")).click();
			Sheet sheet1 = book.getSheet("Campaigns");
		        Row row1= sheet1.getRow(0);
		        Cell cell1 = row1.getCell(0);
		        String Camp1 = cell1.getStringCellValue();
		        System.out.println(Camp1);
		   driver.findElement(By.name("campaignname")).sendKeys(Camp1);
		   driver.findElement(By.xpath("//img[@src = 'themes/softed/images/select.gif']")).click();
		    fos1.windowSwitch(driver, "Products&action");
             Thread.sleep(1000);
		   driver.findElement(By.name("search_text")).sendKeys(product);
		   driver.findElement(By.name("search")).click();
		   Thread.sleep(9000);
		   driver.findElement(By.xpath("//a[text()='"+product+"']")).click();
		   fos1.windowSwitch(driver, "Campaigns&action");
			
		
			
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			 WebElement campcreate = driver.findElement(By.xpath("//span[@id = 'dtlview_Campaign Name']"));
		      String activname = campcreate.getText();
			if(activname.contains(Camp1))
		      {
		    	  System.out.println("Campagine created");
		      }
		      else
		      {
		    	  System.out.println("Campagine not created");
		      }
		      driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']")).click();
	          driver.findElement(By.linkText("Sign Out")).click();
		}


	}
	      
	    
			 
	



			       
			  
		

	


