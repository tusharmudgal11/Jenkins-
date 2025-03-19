package AdvanceSeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IphoneColor {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(9000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 16"+Keys.ENTER);
	List<WebElement> coloriphone = driver.findElements(By.xpath("//div[@cel_widget_id= \"MAIN-SEARCH_RESULTS-5\"]/../..//div[@class = \"puisg-col puisg-col-4-of-12 puisg-col-8-of-16 puisg-col-12-of-20 puisg-col-12-of-24 puis-list-col-right\"]/..//div[@class=\"a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view\"]//a"));
		for(WebElement coloriphones:coloriphone)
		{
			System.out.println(coloriphones.getAttribute("aria-label"));
		}

	}

}
