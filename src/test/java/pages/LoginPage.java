package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	// constructor
	public LoginPage(WebDriver d) {
		super(d);
		//call initElements method with driver object and "this" which is the current object of the current class
		PageFactory.initElements(d, this);

	}

	// create locators for login page

	// username locator
	@FindBy(name = "username")
	//create a reference variable
	private WebElement userName;

	// password locator
	@FindBy(name = "password")
	private WebElement password;

	// login button locator
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login;

	// now we need methods to perform the actions

	// enter username
	public void enterUserName(String value) {

		System.out.println("inside the enterUserName method in LoginPage class");
		// to enter a value we have a method in the base page class
		enterValue(userName, value);
	}

	// enter password
	public void enterPassword(String value) {

		System.out.println("inside the enterPassword method in LoginPage class");
		// to enter a value we have a method in the base page class
		enterValue(password, value);
	}
	
	//method to click on the login button
	public void clickOnLogin() {
		
		System.out.println("inside the clickOnLogin method in LoginPage class");
		//call method click from base page class
		click(login);
	}
}
