package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: Open the document in Java Readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create an Object properties class from Java.util
		Properties p = new Properties();
		
		//Step 3: load the input stream into properties
		p.load(fis);
		
		//Step 4: provide the keys to read the values
		String value = p.getProperty("username");
		System.out.println(value);
		
		String value1 = p.getProperty("password");
		System.out.println(value1);
		
		
	}

	
}
