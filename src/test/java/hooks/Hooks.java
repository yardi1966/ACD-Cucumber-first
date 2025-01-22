package hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import constants.FrameworkConstants;
import driver.DriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utils.PropertyUtils;
import utils.TestDataLoader;

public class Hooks {
	
	//create a reference of the webdriver
	public static WebDriver driver;
	
	//before hook method
	@BeforeAll
	public static void beforeHooks() {
		
		System.out.println("inside the beforeHooks method in Hooks class");
		//load data from properties file and store in the properties object
		Properties properties = PropertyUtils.propertyUtils(FrameworkConstants.CONFIG_FILE_PATH);
		//get the browser data from the properties object
		FrameworkConstants.BROWSER = properties.getProperty("browser");
		//get the environment data from the properties object
		FrameworkConstants.ENVIRONMENT = properties.getProperty("environment");
		
		//first create the driver object and launch the browser
		driver = DriverFactory.initDriver(FrameworkConstants.BROWSER);
		
		System.out.println("Open the Page to test URL");
		//open application URL
		driver.get(TestDataLoader.getInstance().getAppURL());
		
	}
	
	//after hook method
	@AfterAll
	public static void afterHooks() {
		System.out.println("inside the afterHooks method in Hooks class");
		//close the browser
		driver.quit();
		
	}

}
