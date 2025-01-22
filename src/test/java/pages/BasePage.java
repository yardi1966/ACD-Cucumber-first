package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//create an object of the webdriver wait class
	private WebDriverWait wait;
	
	//create a reference of the webdriver
	public WebDriver driver;
	
	//create a constructor for this base page class
	public BasePage (WebDriver d) {
		
		System.out.println("inside the BasePage constructor in BasePage class");
		//map the driver object to the object we will pass at runtime
		driver = d;
		//next create an object of the webdriver wait class
		wait = new WebDriverWait(d, Duration.ofSeconds(10));
		//since we are using the pagefactory pattern for managing our page classes we will call page factory initElements() method
		//we will pass the driver object and "this" which represents the current class object
		PageFactory.initElements(d, this);
	}
	
	//button click common method
	public void click(WebElement element) {
		
		System.out.println("inside the click method in BasePage class");
		
		//after element is clickable we will click it
		waitForClicking(element).click();;		
	}
	
	//now we need a method to enter value into a text box
	public void enterValue(WebElement element, String value) {
		
		System.out.println("inside the enterValue method in BasePage class");
		
		//wait for element to be visible
		waitForElementToBeVisible(element);
		//then clear the text box
		element.clear();
		//next enter data passed
		element.sendKeys(value);
		
	}
	
	//before we can click on any element we need to wait for it to be visible
	private WebElement waitForClicking(WebElement element) {
		
		System.out.println("inside the waitForClicking method in BasePage class");
		return wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	
	//before entering a value into a text box we need to wait for it to be visible
	private WebElement waitForElementToBeVisible(WebElement element) {
		
		System.out.println("inside the waitForElementToBeVisible method in BasePage class");
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

}
