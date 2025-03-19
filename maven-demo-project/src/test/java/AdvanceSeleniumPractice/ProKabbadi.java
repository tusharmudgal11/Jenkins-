package AdvanceSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadi {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		driver.findElement(By.xpath("//button[@class = \"onetrust-close-btn-handler banner-close-button ot-close-icon\"]")).click();
		String Teamname = "Jaipur Pink Panthers";
		String elel = driver.findElement(By.xpath("//p[text()= '"+Teamname+"']/../../../..//div[@class = \"table-data matches-won\"]")).getText();
		String ele2 = driver.findElement(By.xpath("//p[text() = '"+Teamname+"']/../../../..//div[@class = \"table-data matches-lost\"]")).getText();
		String ele3 = driver.findElement(By.xpath("//p[text() = '"+Teamname+"']/../../../..//div[@class = \"table-data score-diff\"]")).getText();
         System.out.println("Won of "+Teamname+" "+elel);
         System.out.println("Loss Of "+Teamname+" "+ele2);
         System.out.println("Pts of "+Teamname+" "+ele3);
         
         
	}

}
