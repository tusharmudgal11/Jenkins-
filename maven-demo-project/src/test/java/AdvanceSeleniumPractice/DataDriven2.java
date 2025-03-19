package AdvanceSeleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDriven2 {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream file = new FileInputStream("./src/test/resources/DrivenFile.properties");
		   Properties   p = new Properties();
		   p.load(file);
		  String brow =  p.getProperty("Browser");
		  String url = p.getProperty("Url");
		  String userName = p.getProperty("userName");
		  String Password = p.getProperty("password");
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
		  driver.get(url);
		  driver.findElement(By.id("user-name")).sendKeys(userName);
		  driver.findElement(By.id("password")).sendKeys(Password);
		  driver.findElement(By.id("login-button")).click();

	}

}
