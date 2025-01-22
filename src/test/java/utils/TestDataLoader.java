package utils;

import java.util.Properties;

import constants.FrameworkConstants;

//responsible for handling all the test data

//we only need to call the object of the class once. to prevent multiple objects of the class we will use the singleton design pattern
//only one object can be created
public class TestDataLoader {
	
	//reference variable of this class needs to be private and static. only available inside this class
	private static TestDataLoader testDataLoader;
	
	//we need this reference variable anywhere in the project so we need a get instance method
	//to return an instance of this class
	public static TestDataLoader getInstance() {
		
		System.out.println("inside the getInstance method in TestDataLoader class");
		
		//now create an instance of this class
		//if instance of this class is not already created, then create it
		if (testDataLoader == null) {
			testDataLoader = new TestDataLoader();
		}
		//now return the instance
		return testDataLoader;
	}
	
	//*********************************************
	
	//create a properties object to store the data
	Properties prop;
	
	//now we need to read the data from the properties file
	//load data based on the environment
	//we will put that in the constructor
	private TestDataLoader() {
		
		System.out.println("inside the TestDataLoader constructor in TestDataLoader class");
		
		switch (FrameworkConstants.ENVIRONMENT) {
		case "QA":
			prop = PropertyUtils.propertyUtils(FrameworkConstants.QA_TEST_DATA_FILE);
			break;
			
		case "Prod":
			prop = PropertyUtils.propertyUtils(FrameworkConstants.PROD_TEST_DATA_FILE); 
			break;
			
		default:
			break;
		}
		
	}
	
	//*********************************************
	
	//now create getter methods
	//get the application url
	public String getAppURL() {
		
		System.out.println("inside the getAppURL method in TestDataLoader class");
		return prop.getProperty("appurl");
	}
	
	//*********************************************
	
	//get the username from the properties file using the key
	public String getUserName() {
		
		System.out.println("inside the getUserName method in TestDataLoader class");
		return prop.getProperty("uname");
	}
	
	//*********************************************
	
	//get the password from the properties file using the key
	public String getPassword() {
		
		System.out.println("inside the getPassword method in TestDataLoader class");
		return prop.getProperty("pword");
	}
}
