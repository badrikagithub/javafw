package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods related to Java
 * @author Chaitra M
 *
 */
public class JavaUtility {
	
	/**
	 * This method will return the current system date in specified format
	 * @return
	 */
	public String getSystemDateInFormat() 
	{
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String currentdate = formatter.format(d);
		return currentdate;
	}
	
	/**
	 * This method will generate a random number for every run
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
		int value = r.nextInt(10000);
		return value;
		
	}

}
