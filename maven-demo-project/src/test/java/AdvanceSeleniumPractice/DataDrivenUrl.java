package AdvanceSeleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenUrl {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/BrowserChange.properties");
		Properties pos = new Properties();
		pos.load(fis);
		String Url = pos.getProperty("Url");
		WebDriver driver = new ChromeDriver();
		driver.get(Url);

	}

}
