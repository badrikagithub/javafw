package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//singleline comment
/*multi line comment*/

/**
 * This class consist of re usable methods related to property file
 * @author Chaitra M
 *
 */
public class PropertyFileUtility {
	
	/**
	 * This method will read data from propertyFile for the key provided by caller
	 * and return the value to caller
	 * @param key
	 * @return value
	 * @throws IOException
	 * 
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

}
