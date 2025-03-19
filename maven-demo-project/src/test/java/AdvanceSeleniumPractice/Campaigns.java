package AdvanceSeleniumPractice;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

public class Campaigns {

	public static void main(String[] args) throws IOException
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
	  
	    driver.get(Url);
	    driver.manage().window().maximize();
	    driver.findElement(By.name("user_name")).sendKeys(admin);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	    driver.findElement(By.id("submitButton")).click();
	    Actions a = new Actions(driver);
	   WebElement ele = driver.findElement(By.linkText("More"));
	   a.moveToElement(ele).perform();
	   driver.findElement(By.name("Campaigns")).click();
	   driver.findElement(By.xpath("//img[@src= 'themes/softed/images/btnL3Add.gif']")).click();
	   FileInputStream fos = new FileInputStream("./src/test/resources/ExcelData.xlsx");
	   Workbook book = WorkbookFactory.create(fos);
	    Sheet sheet = book.getSheet("Campaigns");
	    Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	    String camp = cell.getStringCellValue();
	    System.out.println(camp);
	    driver.findElement(By.name("campaignname")).sendKeys(camp);
	    driver.findElement(By.xpath("//input[@title= 'Save [Alt+S]']")).click();
	    WebElement campcreate = driver.findElement(By.xpath("//span[@id = 'dtlview_Campaign Name']"));
	      String activname = campcreate.getText();
	      if(activname.contains(camp))
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
