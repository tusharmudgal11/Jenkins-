package AdvanceSeleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DataDriven {

	public static void main(String[] args) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Tushar\\OneDrive\\Desktop\\QC_SD13\\maven-demo-project\\Browser.properties");
		Properties p = new Properties();
		p.load(file);
       String Browser = p.getProperty("browser");
       String Url = p.getProperty("url");
       WebDriver driver;
       if(Browser.equalsIgnoreCase("chrome")) {
    	   driver = new ChromeDriver();
       }
       else if (Browser.equalsIgnoreCase("Edge")) {
    	   driver = new EdgeDriver();
       }
       else {
    	   driver = new ChromeDriver();
       }
       driver.get(Url);
       
        
        
		

	}

}
