package AdvanceSeleniumPractice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DataDrivingOutput {

	public static void main(String[] args) throws IOException 
	{
		Properties p = new Properties();
		p.setProperty("Url", "https://www.bigbasket.com/");
		p.setProperty("Url", "https://www.google.co.uk/");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/BrowserChange.properties");
		p.store(fos, "commandata");
		p.store(fos, "CommanData");
	
	}

}
