package AdvanceSeleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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

public class CreateProductandDelete {

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
	    driver.findElement(By.linkText("Products")).click();
	    driver.findElement(By.xpath("//img[@src = 'themes/softed/images/btnL3Add.gif']")).click();
	    Random ran = new Random();
	   int ranNum = ran.nextInt(1000);
	    FileInputStream fos = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		   Workbook book = WorkbookFactory.create(fos);
		    Sheet sheet = book.getSheet("Product");
		    Row row = sheet.getRow(0);
		    Cell cell = row.getCell(0);  
		    String product = cell.getStringCellValue()+ranNum;
		    System.out.println(product);
		    driver.findElement(By.name("productname")).sendKeys(product);
		    driver.findElement(By.xpath("//input[@title= 'Save [Alt+S]']")).click();
		    WebElement ele = driver.findElement(By.xpath("//span[@id = 'dtlview_Product Name']"));
		     String title=ele.getText();
		     if(title.contains(product))
		     {
		    	 System.out.println("Product Created");
		     }
		     else {
		    	 System.out.println("Product not Created");
		     }
		     
		     driver.findElement(By.linkText("Products")).click();
		     
//		 	driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='Product Name']/../preceding-sibling::td[@class='lvtCol']//input[@type=\"checkbox\"]")).click();

				driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" +product
						+ "']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
				driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();

				driver.switchTo().alert().accept();

//			WebElement data = driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+PrdName+"']"));
		//	
//			if(data.equals(PrdName))
//			{
//				System.out.println("product name is present");
//			}
//			else
//			{
//				System.out.println("product name is not present");
//			}

				List<WebElement> prdList = driver
						.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));

				boolean flag = false;
				for (WebElement prd : prdList) {

					String actData = prd.getText();
					if (actData.contains(product)) {
						flag = true;
						break;
					}
				}
				if (flag) {
					System.out.println("Product name is deleted");
				}

				else {
					System.out.println("Product name is not deleted");
				}

			}
		

	}


