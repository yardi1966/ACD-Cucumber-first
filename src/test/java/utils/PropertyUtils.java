package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

	//static method so you do not need to create an object of the class
	//Properties is a Java class used to read the properties file
	public static Properties propertyUtils(String filePath) {
		
		System.out.println("inside the propertyUtils method in PropertyUtils class");
		
		//create object of the properties class
		Properties prop = new Properties();
		
		//to read the data we need a buffered reader object
		BufferedReader reader = null;
		
		//create the reader object of the class and specifying the file path
		try {
			reader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//now load the data to the properties object
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
}
