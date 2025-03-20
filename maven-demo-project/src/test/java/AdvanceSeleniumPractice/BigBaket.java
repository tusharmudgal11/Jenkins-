package AdvanceSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBaket {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder = 'Search for Products...']")).sendKeys("Apple");
		System.out.println("got it");
		System.out.println("Pull Req");
	

	}

}
