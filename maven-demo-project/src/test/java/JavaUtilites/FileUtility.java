package JavaUtilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	public String getCommonData(String key) throws Throwable
	{
	FileInputStream  file = new FileInputStream("./src/test/resources/OrganisationLogin");
	Properties p = new  Properties();
	    p.load(file);
	    
	    String value = p.getProperty(key);
	    return (value);
	}

}
