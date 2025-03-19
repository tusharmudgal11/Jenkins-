package JavaUtilites;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility 
{
	public void MaximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void loadTheElement(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void windowSwitch (WebDriver driver,String partialTitle)
	{
		Set<String> allWins1 = driver.getWindowHandles();
		Iterator<String> it1 = allWins1.iterator();

		while (it1.hasNext()) {
			String win11 = it1.next();
			driver.switchTo().window(win11);
			String title1 = driver.getTitle();
			if (title1.contains("partialTitle")) {
				break;
			}
		}
		
	}
	
	

}
