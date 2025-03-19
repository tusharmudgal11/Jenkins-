package AdvanceSeleniumPractice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.opentelemetry.sdk.metrics.internal.state.ObjectPool;

public class ReadDataFromJson {

	public static void main(String[] args) throws IOException 
	{
		File file = new File("./src/test/resources/Browser.json");
		  ObjectMapper obj = new ObjectMapper();
		  JsonNode data = obj.readTree(file);
		  String brow = data.get("browser").asText();
		  String url = data.get("url").asText();
		  String user_name = data.get("user_name").asText();
		  String password = data.get("password").asText();
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
		  driver.findElement(By.id("user-name")).sendKeys(user_name);
		  driver.findElement(By.id("password")).sendKeys(password);
		  driver.findElement(By.id("login-button")).click();
		

	}

}
