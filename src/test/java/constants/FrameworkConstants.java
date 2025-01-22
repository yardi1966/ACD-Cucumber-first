package constants;


//manage all the constants for this project

public class FrameworkConstants {
	
	
	//path of the config properties file
	public static final String CONFIG_FILE_PATH = "src/test/resources/config/config.properties";
	//path of prod test data file
	public static final String PROD_TEST_DATA_FILE = "src/test/resources/config/prod_test_data.properties";
	//path of qa test data file
	public static final String QA_TEST_DATA_FILE = "src/test/resources/config/qa_test_data.properties";
	
	//variables for browser names
	public static final String CHROME_BROWSER = "Chrome";
	public static final String FIREFOX_BROWSER = "Firefox";
	
	//variables for environment and browser which we will read from the config.properties file at runtime
	public static String ENVIRONMENT;
	public static String BROWSER;
	
	//variable for explicit wait time
	public static final int EXPLICIT_WAIT_TIME = 10;
	

}
