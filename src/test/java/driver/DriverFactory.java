package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.FrameworkConstants;

//handles setup and management of our browsers driver

public class DriverFactory {
	
	
	//method to create static driver method so you can call it without creating an object of it
	public static WebDriver initDriver(String browserName) {
		
		System.out.println("inside the initDriver method in DriverFactory class");
		
		WebDriver driver = null;
		
		switch (browserName) {
		
		case FrameworkConstants.CHROME_BROWSER:
			driver = new ChromeDriver();
			break;
		
		case FrameworkConstants.FIREFOX_BROWSER:
			driver = new FirefoxDriver();
			break;
			
		default:
			//in case of a wrong browser name
			throw new IllegalStateException("Invalid Browser name");
			
		}
		 return driver;
	}

}
