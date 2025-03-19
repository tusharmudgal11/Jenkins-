package JavaUtilites;

import java.util.Random;

public class CreateJavaUtiles
{
	public static int getRandom()
	{
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return(random);
	}
	            

}
