package stepdefinitions;

import static org.testng.Assert.assertEquals;


import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utils.TestDataLoader;

public class LoginSteps {
	
	//create object of the login page class to use the methods
	LoginPage loginPage;
	
	@Given("User enters valid username")
	public void user_enters_username() {
		
		//create object of login page and specify the driver object from the Hooks class
		loginPage = new LoginPage(Hooks.driver);
		System.out.println("inside the User enters valid username step");
		//now enter the username
		loginPage.enterUserName(TestDataLoader.getInstance().getUserName()); 	
	}										
	
	//*********************************************
	
	@And("User enters valid password")
	public void user_enters_password() {
		
		System.out.println("inside the User enters valid password step");
		//now enter password
		loginPage.enterPassword(TestDataLoader.getInstance().getPassword());
	}										
	
	//*********************************************
	
	@And("user clicks on Login button")
	public void user_clicks_on_login() {
		
		System.out.println("inside the user clicks on Login button step");
		//now click on login button
		loginPage.clickOnLogin();
	}
	
	//*********************************************
	
	@Then("Home page will be displayed")
	public void home_page_is_displayed() throws InterruptedException {
		
		//validate the home page is displayed
		
		System.out.println("inside the Home page will be displayed step");
		
		//expected url
		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
		//actual url
		String actualURL = Hooks.driver.getCurrentUrl();
		Thread.sleep(3000);;
		//compare current URL to expected
		assertEquals(actualURL, expectedURL);
		
	}
}
